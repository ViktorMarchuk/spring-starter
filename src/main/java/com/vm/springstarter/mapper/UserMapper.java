package com.vm.springstarter.mapper;

import com.vm.springstarter.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class UserMapper {
    private final UserDto userDto;
}
