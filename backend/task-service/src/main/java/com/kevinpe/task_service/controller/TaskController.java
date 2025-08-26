package com.kevinpe.task_service.controller;

import com.kevinpe.task_service.model.Task;
import com.kevinpe.task_service.service.TaskService;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<Task> create(@RequestBody Task task, HttpSession session) {
        Task savedTask = this.taskService.create(task);
        return ResponseEntity.ok(savedTask);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Integer id,  HttpSession session) {
        this.taskService.delete(id);
        return ResponseEntity.ok("Task deleted");
    }
}
