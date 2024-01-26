package com.vm.springstarter.pool;

import lombok.ToString;

@ToString

public class ConnectionPool {
    private String userName;
    private String password;
    private Integer poolSize;
    private String url;
}

