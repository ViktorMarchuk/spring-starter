package com.vm.springstarter.config;

import com.vm.springstarter.database.repo.UserRepo;
import com.vm.springstarter.pool.ConnectionPool;
import com.vm.web.WebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@ImportResource("classpath:application.xml")
@Import(WebConfig.class)
@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("com.vm.springstarter")
public class AppConfig {

    @Bean
    public ConnectionPool connectionPool() {
        return new ConnectionPool("Lena", "34", 89, "onliner");
    }

    @Bean
    @Primary
    public ConnectionPool connectionPool2() {
        return new ConnectionPool("Udo", "3334", 839, "ner");
    }
    @Bean
    @Profile("web&prod")
    public UserRepo userRepo(){
        return new UserRepo(connectionPool());
    }
}
