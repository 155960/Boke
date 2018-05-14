package com.boke.service;

import com.boke.form.UserForm;
import com.boke.pojo.User;

public interface IUserService {
    int register(UserForm userForm);
    boolean login(UserForm userForm);
    User getUser(String account, String password);
}
