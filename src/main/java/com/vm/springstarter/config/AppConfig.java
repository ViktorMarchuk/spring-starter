package com.vm.springstarter.config;

import com.vm.springstarter.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class AppConfig {

    @Bean("connectionPool")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool connectionPool(@Value("${db.username}")String userName) {
        return new ConnectionPool(userName, "34", 89, "onliner");
    }
    @Bean
    public ConnectionPool connectionPool1(@Value("${db.username}")String userName) {
        return new ConnectionPool(userName, "25pp", 4489, "FRonliner");
    }
}
