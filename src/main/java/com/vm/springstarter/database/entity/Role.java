package com.vm.springstarter.database.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, USER, OPERATOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
