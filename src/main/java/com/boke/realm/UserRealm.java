package com.boke.realm;

import com.boke.common.Const;
import com.boke.dao.UserMapper;
import com.boke.pojo.User;
import com.boke.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    //权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String account=(String)authenticationToken.getPrincipal();
        User user=userMapper.selectUserByAccount(account);
        //这里不需要抛出异常
        if(user==null){
            throw new UnknownAccountException("未知用户名");
        }
        //这里是从数据库查出的密码
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(account,user.getCpassword(),"userRealm");
        info.setCredentialsSalt(ByteSource.Util.bytes(Const.ShiroConst.SALT));
        return info;
    }
}
