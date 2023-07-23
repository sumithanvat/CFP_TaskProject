package com.bridgelabz.SpringBootTask.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TaskDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-z,A-Z]{2,}$", message = "Title pattern Not Matching")
   @NotEmpty(message = "Title Pattern is not matching")
    public String title;
    @Pattern(regexp = "^[A-Z]{1}[a-z,A-Z]{2,}$", message = "Description pattern Mismatch")
    @NotEmpty(message = "Description Pattern is not matching")
    public String description;
    public LocalDate dueDate;

}