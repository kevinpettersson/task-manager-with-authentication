package com.kevinpe.auth_service.service;

import com.kevinpe.auth_service.model.Account;
import com.kevinpe.auth_service.repository.AuthRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Account register(Account account) {
        if (authRepository.findByUsername(account.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists.");
        }

        account.setPassword(this.passwordEncoder.encode(account.getPassword()));

        return authRepository.save(account);
    }

    public void login(Account account) {
        if (authRepository.findByUsername(account.getUsername()).isPresent()){
            Account user = authRepository.findByUsername(account.getUsername()).get();

            if (!this.passwordEncoder.matches(account.getPassword(), user.getPassword())){
                throw new RuntimeException("Invalid username or password.");
            }
        } else {
            throw new RuntimeException("Invalid username or password.");
        }
    }
}
