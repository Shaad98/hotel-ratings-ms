package com.example.user_service.service;

import java.util.List;
import java.util.Optional;

import com.example.user_service.model.User;

public interface UserService {

    // Create User
    Optional<User> createUser(User user);

    // Get User By ID
    Optional<User> getUserById(String userId);

    // Get All Users
    List<User> getAllUsers();

}
