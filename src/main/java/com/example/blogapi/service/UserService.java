package com.example.blogapi.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogapi.model.User;
import com.example.blogapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a user by ID
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));
    }

    // Create a new user
    public User createUser(User user) {
        // Perform any business logic/validation if required before saving
        return userRepository.save(user);
    }

    // Update an existing user
    public User updateUser(Long userId, User userDetails) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

        // Update existing user details
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setEmail(userDetails.getEmail());
        // Update other fields if needed

        return userRepository.save(existingUser);
    }

    // Delete a user
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

        userRepository.delete(user);
    }
}

