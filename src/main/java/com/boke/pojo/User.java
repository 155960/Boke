package com.boke.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private Integer id;

    private String account;

    private String nickName;

    private String cpassword;

    private Integer role;

    private String email;

    private String githubAddr;

    private String csdnAddr;

    private Date createTime;

    private Date updateTime;

    public User(Integer id, String account, String nickName, String cpassword, Integer role, String email, String githubAddr, String csdnAddr, Date createTime, Date updateTime) {
        this.id = id;
        this.account = account;
        this.nickName = nickName;
        this.cpassword = cpassword;
        this.role = role;
        this.email = email;
        this.githubAddr = githubAddr;
        this.csdnAddr = csdnAddr;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword == null ? null : cpassword.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getGithubAddr() {
        return githubAddr;
    }

    public void setGithubAddr(String githubAddr) {
        this.githubAddr = githubAddr == null ? null : githubAddr.trim();
    }

    public String getCsdnAddr() {
        return csdnAddr;
    }

    public void setCsdnAddr(String csdnAddr) {
        this.csdnAddr = csdnAddr == null ? null : csdnAddr.trim();
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
}