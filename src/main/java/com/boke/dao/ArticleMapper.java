package com.boke.dao;

import com.boke.pojo.Article;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> selectArticlesByAccount(String account);

}