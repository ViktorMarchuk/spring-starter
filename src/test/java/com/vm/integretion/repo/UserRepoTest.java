package com.vm.integretion.repo;

import com.vm.annotation.IT;
import com.vm.springstarter.database.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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
    void findByFirstName() {
        var users = userRepo.findAllByFirstNameContainingIgnoreCase("o");
        System.out.println("Result: " + users);
    }

    @Test
    void findByUserName() {
        var users = userRepo.findUsersByUserNameContainingIgnoreCase("s");
        Optional<String> actual= users.stream().map(user -> user.getUserName()).findAny();
        System.out.println(users);
        System.out.println(actual.get());
        Assertions.assertEquals(actual.get(),"Sea");
    }
}
