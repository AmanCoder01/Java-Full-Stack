package com.example.__todo_tracker.services;

import com.example.__todo_tracker.models.Task;
import com.example.__todo_tracker.utils.TaskStatus;

import java.util.List;

public interface TaskService {
    void createTask(Task task);
    List<Task> getAllTask();
    Task changeStatus(Long taskId);
    Task deleteTask(Long taskId);
}
