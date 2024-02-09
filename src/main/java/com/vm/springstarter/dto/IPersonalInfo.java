package com.vm.springstarter.dto;

import java.time.LocalDate;

public interface IPersonalInfo {
    Long id();
    String getFirstname();

    String getLastname();

    LocalDate getBirth_date();

}
