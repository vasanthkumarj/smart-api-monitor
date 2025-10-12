package com.example.smart_api_monitor.controllers;

import com.example.smart_api_monitor.model.Task;
import com.example.smart_api_monitor.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    private TaskService defaultTaskService;

    @PostMapping(value = "/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.status(HttpStatus.CREATED).body(defaultTaskService.createTask(task));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.status(HttpStatus.OK).body(defaultTaskService.getAllTasks());
    }

    @DeleteMapping(value = "/remove/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeTask(@PathVariable String id){
        defaultTaskService.deleteTask(id);
    }

}
