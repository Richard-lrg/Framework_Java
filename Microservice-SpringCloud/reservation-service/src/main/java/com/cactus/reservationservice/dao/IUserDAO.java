package com.cactus.reservationservice.dao;

import com.cactus.reservationservice.domin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface IUserDAO extends JpaRepository<User, Long> {

    @RestResource(path = "byname")
    @Query(value = "from User where name = :name")
    List<User> findByName(@Param("name") String name);
}
