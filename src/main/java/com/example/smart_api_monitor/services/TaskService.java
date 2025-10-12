package com.example.smart_api_monitor.services;

import com.example.smart_api_monitor.model.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    List<Task> getAllTasks();

    void deleteTask(String id);

}
