package com.example.webgiay.repository;

import com.example.webgiay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByName(String name);

    @Query("SELECT u FROM User u WHERE User = :user")
    User findByUser(@Param("user") User user);

}