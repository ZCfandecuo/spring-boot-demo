package com.johnny.securityserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 配置jdbc容器
 */
@Configuration
@PropertySource(value = "classpath:application.yml")
public class JdbcTemplateConfig {

    @Value("${driver-class-name}")
    private String driver;

    @Value("${url}")
    private String url;

    @Value("${user}")
    private String user;

    @Value("${password}")
    private String password;

    @Bean("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource createDataSource() {
        //1. 创建spring内置dataSource对象
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //2. 创建必备的参数
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}
