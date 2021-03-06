package com.boke.controller;

import com.boke.common.Const;
import com.boke.common.ResponseCode;
import com.boke.common.ServerResponse;
import com.boke.form.UserForm;
import com.boke.pojo.User;
import com.boke.service.IFileService;
import com.boke.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IFileService iFileService;

    @RequestMapping("login.do")
    public String index(){
        return "login/login";
    }

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public View login(HttpSession session, UserForm userForm, Model model){
        //登录成功
        if(iUserService.login(userForm)){
            User user=iUserService.getUser(userForm.getAccount(),userForm.getPassword());
            session.setAttribute("user",user);
            model.addAttribute("account",user.getAccount());
            return new RedirectView("/user/{account}/home.do",true);
        }else{
            //
            return null;

        }

    }

    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    public String register(@Valid UserForm userForm, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("error",errors);
            return "login/register";
        }
        int code=iUserService.register(userForm);
        if(code== ResponseCode.SUCCESS.getCode()){
            return "redirect:login.do";
        }else{
            model.addAttribute("fail","注册失败");

            return "login/register";
        }

    }

    @RequestMapping(value = "register.do")
    public String register(){
        return "login/register";
    }

    @RequestMapping("upload_img.do")
    @ResponseBody
    public ServerResponse upload(MultipartFile file, HttpServletRequest request){
        String path ="/img";
        String targetFileName = iFileService.upload(file,path);
        return ServerResponse.createBySuccess();
    }

}
