package com.kevinpe.auth_service;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class AuthServiceControllerTests {

    // Inject the controller before the tests
    @Autowired
    private AuthServiceController authServiceController;

    // Test that the application has loaded necessary context.
    @Test
    void contextLoads() {
        Assertions.assertNotNull(authServiceController);
    }
}
