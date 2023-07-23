package com.bridgelabz.SpringBootTask.service;

import com.bridgelabz.SpringBootTask.dto.TaskDTO;
import com.bridgelabz.SpringBootTask.exception.CostomException;
import com.bridgelabz.SpringBootTask.model.Task;
import com.bridgelabz.SpringBootTask.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
   public TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task addTask(TaskDTO taskDTO) {
        Task taskData = new Task(taskDTO);
        return taskRepository.save(taskData);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    public Task getById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task updateTask(long id, TaskDTO taskDTO) {
        Task task = getById(id);
        if (task != null) {
            System.out.println("Task before update: " + task);
            task.updateTask(taskDTO);
            System.out.println("Task after update: " + task);
            return taskRepository.save(task);
        }
        return null;
    }

    @Transactional
    public ResponseEntity<String> deleteTask(long id) {
        Optional<Task> taskData = taskRepository.findById(id);
        if (taskData.isPresent()) {
            taskRepository.deleteById(id);
            return ResponseEntity.ok("Task deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

}

