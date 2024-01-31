package com.vm.integretion;

import com.vm.springstarter.pool.ConnectionPool;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;

@TestConfiguration
public class TestApplicationRunner {
    @SpyBean(name = "connectionPool")
    private ConnectionPool connectionPool;
}
