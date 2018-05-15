package com.boke.service;

import com.boke.common.ServerResponse;
import com.boke.pojo.Article;

import java.util.List;

public interface IArticleService {
    ServerResponse insertArticle(Article article);
    Article findArticleById(Integer id) throws Exception ;
    List<Article> selectArticlesByAccount(String account);
}
