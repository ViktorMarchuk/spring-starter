package com.vm.springstarter.mapper;

import com.vm.springstarter.database.entity.User;
import com.vm.springstarter.dto.CompanyReadDto;
import com.vm.springstarter.dto.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {
    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User object) {
        CompanyReadDto company = Optional.ofNullable(object.getCompany())
                .map(companyReadMapper::map).orElse(null);
        return new UserReadDto(
                object.getId(),
                object.getUserName(),
                object.getBirthDay(),
                object.getFirstName(),
                object.getLastName(),
                object.getRole(),
                company
        );
    }
}
