package com.springboot.base.service.impl;

import com.springboot.base.mapper.UserDao;
import com.springboot.base.model.User;
import com.springboot.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mr.PanYang on 2018/7/17.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
