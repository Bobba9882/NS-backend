package com.example.userbackend.service.impl;

import com.example.userbackend.model.User;
import com.example.userbackend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User LoginUser(String email, String password) {
        return null;
    }

    @Override
    public User RegisterUser(User user) {
        return null;
    }

    @Override
    public User DeleteUser(User user) {
        return null;
    }

    @Override
    public User UpdateUser(User user, long id) {
        return null;
    }
}
