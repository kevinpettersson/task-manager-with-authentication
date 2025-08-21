package com.kevinpe.task_service.controller;

import com.kevinpe.task_service.model.Task;
import com.kevinpe.task_service.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
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

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id) {
        taskRepository.deleteById(id);
    }
}
