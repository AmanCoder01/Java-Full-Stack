package com.example.__todo_tracker.services;

import com.example.__todo_tracker.models.Task;

import java.util.List;

public interface TaskService {
    void createTask(Task task);
    List<Task> getAllTask();
}
