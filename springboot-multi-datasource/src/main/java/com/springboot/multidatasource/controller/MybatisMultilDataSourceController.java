package com.springboot.multidatasource.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.multidatasource.entity.User;
import com.springboot.multidatasource.test01.service.UserServiceTest01;
import com.springboot.multidatasource.test02.service.UserServiceTest02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mr.PanYang on 2018/7/23.
 */
@RestController
public class MybatisMultilDataSourceController {
    @Autowired
    private UserServiceTest01 userServiceTest01;
    @Autowired
    private UserServiceTest02 userServiceTest02;

    @RequestMapping("/insertUserTest1")
    public Integer insertUserTest1(String name, Integer age) {
        return userServiceTest01.insertUser(name, age);
    }

    @RequestMapping("/insertUserTest2")
    public Integer insertUserTest2(String name, Integer age) {
        return userServiceTest02.insertUser(name, age);
    }

    @RequestMapping("/insertUserTest01AndTest02")
    public int insertUserTest01AndTest02(String name, Integer age) {
        return userServiceTest02.insertUserTest01AndTest02(name, age);
    }

    /**
     * @Date: 14:23 2018/7/24
     * @Description: 分页
     */
    @RequestMapping("/pageInfo")
    public PageInfo<User> pageInfo(int page, int pageSize) {
        return userServiceTest01.getUserPageInfo(page, pageSize);
    }

    /**
     * @Date: 14:34 2018/7/25
     * @Description: 测试 Tomcat 和 Undertow 服务器的吞吐量
     */
    @RequestMapping("pressureIndex")
    public String pressureIndex() {
        return "index";
    }

    @Value("${itmayiedu.httpurl}")
    private String httpUrl;

    @Value("${itmayiedu.name}")
    private String name;

    @Value("${itmayiedu.students.money}")
    private int money;

    @RequestMapping("readYml")
    public String readYml() {
        return httpUrl + "|" + name + "|" + money;
    }
}
