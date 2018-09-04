package com.springboot.multidatasource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mr.PanYang on 2018/7/30.
 */
@RestController
public class ActuatorController {

    @RequestMapping("actuatorIndex")
    public String index() {
        return "actuatorIndex";
    }

}
