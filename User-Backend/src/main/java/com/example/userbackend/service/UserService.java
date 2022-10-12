package com.example.userbackend.service;

import com.example.userbackend.model.User;

public interface UserService {
    User LoginUser(String email, String password);
    User RegisterUser(User user);
    User DeleteUser(User user);
    User UpdateUser(User user, long id);
}
