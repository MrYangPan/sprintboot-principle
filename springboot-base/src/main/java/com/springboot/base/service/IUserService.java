package com.springboot.base.service;

import com.springboot.base.model.User;

import java.util.List;

/**
 * Created by Mr.PanYang on 2018/7/17.
 */
public interface IUserService {
    List<User> getUsers();

    void insertUser(User user);
}
