package com.agile.login.service.impl;

import com.agile.login.service.ILoginService;
import org.springframework.stereotype.Service;

/**
 * @author :  huangximing
 * @Description :
 * @Creation Date:  2018/5/29
 */
@Service
public class LoginService implements ILoginService {
  /* @Autowired
   SysUserMapper sysUserMapper;

    @Override
    public LoginUser sign(String userName, String password) {
        if (StringUtil.isEmpty(userName)) {
            throw new OrientServiceProcessException("用户名不可为空");
        }
        if (StringUtil.isEmpty(password)) {
            throw new OrientServiceProcessException("密码不可为空");
        }
        SysUser sysUser = sysUserMapper.selectOne(SysUser.builder().username(userName).password(password).build());
        if (sysUser == null) {
            throw new OrientServiceProcessException("用户名密码错误");
        }
        String token=JWTUtil.sign(userName,password,String.valueOf(sysUser.getUserId()));
        LoginUser loginUser=LoginUser.builder().sysUser(sysUser).token(token).build();
        return loginUser;
    }*/



}
