package com.example.__todo_tracker.services.impl;

import com.example.__todo_tracker.models.Task;
import com.example.__todo_tracker.services.TaskService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskServiceImpl implements TaskService {
    Map<Long,Task> taskList = new HashMap<>();

    @Override
    public void createTask(Task task) {
        taskList.put(task.getId(),task);
    }

    @Override
    public List<Task> getAllTask() {
        return new ArrayList<>(taskList.values());
    }
}
