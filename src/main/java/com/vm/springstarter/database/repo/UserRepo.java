package com.vm.springstarter.database.repo;

import com.vm.springstarter.bpp.InjectBean;
import com.vm.springstarter.pool.ConnectionPool;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class UserRepo {

    //    @InjectBean
    @Autowired
    private ConnectionPool connectionPool1;

    @Value("${db.pool.size}")
    private Integer poolSize;

    //    @Autowired
//    private List<ConnectionPool> connectionPools;

    public UserRepo(ConnectionPool connectionPool) {
        this.connectionPool1 = connectionPool;
    }
}
