package com.example.userbackend.service.impl;

import com.example.userbackend.model.User;
import com.example.userbackend.repository.UserRepository;
import com.example.userbackend.service.UserService;
import org.springframework.expression.ExpressionException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        super();
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public User registerUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
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
