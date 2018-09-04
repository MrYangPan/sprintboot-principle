package com.springboot.principle.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.lang.Nullable;

/**
 * Created by Mr.PanYang on 2018/7/12.
 * <p>
 * AbstractAnnotationConfigDispatcherServletInitializer 这个类负责配置DispatcherServlet、
 * 初始化Spring MVC容器和Spring容器
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //  加载根配置信息，spring 核心配置
    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{com.springboot.principle.config.RootConfig.class};
    }

    //  springMvc 加载配置信息
    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //  拦截url映射，所有请求
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
