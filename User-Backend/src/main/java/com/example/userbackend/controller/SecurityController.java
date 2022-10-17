package com.example.userbackend.controller;

import com.example.userbackend.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/token")
@CrossOrigin
public class SecurityController {

    private static final Logger LOG = LoggerFactory.getLogger(SecurityController.class);

    private final TokenService tokenService;

    public SecurityController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    public String token(Authentication authentication){
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token generated:  {}", token);
        return token;
    }
}
