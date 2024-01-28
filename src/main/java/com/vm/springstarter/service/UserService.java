package com.vm.springstarter.service;

import com.vm.springstarter.database.repo.UserRepo;
import com.vm.springstarter.mapper.UserMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@ToString
@NoArgsConstructor(force = true)
@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepo userRepo;
}
