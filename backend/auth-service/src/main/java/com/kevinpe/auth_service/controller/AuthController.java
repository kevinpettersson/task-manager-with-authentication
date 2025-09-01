package com.kevinpe.auth_service.controller;

import com.kevinpe.auth_service.model.Account;
import com.kevinpe.auth_service.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000") // allow React dev server
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public Account register(@RequestBody Account account) {
        return authService.register(account);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Account account) {
        String token = authService.login(account);
        return  ResponseEntity.ok(Map.of("token", token));
    }

    // Handles all RuntimeExceptions thrown in this controller
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
