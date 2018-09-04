package com.springboot.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Date: 15:59 2018/7/16
 * @Description: springBoot 对 jsp 的支持很弱，需要打包方式方式改成 war 类型
 * <p>
 * SpringBoot 3 种启动方式：
 * 1.@EnableAutoConfiguration  自动配置注解，作用范围是当前类
 * 2.@ComponentScan  扫包范围注解，["","" ......]
 * 3.@SpringBootApplication  等同于 1、2 两种注解，性能比较差，可以优化
 */
@SpringBootApplication
@MapperScan("com.springboot.base.mapper")
public class SpringbootBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBaseApplication.class, args);
    }
}
