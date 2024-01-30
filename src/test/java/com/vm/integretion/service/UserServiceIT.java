package com.vm.integretion.service;

import com.vm.annotation.IT;
import com.vm.springstarter.pool.ConnectionPool;
import com.vm.springstarter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

@IT
@RequiredArgsConstructor
public class UserServiceIT {
    private final UserService userService;

    @MockBean(name = "connectionPool")
    private ConnectionPool connectionPool;

    @Test
    void test() {

    }
}
