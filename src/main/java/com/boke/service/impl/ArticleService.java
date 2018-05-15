package com.boke.service.impl;

import com.boke.common.ServerResponse;
import com.boke.dao.ArticleMapper;
import com.boke.pojo.Article;
import com.boke.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ArticleService implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public ServerResponse insertArticle(Article article){
        int rowCount=articleMapper.insert(article);
        if(rowCount>0){
            return ServerResponse.createBySuccess();
        }else{
            return ServerResponse.createByError();
        }
    }

    public Article findArticleById(Integer id) throws Exception {
        Article article=articleMapper.selectByPrimaryKey(id);
        if(article!=null){
            return article;
        }
        else{
            throw new Exception("没有找到该文章");
        }
    }

    public List<Article> selectArticlesByAccount(String account){
        return articleMapper.selectArticlesByAccount(account);
    }

}
