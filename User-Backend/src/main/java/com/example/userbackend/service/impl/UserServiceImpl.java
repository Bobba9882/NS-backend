package com.example.userbackend.service.impl;

import com.example.userbackend.model.User;
import com.example.userbackend.repository.UserRepository;
import com.example.userbackend.service.UserService;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (Objects.equals(password, user.getPassword())) {
            return user;
        } else {
            throw new ExpressionException("Incorrect password");
        }
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.findById(id).orElseThrow(() -> new ExpressionException("Can't find user"));
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user, long id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ExpressionException("Can't find user"));
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPassword(user.getPassword());
        userRepository.save(existingUser);
        return existingUser;
    }
}
