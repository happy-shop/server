package com.hs.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class DruidDataSourceConfig {
    @Bean
    @Primary //表示为默认数据源
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource mainDataSource() {
        return new DruidDataSource();
    }
}
