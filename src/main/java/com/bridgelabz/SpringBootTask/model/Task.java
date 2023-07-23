package com.bridgelabz.SpringBootTask.model;

import com.bridgelabz.SpringBootTask.dto.TaskDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Table(name = "Task_Table")
public @Data class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;
        public Task() {
    }

    public Task(TaskDTO taskDTO) {
        this.updateTask(taskDTO);

    }

    public void updateTask(TaskDTO taskDTO) {
        this.title = taskDTO.title;
        this.description = taskDTO.description;
        this.dueDate = taskDTO.dueDate;

    }

}