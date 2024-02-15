package com.vm.springstarter.mapper;

import com.vm.springstarter.database.entity.Company;
import com.vm.springstarter.database.entity.User;
import com.vm.springstarter.database.repo.CompanyRepo;
import com.vm.springstarter.dto.UserCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Component
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {
    private final CompanyRepo companyRepo;

    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        copy(object, user);

        return user;
    }

    @Override
    public User map(UserCreateEditDto fromObject, User toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private void copy(UserCreateEditDto object, User user) {
        user.setUserName(object.getUsername());
        user.setFirstName(object.getFirstname());
        user.setLastName(object.getLastname());
        user.setBirthDay(object.getBirthDate());
        user.setRole(object.getRole());
        user.setCompany(getCompany(object.getCompanyId()));

        Optional.ofNullable(object.getImage())
                .filter(Predicate.not(MultipartFile::isEmpty))
                .ifPresent(image->user.setImage(image.getOriginalFilename()));
    }

    private Company getCompany(Integer companyId) {
        return Optional.ofNullable(companyId).flatMap(companyRepo::findById).orElse(null);
    }
}
