package com.vm.integretion.service;

import com.vm.annotation.IT;
import com.vm.springstarter.ApplicationRunner;
import com.vm.springstarter.config.DataBaseProperties;
import com.vm.springstarter.dto.CompanyReadDto;
import com.vm.springstarter.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)

public class CompanyServiceIT {
    private static final Integer COMPANY_ID = 1;
    private final CompanyService companyService;
//    private final DataBaseProperties dataBaseProperties;

    @Test
    void findById() {
        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());
        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

    }

}
