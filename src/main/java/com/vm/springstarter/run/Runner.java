package com.vm.springstarter.run;

import com.vm.springstarter.config.AppConfig;
import com.vm.springstarter.database.repo.UserRepo;
import com.vm.springstarter.pool.ConnectionPool;
import com.vm.springstarter.service.CompanyService;
import com.vm.springstarter.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Runner {

    public static void main(String[] args) {
//        var context = new ClassPathXmlApplicationContext("application.xml");
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var userService = context.getBean(UserService.class);
        var userRepo = context.getBean(UserRepo.class);

        var companyService=context.getBean(CompanyService.class);
        companyService.findById(1);
        context.close();

        System.out.println();

    }

}
