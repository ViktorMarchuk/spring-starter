package com.vm.springstarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;
@ConfigurationProperties(prefix = "db")
public record DataBaseProperties (String username,
                                  String password,
                                  String url,
                                  PoolProperties pool,
                                  List<PoolProperties>pools,
                                  Map<String , Object> properties
                                  ){

    public static record PoolProperties(Integer size, Integer timeout){

    }
}
