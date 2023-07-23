package com.bridgelabz.SpringBootTask.controller;

import com.bridgelabz.SpringBootTask.dto.ResponceDTO;
import com.bridgelabz.SpringBootTask.dto.TaskDTO;
import com.bridgelabz.SpringBootTask.model.Task;
import com.bridgelabz.SpringBootTask.repository.TaskRepository;
import com.bridgelabz.SpringBootTask.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
  private TaskService taskService;

    @PostMapping("/addtask")
    public ResponseEntity<ResponceDTO> addTask(@RequestBody@Valid TaskDTO taskDTO){
        ResponceDTO responceDTO=new ResponceDTO("Data added successfully",taskService.addTask(taskDTO));
        return new ResponseEntity<>(responceDTO, HttpStatus.CREATED);
    }
    @GetMapping("/GetAllTask")
    public ResponseEntity<ResponceDTO> getAllTask() {
        ResponceDTO responceDTO = new ResponceDTO(" All Data Retrieve Successfully",
                taskService.findAll());
        return new ResponseEntity<>(responceDTO, HttpStatus.OK);
    }
    @GetMapping("/getbyid/task/{id}")
    public ResponseEntity<ResponceDTO> getById(@PathVariable long id){
        ResponceDTO responceDTO=new ResponceDTO("Data Fetch successfully",taskService.getById(id));
        return new ResponseEntity<>(responceDTO,HttpStatus.OK);
    }
    @PutMapping("/update/task/{id}")
    public ResponseEntity<ResponceDTO> updateTask(@PathVariable long id, @RequestBody TaskDTO taskDTO) {
        ResponceDTO responseDTO = new ResponceDTO("data updated",taskService.updateTask(id,taskDTO));
        return  new ResponseEntity<>(responseDTO,HttpStatus.OK);


    }
    @DeleteMapping("/delete/task/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable long id) {
        return taskService.deleteTask(id);
    }

}
