package com.vm.springstarter.database.repo;

import com.vm.springstarter.database.entity.User;
import com.vm.springstarter.dto.UserFilter;
import jakarta.persistence.EntityManager;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FilterUserRepoImpl implements FilterUserRepo {
    private final EntityManager entityManager;

    @Override
    public List<User> findAllByFilter(UserFilter filter) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteria = criteriaBuilder.createQuery(User.class);
        var user=criteria.from(User.class);
        criteria.select(user);

        List<Predicate> predicates=new ArrayList<>();
        if(filter.firstname()!=null){
            predicates.add(criteriaBuilder.like(user.get("firstname"),filter.firstname()));
        }
        if (filter.lastname()!=null){
            predicates.add(criteriaBuilder.like(user.get("lastname"),filter.lastname()));
        }
        if (filter.birthDate()!=null){
            predicates.add(criteriaBuilder.lessThan(user.get("birthDate"),filter.birthDate()));
        }
        criteria.where(predicates.toArray(Predicate[]::new));

        return entityManager.createQuery(criteria).getResultList();
    }
}
