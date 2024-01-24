package com.vm.springstarter.service;

import com.vm.springstarter.database.repo.UserRepo;
import com.vm.springstarter.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserMapper userMapper;
    private final UserRepo userRepo;
}
