/**
 * @Project Name :  base
 * @Package Name :  com.agile.controller
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-22 4:47 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.ping;

import com.agile.web.base.BaseController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  panduanduan
 * @Description :  心跳检测
 * @Creation Date:  2018-01-22 4:47 PM
 */
@RestController
@CrossOrigin("*")
public class PingController extends BaseController {

    @GetMapping("/")
    public String shake() {
        String str="欢迎你";
        return str;
    }


}