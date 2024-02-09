package com.vm.springstarter.mapper;

import com.vm.springstarter.database.entity.Company;
import com.vm.springstarter.dto.CompanyReadDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto> {
    @Override
    public CompanyReadDto map(Company object) {
        return new CompanyReadDto(object.getId(),
                                 object.getName()
        );
    }
}
