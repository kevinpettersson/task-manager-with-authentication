package com.kevinpe.task_service;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class TaskServiceControllerTests {

    // Inject the controller before the tests
    @Autowired
    private TaskServiceController taskServiceController;

    // Test that the application has loaded necessary context.
    @Test
    void contextLoads() {
        Assertions.assertNotNull(taskServiceController);
    }

    @Test
    void testHelloWorld() {
        Assertions.assertEquals("Hello World!", taskServiceController.helloWorld());
    }
}
