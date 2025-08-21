package com.kevinpe.task_service;

import com.kevinpe.task_service.model.Task;
import com.kevinpe.task_service.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TaskRepository taskRepository;

    private String getBaseUrl() {
        return "http://localhost:" + port;
    }

    @Test
    void testHelloWorld() {
        String url = getBaseUrl() + "/helloworld";
        String response = restTemplate.getForObject(url, String.class);
        assertEquals("Hello World!", response);
    }

    @Test
    void testCreateTask() {
        taskRepository.deleteAll();

        String url = getBaseUrl() + "/create";
        Task task = new Task("Kevin", "Jobba");

        Task createdTask = restTemplate.postForObject(url, task, Task.class);

        assertNotNull(createdTask);
        assertNotNull(createdTask.getId());
        assertEquals("Kevin", createdTask.getName());
        assertEquals("Jobba", createdTask.getDescription());
    }

    @Test
    void testDeleteTask() {
        taskRepository.deleteAll();

        String url = getBaseUrl() + "/create";
        Task task = new Task("Kevin", "Jobba");

        Task createdTask = restTemplate.postForObject(url, task, Task.class);

        // verify creation
        assertTrue(taskRepository.findById(createdTask.getId()).isPresent());

        restTemplate.delete(getBaseUrl() + "/delete?id={id}", createdTask.getId());

        // verify deletion
        assertFalse(taskRepository.findById(createdTask.getId()).isPresent());
    }
}
