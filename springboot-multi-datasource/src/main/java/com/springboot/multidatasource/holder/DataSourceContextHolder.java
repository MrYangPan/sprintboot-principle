package com.springboot.multidatasource.holder;

/**
 * Created by Mr.PanYang on 2018/7/23.
 * <p>
 * 数据源切换读取类
 */
public class DataSourceContextHolder {
    /**
     * 默认数据源
     */
    public static final String DEFAULT_DATASOURCE = "test1";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    // 设置数据源名
    public static void setSource(String dbType) {
        System.out.println("切换到{" + dbType + "}数据源");
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static String getSource() {
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearSource() {
        contextHolder.remove();
    }
}
