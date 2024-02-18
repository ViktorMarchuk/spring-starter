package com.vm.springstarter.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Value;

@Value
public class LoginDto {
    @NotEmpty(message = "Must not be empty")
    String username;

    @NotEmpty(message = "Must not be empty")
    String password;
}
