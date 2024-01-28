package com.vm.springstarter.mapper;

import com.vm.springstarter.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class UserMapper {
    private  UserDto userDto;
}
