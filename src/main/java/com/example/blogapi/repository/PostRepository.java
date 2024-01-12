package com.example.blogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blogapi.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // You can add custom query methods here if needed
    // For example, findByTitle(String title) to search posts by title
}

