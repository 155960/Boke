package com.boke.service.impl;

import com.boke.common.Const;
import com.boke.common.ResponseCode;
import com.boke.dao.UserMapper;
import com.boke.form.UserForm;
import com.boke.pojo.User;
import com.boke.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    //注册
    public int register(UserForm userForm){
        User user=createUserFromUserForm(userForm);
        int rowcount=userMapper.insert(user);
        if(rowcount>0){
            return ResponseCode.SUCCESS.getCode();
        }else{
            return ResponseCode.ERROR.getCode();
        }
    }


    public boolean login(UserForm userForm){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(userForm.getAccount(),userForm.getPassword());
        token.setRememberMe(userForm.isRememberMe());
        subject.login(token);

        return subject.isAuthenticated();
    }

    public User getUser(String account,String password){
        User user=userMapper.selectUserByAccountAndPasswd(account,shiroMD5(password));
        user.setCpassword("");
        return user;
    }

    private User createUserFromUserForm(UserForm userForm){
        User user=new User();
        user.setAccount(userForm.getAccount());
        String password=userForm.getPassword();
        user.setCpassword(shiroMD5(password));
        user.setEmail(userForm.getEmail());
        if(StringUtils.isEmpty(userForm.getNickName())){
            user.setNickName(userForm.getAccount());
        }else{
            user.setNickName(userForm.getNickName());
        }
        user.setGithubAddr(userForm.getGithubAddr());
        user.setCsdnAddr(userForm.getCsdnAddr());
        return user;
    }

    //MD5加密
    private String shiroMD5(String s){
        Md5Hash md5Hash=new Md5Hash(s,Const.ShiroConst.SALT);
        //md5Hash.setSalt(ByteSource.Util.bytes(Const.ShiroConst.SALT));
        return md5Hash.toString();
    }
}
