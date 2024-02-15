package com.vm.springstarter.dto;

import com.vm.springstarter.database.entity.Role;
import com.vm.springstarter.validator.UserInfo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo
public class UserCreateEditDto {
    String username;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate birthDate;


    @Size(min = 3, message = "Must have min 3 symbol")
    String firstname;

    @Size(min = 3, message = "Must have min 3 symbol")
    @NotEmpty(message = "Not have to be empty")
    String lastname;

    Role role;

    Integer companyId;

    MultipartFile image;
}
