package com.vm.springstarter.run;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringProperties;


@SpringBootApplication
public class ApplicationRunner {

    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(SpringProperties.getProperty("test.msg"));
        System.out.println(context.getBean("connect"));

    }

}
