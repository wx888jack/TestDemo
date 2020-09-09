package com.agile.web.exception;

import com.agile.web.enums.StateEnum;
import com.agile.web.result.OrientRestfulResp;
import lombok.extern.slf4j.Slf4j;
/*import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;*/
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ximing huang
 * @Date: 2018/7/16 17:46
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public OrientRestfulResp handle(Exception e){
            if (e instanceof OrientServiceProcessException) {
                OrientServiceProcessException orientServiceProcessException = (OrientServiceProcessException) e;
                return  OrientRestfulResp.builder().status(StateEnum.ERROR.getState()).error(orientServiceProcessException.getMessage()).build();
            }else if(e instanceof UnauthenticatedException){
                return  OrientRestfulResp.builder().status(499).error("登录异常").build();
            } else if(e instanceof UnauthorizedException){
                return  OrientRestfulResp.builder().status(StateEnum.UNAUTHORIZED.getState()).error("没有该权限").build();
            }else {
                log.info("系统异常{}", e.getLocalizedMessage());
                return OrientRestfulResp.builder().status(413).error(e.getMessage()).build();
            }

    }


}



