package com.boke.controller;

import com.boke.form.UserForm;
import com.boke.pojo.User;
import com.boke.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    public String register(@Valid UserForm user, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("error",errors);
            return "login/register";
           // return new ModelAndView("login/register");
        }
        return "login/register";
    }

    @RequestMapping(value = "register.do")
    public String register(){
        return "login/register";
    }

}
