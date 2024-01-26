package com.vm.springstarter.database.repo;

import com.vm.springstarter.bpp.InjectBean;
import com.vm.springstarter.pool.ConnectionPool;
import lombok.*;


@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UserRepo {
    @InjectBean
    private ConnectionPool connectionPool;
}
