/**
 * @Project Name :  mainserver
 * @Package Name :  com.agile.web
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-24 1:44 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.web.base;

import com.agile.web.enums.StateEnum;
import com.agile.web.exception.OrientServiceProcessException;
import com.agile.web.result.OrientRestfulResp;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;

/**
 * @author :  panduanduan
 * @Description :  TODO
 * @Creation Date:  2018-01-24 1:44 PM
 */
@Transactional(rollbackFor = {Exception.class})
@Slf4j
public class BaseController {



    /**
     * 处理返回值
     *
     * @param processor
     * @return
     */
    protected OrientRestfulResp restProcessor(ResultProcessor processor) {
        OrientRestfulResp result = null;
        try {
            result = processor.process();
        } catch (OrientServiceProcessException e1) {
            log.error("ServiceProcess Error Log :" + e1.getLocalizedMessage(), e1);
            result = OrientRestfulResp.builder().status(StateEnum.ERROR.getState()).error(e1.getMessage()).build();
        } catch (Exception e) {
            log.error("Error Log :" + e.getLocalizedMessage(), e);
            result = OrientRestfulResp.builder().status(413).error("服务器出现异常").build();
        }
        return result;
    }

    /**
     * 数据转化
     *
     * @param binder
     * @throws Exception
     */
    @InitBinder
    protected void initBinder(ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }
}