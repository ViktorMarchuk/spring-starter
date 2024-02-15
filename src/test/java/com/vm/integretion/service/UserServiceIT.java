package com.vm.integretion.service;

import com.vm.annotation.IT;
import com.vm.springstarter.database.entity.Role;
import com.vm.springstarter.dto.UserCreateEditDto;
import com.vm.springstarter.dto.UserReadDto;
import com.vm.springstarter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@Commit
public class UserServiceIT {
    private final UserService userService;
    private final static String USER_3 = "Lena";
    private final static Long USER_1 = 1L;
    private final static Integer COMPANY_1 = 1;
    MockMultipartFile imageFile = new MockMultipartFile(
            "image",
            "test.png",
            "image/png",
            new byte[]{}
    );

    @Test
    void findAllTest() {
        List<UserReadDto> result = userService.findAll();
        System.out.println(result);
        assertThat(result).hasSize(6);

    }

    @Test
    void findByIdTest() {
        String expected = USER_3;
        Optional<String> actual = userService.findById(3L).stream().map(user -> user.getFirstname()).findAny();
        Optional<UserReadDto> us = userService.findById(4L);
        System.out.println(actual.get());
        assertTrue(actual.isPresent());
        actual.ifPresent(user -> assertEquals(actual.get(), expected));
        assertThat(actual.get()).contains(expected);
        us.ifPresent(u -> assertEquals(4, u.getId()));
    }


    @Test
    @Commit
    void createTest() {
        UserCreateEditDto userCreateEditDto = new UserCreateEditDto(
                "Stoun",
                LocalDate.now(),
                "test",
                "test",
                Role.ADMIN,
                COMPANY_1,
                imageFile
        );
        UserReadDto actual = userService.create(userCreateEditDto);
        assertEquals(userCreateEditDto.getUsername(), actual.getUsername());
        assertEquals(userCreateEditDto.getBirthDate(), actual.getBirthDate());
        assertEquals(userCreateEditDto.getFirstname(), actual.getFirstname());
        assertEquals(userCreateEditDto.getLastname(), actual.getLastname());
        assertSame(userCreateEditDto.getRole(), actual.getRole());
        assertEquals(userCreateEditDto.getCompanyId(), actual.getCompany().id());
    }

    @Test
    void updateTest() {
        var userDto = new UserCreateEditDto(
                "Tree",
                LocalDate.now(),
                "test1",
                "test1",
                Role.USER,
                COMPANY_1,
                imageFile
        );
        Optional<UserReadDto> actual = userService.update(USER_1, userDto);
        assertEquals(userDto.getUsername(), actual.get().getUsername());
        assertEquals(userDto.getBirthDate(), actual.get().getBirthDate());
        assertEquals(userDto.getFirstname(), actual.get().getFirstname());
        assertEquals(userDto.getLastname(), actual.get().getLastname());
        assertSame(userDto.getRole(), actual.get().getRole());
        assertEquals(userDto.getCompanyId(), actual.get().getCompany().id());

    }

    @Test
    void deleteTest() {
        assertFalse(userService.delete(-23L));
        assertTrue(userService.delete(USER_1));
    }
}
