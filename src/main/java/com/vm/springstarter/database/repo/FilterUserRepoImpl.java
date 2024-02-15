package com.vm.springstarter.database.repo;


import com.querydsl.jpa.impl.JPAQuery;
import com.vm.springstarter.database.entity.User;
import com.vm.springstarter.dto.QPredicates;
import com.vm.springstarter.dto.UserFilter;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.vm.springstarter.database.entity.QUser.user;

@RequiredArgsConstructor
public class FilterUserRepoImpl implements FilterUserRepo {
    private final EntityManager entityManager;

    @Override
    public List<User> findAllByFilter(UserFilter filter) {
        var predicate = QPredicates.builder()
                .add(filter.firstname(), user.firstName::containsIgnoreCase)
                .add(filter.lastname(), user.lastName::containsIgnoreCase)
                .add(filter.birthDate(), user.birthDay::before)
                .build();
        return new JPAQuery<User>(entityManager)
                .select(user)
                .from(user)
                .where(predicate)
                .fetch();
    }


//    @Override
//    public List<User> findAllByFilter(UserFilter filter) {
//        var criteriaBuilder = entityManager.getCriteriaBuilder();
//        var criteria = criteriaBuilder.createQuery(User.class);
//        var user = criteria.from(User.class);
//        criteria.select(user);
//
//        List<Predicate> predicates = new ArrayList<>();
//        if (filter.firstname() != null && !filter.firstname().isBlank()) {
//            predicates.add(criteriaBuilder.like(user.get("firstName"), filter.firstname()));
//        }
//        if (filter.lastname() != null && !filter.lastname().isBlank()) {
//            predicates.add(criteriaBuilder.like(user.get("lastName"), filter.lastname()));
//        }
//        if (filter.birthDate() != null) {
//            predicates.add(criteriaBuilder.lessThan(user.get("birthDay"), filter.birthDate()));
//        }
//        criteria.where(predicates.toArray(Predicate[]::new));
//
//        return entityManager.createQuery(criteria).getResultList();
//    }
}
