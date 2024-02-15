package com.vm.springstarter.validator;

import com.vm.springstarter.dto.UserCreateEditDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import static org.springframework.util.StringUtils.hasText;

@Component
public class UserInfoValidator implements ConstraintValidator<UserInfo, UserCreateEditDto> {

    @Override
    public boolean isValid(UserCreateEditDto userCreateEditDto, ConstraintValidatorContext constraintValidatorContext) {
        return hasText(userCreateEditDto.getFirstname()) || hasText(userCreateEditDto.getLastname());
    }
}
