package com.kevinpe.task_service.controller;

import com.kevinpe.task_service.model.Task;
import com.kevinpe.task_service.service.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000") // allow React dev server
@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<Task> create(@RequestBody Task task) {
        Task savedTask = this.taskService.create(task);
        return ResponseEntity.ok(savedTask);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> list = this.taskService.getTasks();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, String>> delete(@RequestParam Integer id) {
        this.taskService.delete(id);
        return ResponseEntity.ok(Map.of("message", "Task deleted"));
    }
}
