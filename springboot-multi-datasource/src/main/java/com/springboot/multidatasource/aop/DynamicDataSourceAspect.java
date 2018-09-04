package com.springboot.multidatasource.aop;

import com.springboot.multidatasource.annotation.TargetDataSource;
import com.springboot.multidatasource.holder.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Mr.PanYang on 2018/7/23.
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(com.springboot.multidatasource.annotation.TargetDataSource)")
    public void beforeSwapSource(JoinPoint point) {
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DATASOURCE;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DataSource注解
            if (method.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource annotation = method.getAnnotation(TargetDataSource.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        DataSourceContextHolder.setSource(dataSource);
    }

    @After("@annotation(com.springboot.multidatasource.annotation.TargetDataSource)")
    public void afterSwapSource(JoinPoint point) {
        DataSourceContextHolder.clearSource();
    }


}
