package com.vm.springstarter.pool;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@ToString
@Component
@Slf4j

public class ConnectionPool {

    private String userName;
    private String password;
    private Integer poolSize;
    private String url;

    public ConnectionPool(@Value("${db.username}") String userName,
            @Value("${db.password}") String password,
            @Value("${db.pool.size}") Integer poolSize,
            @Value("${db.url}") String url) {
        this.userName = userName;
        this.password = password;
        this.poolSize = poolSize;
        this.url = url;
    }
    @PostConstruct
    private void init(){
        log.info("Init connection POOL");

    }
}

