package com.springboot.multidatasource.annotation;

import java.lang.annotation.*;

/**
 * Created by Mr.PanYang on 2018/7/23.
 * <p>
 * 自定义注解方式 + aop 实现多数据源切换
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {
    String value();
}
