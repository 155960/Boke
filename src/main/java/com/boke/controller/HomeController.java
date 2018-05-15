package com.boke.controller;

import com.boke.pojo.Article;
import com.boke.pojo.User;
import com.boke.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user/{account}")
public class HomeController {

    @Autowired
    private IArticleService iArticleService;
    @RequestMapping("home.do")
    public String home(HttpSession session, Model model){
        System.out.println(session.getAttribute("user").toString());
        User user=(User) session.getAttribute("user");
        model.addAttribute("user" ,user);
        List<Article> articles=iArticleService.selectArticlesByAccount(user.getAccount());
        model.addAttribute("articles",articles);
        return "user/home";

    }
}
