package com.kevinpe.task_service;

import com.kevinpe.task_service.model.Task;
import com.kevinpe.task_service.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class TaskRepositoryTests {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testCreate() {
        taskRepository.deleteAll();

        Task task = new Task("Kevin", "Jobba hemifrån");
        Task createdTask = taskRepository.save(task);
        Optional<Task> foundTask = taskRepository.findById(createdTask.getId());

        assertTrue(foundTask.isPresent());
        assertEquals(foundTask.get(), task);

        Assertions.assertEquals("Kevin", taskRepository.findAll().get(0).getName());
        Assertions.assertEquals("Jobba hemifrån", taskRepository.findAll().get(0).getDescription());
    }
}
