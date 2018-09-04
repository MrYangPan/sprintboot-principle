package com.springboot.multidatasource.test01.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.multidatasource.entity.User;
import com.springboot.multidatasource.test01.mapper.UserMapperTest01;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserServiceTest01<br>
 * 作者: 每特教育-余胜军<br>
 * 联系方式:QQ644064779|WWW.itmayiedu.com<br>
 */
@Service
@Slf4j
public class UserServiceTest01 {
    @Autowired
    private UserMapperTest01 userMapperTest01;

    @Transactional(transactionManager = "test1TransactionManager")
    public int insertUser(String name, Integer age) {
        int insertUserResult = userMapperTest01.insert(name, age);
        log.info("######insertUserResult:{}##########", insertUserResult);
        int i = 1 / age;
        // 怎么样验证事务开启成功!~
        return insertUserResult;
    }

    public PageInfo<User> getUserPageInfo(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<User> users = userMapperTest01.getUsers();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }

}
