package com.example.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * com.example.demo.config.dao
 * icourt
 * 2018/4/9
 * author:asange
 * email:xuanyouwu@163.com
 **/
@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.example.demo.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    String jdbcDriver;
    @Value("${jdbc.url}")
    String jdbcUrl;
    @Value("${jdbc.username}")
    String jdbcUsername;
    @Value("${jdbc.password}")
    String jdbcPassword;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);

        //关闭链接后,不自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
