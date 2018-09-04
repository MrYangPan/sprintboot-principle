package com.springboot.base.model;

import lombok.Data;

/**
 * Created by Mr.PanYang on 2018/7/17.
 * lombok 工具使用
 */
@Data
public class User {
    private int id;
    private String userName;
    private String passWord;
    private String email;
}
