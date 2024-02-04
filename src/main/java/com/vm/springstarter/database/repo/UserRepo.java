package com.vm.springstarter.database.repo;

import com.vm.springstarter.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
//    @Query("select u from User u where u.firstName like %:firstname% and u.lastName like %:lastname%")
//    List<User> findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(@Param("firstname") String firstname,
//                                                                                     @Param("lastname") String lastname);
@Query("select u from User u where lower(u.firstName) like lower(concat('%', :firstname, '%')) and lower(u.lastName) like lower(concat('%', :lastname, '%'))")
List<User> findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(@Param("firstname") String firstname,
                                                                                 @Param("lastname") String lastname);


    List<User> findByLastName(String lastname);

    List<User> findAllByFirstNameContainingIgnoreCase(String firstname);

    List<User> findUsersByUserNameContainingIgnoreCase(String userName);
}
