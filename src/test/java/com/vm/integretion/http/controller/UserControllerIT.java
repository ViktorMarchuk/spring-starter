package com.vm.integretion.http.controller;

import com.vm.annotation.IT;
import com.vm.springstarter.dto.UserCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@IT
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class UserControllerIT {
    private final MockMvc mockMvc;

    @Test
    void findAllTest() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/users"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attribute("users", IsCollectionWithSize.hasSize(6)));
    }

    @Test
    void createTest() throws Exception {
        mockMvc.perform(post("/users")
                        .param(UserCreateEditDto.Fields.username, "test@")
                        .param(UserCreateEditDto.Fields.firstname, "test")
                        .param(UserCreateEditDto.Fields.lastname, "testT")
                        .param(UserCreateEditDto.Fields.role, "ADMIN")
                        .param(UserCreateEditDto.Fields.birthDate, "01-01-2000")
                        .param(UserCreateEditDto.Fields.companyId, "1")
                )
                .andExpect(
                        status().is3xxRedirection());
        redirectedUrlPattern("/users/{\\d+}");
    }

    @Test
    void findByIdTest() throws Exception {
        int id = 1;
        mockMvc.perform(get("/users/{id}", id))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/user"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user", notNullValue()));
    }
    @Test
    void deleteTest() throws Exception {
        int idDeleteUser=2;
        mockMvc.perform(delete("/users/{id}/delete",idDeleteUser))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/users"));
    }
}
