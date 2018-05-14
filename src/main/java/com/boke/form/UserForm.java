package com.boke.form;

import com.boke.validation.Email;
import com.boke.validation.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {

   @NotBlank(message = "{user.account}")
    private String account;

   @NotBlank(message = "{user.password}")
    private String password;

    @Email(message = "{user.email}")
    private String email;

    private String nickName;

    private String githubAddr;

    private String csdnAddr;

    private boolean rememberMe;

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nikeName) {
        this.nickName = nikeName;
    }

    public String getGithubAddr() {
        return githubAddr;
    }

    public void setGithubAddr(String githubAddr) {
        this.githubAddr = githubAddr;
    }

    public String getCsdnAddr() {
        return csdnAddr;
    }

    public void setCsdnAddr(String csdnAddr) {
        this.csdnAddr = csdnAddr;
    }
}
