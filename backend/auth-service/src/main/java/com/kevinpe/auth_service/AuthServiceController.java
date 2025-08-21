package com.kevinpe.auth_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthServiceController {

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "Hello World";
    }
}
