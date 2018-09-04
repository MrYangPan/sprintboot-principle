package com.springboot.base;

import com.springboot.base.model.User;
import com.springboot.base.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootBaseApplicationTests {

//    @Autowired
//    private IUserService userService;

    @Test
    public void contextLoads() {
//        User user = new User();
//        user.setUserName("小余");
//        log.info("lombok 打印日志：" + user.toString());
    }

    @Test
    public void testInsert() {
//        User user = new User();
//        user.setUserName("望京");
//        user.setPassWord("123456");
//        userService.insertUser(user);
//        log.info(user.toString());
    }

}
