package com.boke.pojo;

import java.util.Date;

public class Article {
    private Integer articleId;

    private String title;

    private String ctype;

    private String account;

    private Integer timesOfView;

    private Integer numberOfEnjoy;

    private Date createTime;

    private Date updateTime;

    private String essay;

    public Article(Integer articleId, String title, String ctype, String account, Integer timesOfView, Integer numberOfEnjoy, Date createTime, Date updateTime, String essay) {
        this.articleId = articleId;
        this.title = title;
        this.ctype = ctype;
        this.account = account;
        this.timesOfView = timesOfView;
        this.numberOfEnjoy = numberOfEnjoy;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.essay = essay;
    }

    public Article() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype == null ? null : ctype.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getTimesOfView() {
        return timesOfView;
    }

    public void setTimesOfView(Integer timesOfView) {
        this.timesOfView = timesOfView;
    }

    public Integer getNumberOfEnjoy() {
        return numberOfEnjoy;
    }

    public void setNumberOfEnjoy(Integer numberOfEnjoy) {
        this.numberOfEnjoy = numberOfEnjoy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEssay() {
        return essay;
    }

    public void setEssay(String essay) {
        this.essay = essay == null ? null : essay.trim();
    }
}