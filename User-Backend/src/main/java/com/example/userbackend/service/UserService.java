package com.example.userbackend.service;

import com.example.userbackend.model.User;

public interface UserService {
    User registerUser(User user);
    void deleteUser(long id);
    User updateUser(User user, long id);
}
