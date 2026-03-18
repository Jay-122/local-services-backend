package com.jay.localservices.repository;


import org.springframework.data.jpa.repository.JpaRepository;
// JpaRepository gives CRUD methods

import com.jay.localservices.model.User;
// Importing User entity

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}