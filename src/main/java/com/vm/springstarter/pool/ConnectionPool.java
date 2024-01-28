package com.vm.springstarter.pool;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@ToString
@Component

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
}

