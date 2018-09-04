package com.springboot.base.controller;

import com.springboot.base.model.User;
import com.springboot.base.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mr.PanYang on 2018/7/16.
 * <p>
 * SpringBoot  整合全局捕获异常
 * <p>
 * 使用 aop 技术，采用异常通知
 */
@RequestMapping("home")
@RestController
@Slf4j
public class HomeController {

//    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private IUserService userService;

    //读取配置文件信息
    @Value("${http_url}")
    private String http_url;

    @RequestMapping("index")
    public String index(int i) {
//        logger.info("log4j 日志打印输出");
        int j = 1 / i;
        return "success:" + j;
    }

    @RequestMapping("getHttp_url")
    public String getHttp_url() {
        return http_url;
    }

    @RequestMapping("getUsers")
    public String getUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "查询成功";
    }

    /**
     * @Date: 11:39 2018/7/20
     * @Description: 事物管理
     */
    @Transactional
    @RequestMapping("insertUser")
    public int insertUser(User user) {
        userService.insertUser(user);
        log.info("##### 发生异常之前的日志");
        int numb = 1 / 0;
        log.info("##### 发生异常");
        return user.getId();
    }


}
