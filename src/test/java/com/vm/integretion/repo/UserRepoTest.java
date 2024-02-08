package com.vm.integretion.repo;

import com.vm.annotation.IT;
import com.vm.springstarter.database.entity.Role;
import com.vm.springstarter.database.entity.User;
import com.vm.springstarter.database.repo.UserRepo;
import com.vm.springstarter.dto.IPersonalInfo;
import com.vm.springstarter.dto.PersonalInfo;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.vm.springstarter.database.entity.Role.ADMIN;
import static com.vm.springstarter.database.entity.Role.USER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
public class UserRepoTest {
    private final UserRepo userRepo;

    @Test
    void findByFirstNameAndLastName() {
        var user = userRepo.findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase("o", "p");
//        assertFalse(user.isEmpty());
//        assertThat(user).hasSize(4);
        System.out.println("RESULT :" + user);
    }

    @Test
    void findByLastName() {
        var users = userRepo.findByLastName("Nell");
        System.out.println(users);
    }

    @Test
    void findByFirstNameIgnoreCase() {
        var users = userRepo.findAllByFirstNameContainingIgnoreCase("o");
        System.out.println("Result: " + users);
    }

    @Test
    void findByUserName() {
        var users = userRepo.findUsersByUserNameContainingIgnoreCase("s");
        Optional<String> actual = users.stream().map(user -> user.getUserName()).findAny();
        System.out.println(users);
        System.out.println(actual.get());
        Assertions.assertEquals(actual.get(), "Sea");
    }

    @Test
    void findByFirstName() {
        var user = userRepo.findAllByFirstName("Oleg");
        List<String> actual = user.stream().map(user1 -> user1.getLastName()).collect(Collectors.toList());
        List<String> expected = Arrays.asList("Petrov", "Orlov");
        System.out.println(user);
        System.out.println("List of lastname" + actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void updateRoleTest() {
        var user = userRepo.updateRole(Role.ADMIN, 2L);
        Optional<Role> roleActual = userRepo.findAllById(2L).stream().map(user1 -> user1.getRole()).findAny();
        System.out.println(roleActual.get());
        Assertions.assertEquals(ADMIN, roleActual.get());

    }

    @Test
    void checkProjections() {
//        List<PersonalInfo> users = userRepo.findAllByCompanyId(1, PersonalInfo.class);
        List<IPersonalInfo> users = userRepo.findAllByCompanyId(3);
        for (IPersonalInfo result : users) {
            System.out.println("Name: " + result.getFirstname() + " " + result.getLastname() + ", " + result.getBirth_date());
        }
        assertThat(users).hasSize(2);
    }

    @Test
    void findFirstByCompanyIsNotNullOrderByIdDescTest() {
        var actualObject = userRepo.findFirst3ByCompanyIsNotNullOrderByIdDesc();
//        Optional<Long> actualId = actualObject.stream().map(user -> user.getId()).findAny();
//        System.out.println("ID : " + actualId.get());
//        assertThat(actualId).contains(6L);
//        List<String> actualList = actualObject.stream().map(user -> user.getUserName()).collect(Collectors.toList());
//        System.out.println(actualList);
//        Assertions.assertEquals(actualList, Arrays.asList("River", "Volcano", "Earth"));
        assertFalse(actualObject.isEmpty());
        assertThat(actualObject).hasSize(3);
    }

    @Test
    void findFirst2ByTest() {
        var actual = userRepo.findFirst2By(Sort.by("firstName").and(Sort.by("lastName")));
        assertFalse(actual.isEmpty());
        assertThat(actual).hasSize(2);
    }

    @Test
    void checkPageable() {
        var pageable = PageRequest.of(1, 2, Sort.by("id"));
        var userSlice = userRepo.findAllBy(pageable);
        userSlice.forEach(user -> System.out.println(user.getId()));
        while (userSlice.hasNext()) {
            userSlice=userRepo.findAllBy(userSlice.nextPageable());
            userSlice.forEach(user -> System.out.println(user.getId()));
        }
    }
}

