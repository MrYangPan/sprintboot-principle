package com.springboot.principle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mr.PanYang on 2018/7/12.
 */
@Controller
public class UserController {

    @RequestMapping("/pageIndex")
    public String pageIndex() {
        System.out.println("qqqqq");
        return "pageIndex";
    }

}
