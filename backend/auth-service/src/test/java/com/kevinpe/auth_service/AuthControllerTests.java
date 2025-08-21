package com.kevinpe.auth_service;

import com.kevinpe.auth_service.controller.AuthController;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class AuthControllerTests {

    // Inject the controller before the tests
    @Autowired
    private AuthController authController;

    // Test that the application has loaded necessary context.
    @Test
    void contextLoads() {
        Assertions.assertNotNull(authController);
    }
}
