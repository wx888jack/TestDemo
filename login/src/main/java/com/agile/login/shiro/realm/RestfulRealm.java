/**
 * @Project Name :  SchoolBus_Server
 * @Package Name :  com.orient.config.shiro.realm
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-04-11 11:28 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.login.shiro.realm;

import com.agile.common.tools.JWTUtil;
import com.agile.login.shiro.jwt.JWTToken;
import com.agile.web.exception.OrientServiceProcessException;
import com.github.pagehelper.StringUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :  panduanduan
 * @Description :  TODO
 * @Creation Date:  2018-04-11 11:28 AM
 */

@Service
public class RestfulRealm extends AuthorizingRealm {

   private static final Logger LOGGER = LogManager.getLogger(RestfulRealm.class);

 /*   @Autowired
    private SysUserMapper sysUserMapper;*/


    //必须重写此方法否则会shiro会报错
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    //需要检测用户权限的时候才能调用此方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;


     /*   String token=(String)principals.getPrimaryPrincipal();
        String id=JWTUtil.getUserId(token);
        List<String> permsList=sysUserMapper.findAllPerms(Integer.parseInt(id));
        Set<String> permission = new HashSet<>();
        for(String perms :permsList){
            if(StringUtil.isEmpty(perms)){
                continue;
            }
            permission.addAll(Arrays.asList(perms.trim().split(",")));
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
       // simpleAuthorizationInfo.addStringPermissions(permission);
        simpleAuthorizationInfo.setStringPermissions(permission);
        return simpleAuthorizationInfo;*/
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        return null;

      /*  String token = (String) auth.getCredentials();
        //TODO 并发量大后 可采用缓存进行用户校验
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new OrientServiceProcessException("token invalid");
        }

        SysUser sysUser = sysUserMapper.selectOne(SysUser.builder().username(username).build());
        if (sysUser == null) {
            throw new OrientServiceProcessException("User didn't existed!");
        }

        if (!JWTUtil.verify(token, username, sysUser.getPassword())) {
            throw new OrientServiceProcessException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "restfulRealm");
        */
    }

}