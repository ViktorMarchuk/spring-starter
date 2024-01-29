package com.vm.springstarter.config;

import com.vm.springstarter.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;



@Configuration
public class AppConfig {

    @Bean(value = "connectionPool")
    public ConnectionPool connectionPool(@Value("${db.username}")String userName) {
        System.out.println();
        return new ConnectionPool(userName, "34", 89, "onliner");
    }

}
