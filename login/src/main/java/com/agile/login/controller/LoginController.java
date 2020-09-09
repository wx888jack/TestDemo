package com.agile.login.controller;

import com.agile.login.service.ILoginService;
import com.agile.persistent.po.LoginUser;
import com.agile.web.base.BaseController;
import com.agile.web.enums.StateEnum;
import com.agile.web.result.OrientRestfulResp;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author :  huangximing
 * @Description :
 * @Creation Date:  2018/5/29
 */
@RestController
@CrossOrigin("*")
public class LoginController extends BaseController {

  /* @Autowired
    ILoginService loginService;

    @ApiOperation("新增")
    @ApiImplicitParams({
    })
    @PutMapping("/login")
    public OrientRestfulResp saveParents(@RequestBody SysUser sysUser) {
        OrientRestfulResp retVal = restProcessor(() -> {
            loginService.save(sysUser);
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data("添加成功").build();
        });
        return retVal;
    }


    @ApiOperation("登录")
    @PostMapping("/login")
    public OrientRestfulResp sign(String userName, String password) {
        OrientRestfulResp retVal = restProcessor(() -> {
            LoginUser loginUser = loginService.sign(userName, password);
            return OrientRestfulResp.builder().status(StateEnum.SUCCESS.getState()).data(loginUser).build();
        });
        return retVal;
    }*/

}
