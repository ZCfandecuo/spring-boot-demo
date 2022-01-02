package com.johnny.securityserver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringAnnotationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext("com.johnny.securityserver.config");
        JdbcTemplate template = config.getBean("jdbcTemplate", JdbcTemplate.class);
        template.update("insert into account (name, money) value(?,?)", "rain",9000);
    }
}
