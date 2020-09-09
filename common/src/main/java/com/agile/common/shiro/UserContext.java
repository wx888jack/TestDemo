/**
 * @Project Name :  SchoolBus_Server
 * @Package Name :  com.orient.common.shiro
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-04-12 11:38 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.common.shiro;

import com.agile.common.tools.JWTUtil;
import com.github.pagehelper.StringUtil;
import com.agile.common.tools.JWTUtil;
import org.apache.shiro.SecurityUtils;

/**
 * @author :  ximing huang
 * @Description :  TODO
 * @Creation Date:  2018-04-12 11:38 AM
 */
public class UserContext {

    public static String getCurrentUserName() {
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        if (!StringUtil.isEmpty(token)) {
            String username = JWTUtil.getUsername(token);
            return username;
        }
        return "";
    }

    public static Integer getCurrentUserId() {
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        if (!StringUtil.isEmpty(token)) {
            Integer userId = JWTUtil.getUserId(token);
            return userId;
        }
        return 0;
    }
}