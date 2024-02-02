package com.vm.integretion.repo;

import com.vm.annotation.IT;
import com.vm.springstarter.database.entity.Company;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;


import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@IT
@RequiredArgsConstructor
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@TestPropertySource(locations = "classpath:spring.properties")
@Transactional
public class CompanyRepositoryTest {


    private final EntityManager entityManager;

    @Test
    void findById() {
        Company company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }

    @Test
    void save() {
        var company = Company.builder()
                .name("Apple")
                .locales(Map.of("ru", "Apple описание",
                        "en", "Apple description"))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }
    @Test
    void test(){

    }
}