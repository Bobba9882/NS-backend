package com.example.userbackend.service;

import com.example.userbackend.model.User;

public interface UserService {
    User loginUser(String email, String password);
    User registerUser(User user);
    void deleteUser(long id);
    User updateUser(User user, long id);
}
