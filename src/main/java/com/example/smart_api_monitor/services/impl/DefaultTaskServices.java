package com.example.smart_api_monitor.services.impl;

import com.example.smart_api_monitor.model.Task;
import com.example.smart_api_monitor.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefaultTaskServices implements TaskService {

    Map<String, Task> taskMap;

    DefaultTaskServices(){
        this.taskMap = new HashMap<>();
    }

    @Override
    public Task createTask(Task task) {
        taskMap.put(task.getId(), task);
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        for(Map.Entry<String, Task> entry : taskMap.entrySet()){
            tasks.add(entry.getValue());
        }
        try {
            Thread.sleep(501);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return tasks;
    }

    @Override
    public void deleteTask(String id) {
        if(taskMap.containsKey(id)){
            taskMap.remove(id);
        }
    }
}
