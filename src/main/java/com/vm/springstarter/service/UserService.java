package com.vm.springstarter.service;

import com.vm.springstarter.database.repo.UserRepo;
import com.vm.springstarter.dto.QPredicates;
import com.vm.springstarter.dto.UserCreateEditDto;
import com.vm.springstarter.dto.UserFilter;
import com.vm.springstarter.dto.UserReadDto;
import com.vm.springstarter.mapper.UserCreateEditMapper;
import com.vm.springstarter.mapper.UserMapper;
import com.vm.springstarter.mapper.UserReadMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
;import static com.vm.springstarter.database.entity.QUser.user;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepo userRepo;
    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;

    public Page<UserReadDto> findAll(UserFilter filter, Pageable pageable) {
        var predicate = QPredicates.builder()
                .add(filter.firstname(), user.firstName::containsIgnoreCase)
                .add(filter.lastname(), user.lastName::containsIgnoreCase)
                .add(filter.birthDate(), user.birthDay::before)
                .build();
        return userRepo.findAll(predicate, pageable)
                .map(userReadMapper::map);
    }

    public List<UserReadDto> findAll(UserFilter userFilter) {
        return userRepo
                .findAllByFilter(userFilter)
                .stream()
                .map(userReadMapper::map)
                .toList();
    }

    public List<UserReadDto> findAll() {
        return userRepo
                .findAll()
                .stream()
                .map(userReadMapper::map)
                .toList();
    }

    public Optional<UserReadDto> findById(Long id) {
        return userRepo.findById(id)
                .map(userReadMapper::map);
    }

    @Transactional
    public UserReadDto create(UserCreateEditDto userDto) {
        return Optional.of(userDto)
                .map(userCreateEditMapper::map)
                .map(userRepo::save)
                .map(userReadMapper::map)
                .orElseThrow();

    }

    @Transactional
    public Optional<UserReadDto> update(Long id, UserCreateEditDto userCreateEditDto) {
        return userRepo.findById(id)
                .map(entity -> userCreateEditMapper.map(userCreateEditDto, entity))
                .map(userRepo::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return userRepo.findById(id)
                .map(entity -> {
                    userRepo.delete(entity);
                    userRepo.flush();
                    return true;
                })
                .orElse(false);
    }
}
