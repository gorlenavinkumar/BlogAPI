package com.example.blogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods if needed
}

