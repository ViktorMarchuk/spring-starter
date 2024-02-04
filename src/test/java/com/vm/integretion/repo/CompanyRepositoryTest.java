package com.vm.integretion.repo;

import com.vm.annotation.IT;
import com.vm.springstarter.database.entity.Company;
import com.vm.springstarter.database.repo.CompanyRepo;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;


import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
//@TestPropertySource(locations = "classpath:spring.properties")
//@Transactional
//@Commit
public class CompanyRepositoryTest {


    private final EntityManager entityManager;
    private final CompanyRepo companyRepo;

    @Test
    void findById() {
        Company company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }

    @Test
    @Commit
    @Transactional
    void save() {
        var company = Company.builder()
                .name("Op")
                .locales(Map.of("ru", "Op описание",
                        "en", "Op description"))
                .build();
        entityManager.persist(company);
        entityManager.flush();
        assertNotNull(company.getId());
    }

    @Test
    void test() {

    }

    @Test
    void delete() {
        var maybeCompany = companyRepo.findById(4);
        assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepo::delete);
        entityManager.flush();
        assertTrue(companyRepo.findById(4).isEmpty());

    }

    @Test
    void findByQueries() {
        var company = companyRepo.findByName("Google");
        System.out.println(company);
        var companies = companyRepo.findAllByNameContainingIgnoreCase("m");
        System.out.println(companies);
        assertThat(companies).hasSize(1);
    }

    @Test
    void findByName() {
        var company = companyRepo.findAllByNameContainingIgnoreCase("g");
        Optional<String> actual = company.stream().map(company1 -> company1.getName()).findAny();
        System.out.println("Result: "+actual.get());
        assertThat(actual.get()).isEqualTo("Google");
        assertThat(company).hasSize(1);
    }
}