package com.boke.controller;

import com.boke.common.Const;
import com.boke.common.ServerResponse;
import com.boke.pojo.Article;
import com.boke.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping("user/article")
public class ArticleController {

    @Autowired
    private IArticleService iArticleService;

    @RequestMapping("writearticle.do")
    public String toWriteArticle(HttpSession session,Model model){
        model.addAttribute("user",session.getAttribute("user"));
        return "article/create";
    }

    //写文章
    @RequestMapping(value = "create.do" ,method = RequestMethod.POST)
    public String create(Article article, Model model) throws UnsupportedEncodingException {
        ServerResponse response=iArticleService.insertArticle(article);
        if(response.isSuccess()){
            model.addAttribute("article",article);
            return "article/preview";
        }else{
            model.addAttribute(Const.ExceptionConst.MSG,"创建失败");
            return "error/error";
        }

    }

    //文章预览
    @RequestMapping("preview")
    public String preview(Model model,@RequestParam("articleid")Integer articleId) throws Exception {
        Article article=iArticleService.findArticleById(articleId);
        model.addAttribute("article",article);
        return "article/preview";
    }

}
