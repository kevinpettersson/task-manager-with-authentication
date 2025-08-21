package com.kevinpe.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "Hello World";
    }
}
