package com.springboot.base.mapper;

import com.springboot.base.model.User;

import java.util.List;

/**
 * Created by Mr.PanYang on 2018/7/17.
 */
public interface UserDao {

    List<User> getUsers();

    void insertUser(User user);

}
