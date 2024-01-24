package com.vm.springstarter.run;

import com.vm.springstarter.database.repo.UserRepo;
import com.vm.springstarter.dto.UserDto;
import com.vm.springstarter.ioc.Container;
import com.vm.springstarter.mapper.UserMapper;
import com.vm.springstarter.service.UserService;

public class UserRunner {
    public static void main(String[] args) {
//        UserRepo userRepo = new UserRepo();
//        UserDto userDto = new UserDto();
//        UserMapper userMapper = new UserMapper(userDto);
        Container container = new Container();
        UserService userService = container.get(UserService.class);

    }
}
