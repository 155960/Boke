package com.boke.exception;

import com.boke.common.Const;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginExectionHandler {

    //未知账户
    @ExceptionHandler(UnknownAccountException.class)
    public String handlerUnknownAccount(Model model,UnknownAccountException e){
        model.addAttribute(Const.ExceptionConst.EXCEPTION,e.toString());
        model.addAttribute(Const.ExceptionConst.MSG,"未知账户");
        return "error/error";
    }

    //账户或密码不正确
    @ExceptionHandler(IncorrectCredentialsException.class)
    public String handlerIncorrectCredentials(Model model,IncorrectCredentialsException e){

        model.addAttribute(Const.ExceptionConst.MSG,"账户或密码不正确");
        model.addAttribute(Const.ExceptionConst.EXCEPTION,e.toString());

        return "error/error";
    }

    //账户锁定
    @ExceptionHandler(LockedAccountException.class)
    public String handlerLockedAccount(Model model,IncorrectCredentialsException e){

        model.addAttribute(Const.ExceptionConst.MSG,"账户锁定");
        model.addAttribute(Const.ExceptionConst.EXCEPTION,e.toString());

        return "error/error";
    }

}
