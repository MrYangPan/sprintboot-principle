package com.springboot.multidatasource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mr.PanYang on 2018/7/26.
 */
@Controller
public class JspController {

    @RequestMapping("/jspIndex")
    public String index() {
        return "jspIndex";
    }


}
