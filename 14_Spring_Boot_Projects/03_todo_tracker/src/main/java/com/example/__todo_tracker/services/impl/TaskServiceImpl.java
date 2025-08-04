package com.example.__todo_tracker.services.impl;

import com.example.__todo_tracker.models.Task;
import com.example.__todo_tracker.services.TaskService;
import com.example.__todo_tracker.utils.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
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

    @Override
    public Task changeStatus(Long taskId) {
        Task task = taskList.get(taskId);

        if(task==null){
            return null;
        }

        if(task.getStatus() == TaskStatus.COMPLETED){
            task.setStatus(TaskStatus.PENDING);
        }else{
            task.setStatus(TaskStatus.COMPLETED);
        }

        taskList.put(taskId,task);

        return task;
    }

    @Override
    public Task deleteTask(Long taskId) {
        return taskList.remove(taskId);
    }
}
