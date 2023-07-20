package com.bridgelabz.SpringBootTask.service;

import com.bridgelabz.SpringBootTask.dto.TaskDTO;
import com.bridgelabz.SpringBootTask.exception.CostomException;
import com.bridgelabz.SpringBootTask.model.Task;
import com.bridgelabz.SpringBootTask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
   public TaskRepository taskRepository;

    public Task addTask(TaskDTO taskDTO) {
        Task taskData = new Task(taskDTO);
        return taskRepository.save(taskData);
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Optional<Task> getById(long id) {
        return Optional.ofNullable(taskRepository.findById(id).orElseThrow(() ->new CostomException("Task data with id "+id+"is not prasent")));
    }

    public Task updateTask(long id, TaskDTO taskDTO) {
        Optional<Task> TaskData = getById(id);
        if (TaskData.isPresent()) {
            TaskData.get().updateTask(taskDTO);
            return taskRepository.save(TaskData.get());
        }
        return null;
    }
}
