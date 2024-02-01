package com.vm.integretion.repo;

import com.vm.annotation.IT;
import com.vm.springstarter.database.entity.Company;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@IT
@RequiredArgsConstructor
public class CompanyRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    void findById() {
        Company company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }
}
