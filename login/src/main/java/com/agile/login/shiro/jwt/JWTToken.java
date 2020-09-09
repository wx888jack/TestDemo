/**
 * @Project Name :  SchoolBus_Server
 * @Package Name :  com.orient.shiro.jwt
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-04-11 11:34 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.login.shiro.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author :  panduanduan
 * @Description :  TODO
 * @Creation Date:  2018-04-11 11:34 AM
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}