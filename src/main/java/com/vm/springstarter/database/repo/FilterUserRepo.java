package com.vm.springstarter.database.repo;

import com.vm.springstarter.database.entity.User;
import com.vm.springstarter.dto.UserFilter;

import java.util.List;

public interface FilterUserRepo {
    List<User> findAllByFilter(UserFilter userFilter);
}
