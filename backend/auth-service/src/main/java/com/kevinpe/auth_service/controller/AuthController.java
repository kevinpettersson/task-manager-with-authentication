package com.kevinpe.auth_service.controller;

import com.kevinpe.auth_service.model.Account;
import com.kevinpe.auth_service.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Account account) {
        authService.register(account);
        return ResponseEntity.ok("Account successfully registered");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Account account) {
        authService.login(account);
        return ResponseEntity.ok("Account successfully logged in");
    }

    // Handles all RuntimeExceptions thrown in this controller
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
