package com.vm.springstarter.database.repo;

import com.vm.springstarter.database.entity.Role;
import com.vm.springstarter.database.entity.User;
import com.vm.springstarter.dto.IPersonalInfo;
import com.vm.springstarter.dto.PersonalInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


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

    //    @Query(value = "select u.* from users u where u.firstname=:firstname",nativeQuery = true)
//    List<User> findAllByFirstName( String firstname);
    @Query(value = "select u.* from springdata.users u where trim(u.firstname) = :firstname", nativeQuery = true)
    List<User> findAllByFirstName(String firstname);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.role = :role where u.id in (:ids)")
    int updateRole(@Param("role") Role role, @Param("ids") Long ids);

    List<User> findAllById(Long id);

    //    <T> List<T> findAllByCompanyId(Integer companyId, Class<T> clazz);
    @Query(value = "select u.firstname, u.lastname,u.birth_date from springdata.users u where u.company_id =:companyId", nativeQuery = true)
    List<IPersonalInfo> findAllByCompanyId(Integer companyId);

    //    @Query(value = "select * from springdata.users u where u.company_id is not null order by id desc limit 1",nativeQuery = true)
    List<User> findFirst3ByCompanyIsNotNullOrderByIdDesc();

    List<User> findFirst2By(Sort sort);

    Slice<User> findAllBy(Pageable pageable);

}
