package com.vm.springstarter.service;

import com.vm.springstarter.database.repo.CompanyRepo;
import com.vm.springstarter.dto.CompanyReadDto;
import com.vm.springstarter.listener.AccessType;
import com.vm.springstarter.listener.EntityEvent;
import com.vm.springstarter.mapper.CompanyReadMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepo companyRepo;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CompanyReadMapper companyReadMapper;

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepo.findById(id).map(entity -> {
            applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.DELETE));
            return new CompanyReadDto(entity.getId(), null);
        });
    }

    public List<CompanyReadDto> findAll() {
        return companyRepo.findAll().stream()
                .map(companyReadMapper::map)
                .toList();
    }
}

