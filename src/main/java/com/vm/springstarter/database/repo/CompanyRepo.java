package com.vm.springstarter.database.repo;

import com.vm.springstarter.database.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Optional;

@Repository
public class CompanyRepo {
    public Optional<Company> findById(Integer id) {
        System.out.println("Method find by ID");
        return Optional.of(new Company(id, null, Collections.emptyMap()));
    }
}
