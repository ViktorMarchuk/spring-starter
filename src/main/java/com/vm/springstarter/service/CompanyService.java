package com.vm.springstarter.service;

import com.vm.springstarter.database.repo.CompanyRepo;
import com.vm.springstarter.dto.CompanyReadDto;
import com.vm.springstarter.listener.AccessType;
import com.vm.springstarter.listener.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CompanyService {
    private final CompanyRepo companyRepo;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CompanyService(CompanyRepo companyRepo, ApplicationEventPublisher applicationEventPublisher) {
        this.companyRepo = companyRepo;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepo.findById(id).map(entity -> {
            applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.DELETE));
            return new CompanyReadDto(entity.getId());
        });
    }
}
