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
}
