package com.example.__todo_tracker.controllers;


import com.example.__todo_tracker.models.Task;
import com.example.__todo_tracker.services.TaskService;
import com.example.__todo_tracker.utils.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> allTask = taskService.getAllTask();

        if(allTask == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(allTask);
    }


    @PatchMapping("/{taskId}/status")
    public ResponseEntity<Task> changeStatus(@PathVariable Long taskId){
        Task task = taskService.changeStatus(taskId);

        if(task == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(task);
    }


    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Long taskId){

        Task task = taskService.deleteTask(taskId);

        if(task == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Task available with this "+taskId);
        }

        return ResponseEntity.ok().body("Task Deleted successfully...");
    }
}
