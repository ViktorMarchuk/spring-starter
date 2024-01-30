package com.vm.springstarter;


import com.vm.springstarter.config.DataBaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.SpringProperties;


@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {

    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(SpringProperties.getProperty("test.msg"));
        System.out.println(context.getBean("connectionPool"));
        System.out.println(context.getBean(DataBaseProperties.class));

    }

}
