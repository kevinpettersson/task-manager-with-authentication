package com.kevinpe.task_service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/tasks")
@RestController
public class TaskServiceController {

    private final TaskRepository taskRepository;

    public TaskServiceController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping("/create")
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }
}
