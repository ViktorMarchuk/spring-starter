package com.vm.springstarter.run;

import com.vm.springstarter.database.repo.UserRepo;
import com.vm.springstarter.pool.ConnectionPool;
import com.vm.springstarter.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Runner {
    public static void main(String[] args) {
        var context=new ClassPathXmlApplicationContext("application.xml");
        var userRepo=context.getBean("userRepo",UserRepo.class);
        var userService=context.getBean(UserService.class);
        System.out.println(userRepo);
        context.close();


    }

}
