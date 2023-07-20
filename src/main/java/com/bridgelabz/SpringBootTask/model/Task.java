package com.bridgelabz.SpringBootTask.model;

import com.bridgelabz.SpringBootTask.dto.TaskDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Task_Table")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    public Task() {
    }

    public Task(TaskDTO taskDTO){
    this.updateTask(taskDTO);

}
public void updateTask(TaskDTO taskDTO){
    this.title=taskDTO.title;
    this.description=taskDTO.description;
    this.dueDate=taskDTO.dueDate;
    this.completed=taskDTO.completed;
}



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
