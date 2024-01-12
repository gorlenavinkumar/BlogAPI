package com.example.blogapi.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogapi.model.Post;
import com.example.blogapi.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // Retrieve all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Retrieve a post by ID
    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("Post not found with id: " + postId));
    }

    // Create a new post
    public Post createPost(Post post) {
        // Perform any business logic/validation if required before saving
        return postRepository.save(post);
    }

    // Update an existing post
    public Post updatePost(Long postId, Post postDetails) {
        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("Post not found with id: " + postId));

        // Update existing post details
        existingPost.setTitle(postDetails.getTitle());
        existingPost.setContent(postDetails.getContent());
        // Update other fields if needed

        return postRepository.save(existingPost);
    }

    // Delete a post
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("Post not found with id: " + postId));

        postRepository.delete(post);
    }
}

