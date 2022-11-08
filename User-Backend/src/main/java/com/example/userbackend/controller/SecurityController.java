package com.example.userbackend.controller;

import com.example.userbackend.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/token")
@CrossOrigin(origins = "*")
public class SecurityController {


    private final TokenService tokenService;

    public SecurityController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String token(Authentication authentication){
        String token = tokenService.generateToken(authentication);
        return "{\"text\":\"" +token+ "\"}";
    }
}
