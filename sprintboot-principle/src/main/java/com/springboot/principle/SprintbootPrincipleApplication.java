package com.springboot.principle;

import com.springboot.principle.servlet.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * @Date: 15:43 2018/7/12
 * @Description: 纯手写springBoot框架
 */
public class SprintbootPrincipleApplication {

    private static int PORT = 8080;
    private static String CONTEXT_PATH = "/spring-boot";
    private static String SERVLET_NAME = "indexServlet";

    public static void main(String[] args) throws LifecycleException {
//		SpringApplication.run(SpringbootPrincipleApplication.class, args);

        // 创建Tomcat
        Tomcat tomcatServer = new Tomcat();
        //  指定端口
        tomcatServer.setPort(PORT);
        //  设置是否自动部署
        tomcatServer.getHost().setAutoDeploy(false);
        // 创建Context上下文
        StandardContext standardContext = new StandardContext();
        standardContext.setPath(CONTEXT_PATH);
        //  监听上下文
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        // tomcat容器添加standardContext
        tomcatServer.getHost().addChild(standardContext);
        // 创建servlet
        tomcatServer.addServlet(CONTEXT_PATH, SERVLET_NAME, new IndexServlet());
        //  servlet url 映射
        standardContext.addServletMappingDecoded("/index", SERVLET_NAME);
        System.out.println("tomcat启动...");
        tomcatServer.start();
        //  异步进行接收请求
        tomcatServer.getServer().await();
    }
}
