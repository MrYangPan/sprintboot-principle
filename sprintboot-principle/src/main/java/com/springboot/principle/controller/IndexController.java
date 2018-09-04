package com.springboot.principle.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mr.PanYang on 2018/7/12.
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/index", produces = "text/html;charset=utf-8")
    public String index() {
        return "SpringBoot访问成功";
    }


}
