package com.vm.springstarter.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(JpaCondition.class)
public class JpaConfig {
  @PostConstruct
    void init(){
      System.out.println("Jpa config is enable");
    }
}
