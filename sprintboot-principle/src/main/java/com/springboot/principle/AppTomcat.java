package com.springboot.principle;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Created by Mr.PanYang on 2018/7/15.
 */
public class AppTomcat {
    /**
     * @Date: 17:04 2018/7/12
     * @Description: 使用java内置Tomcat运行springMvc原理：
     * tomcat 加载到 springMvc注解启动方式，就会创建springMvc容器
     */

    private static int PORT = 9090;
    private static String CONTEXT_PATH = "sprintboot-principle/";

    public static void main(String[] args) throws ServletException, LifecycleException {
        start();
    }

    public static void start() throws ServletException, LifecycleException {
        // 创建Tomcat
        Tomcat tomcatServer = new Tomcat();
        //  指定端口
        tomcatServer.setPort(PORT);
        //  读取项目路径
        StandardContext ctx = (StandardContext) tomcatServer.addWebapp("/", new File(CONTEXT_PATH + "src/main").getAbsolutePath());
        //  禁止重新载入
        ctx.setReloadable(false);
        //  class 文件读取地址
        File additionWebInfClasses = new File(CONTEXT_PATH + "target/class");
        //  创建WebRoot
        WebResourceRoot resourceRoot = new StandardRoot(ctx);
        //  tomcat 内部读取class执行
        System.out.println(additionWebInfClasses.getAbsolutePath());
        resourceRoot.addPreResources(new DirResourceSet(resourceRoot, "/" + CONTEXT_PATH + "src/main" + "WEB=INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        // 启动 Tomcat
        tomcatServer.start();
        //  异步进行接收请求
        tomcatServer.getServer().await();
    }
}
