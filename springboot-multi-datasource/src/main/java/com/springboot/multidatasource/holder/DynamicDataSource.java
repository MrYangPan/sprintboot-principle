package com.springboot.multidatasource.holder;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * Created by Mr.PanYang on 2018/7/23.
 * <p>
 * 动态切换数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getSource();
    }
}
