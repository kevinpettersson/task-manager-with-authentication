package com.kevinpe.task_service.service;

import com.kevinpe.task_service.model.Task;
import com.kevinpe.task_service.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(Task task){
        return this.taskRepository.save(task);
    }

    public void delete(Integer id){
        if(this.taskRepository.findById(id).isPresent()){
            Task task = this.taskRepository.findById(id).get();
            this.taskRepository.delete(task);
        }else{
            throw new RuntimeException("task not found");
        }
    }
}
