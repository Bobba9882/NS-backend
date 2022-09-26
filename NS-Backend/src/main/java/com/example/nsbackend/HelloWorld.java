package com.example.nsbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping
    private String Hellow(){
        return  "Hello Meow";
    }
}
