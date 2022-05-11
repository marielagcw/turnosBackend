package com.marielagcw.health_center.repository;


import com.marielagcw.health_center.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    // New Special Query
    @Query("from User u where u.name =:name")
    Optional<User> getUserByName(@Param("name") String name);

}//Cierre
