package com.task.manager.TaskManager.controller;

import com.task.manager.TaskManager.entities.Task;
import com.task.manager.TaskManager.entities.User;
import com.task.manager.TaskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskManagerController {
    @Autowired
    TaskService taskService;
    @PostMapping("/tasks")
    public ResponseEntity<Task> createUser(@RequestBody Task task){
        Task task1 = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task1);
    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<Task> updateTaskById(@PathVariable String taskId, @RequestBody Task task){
       Task obj = taskService.updateTask(taskId, task);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity deleteById(@PathVariable String taskId){
        taskService.deleteTaskById(taskId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getUserById() {
        return ResponseEntity.ok(taskService.getAllTask());
    }
    @PostMapping("/tasks/{taskId}/assign")
    public ResponseEntity<Task> assignTask(@RequestBody User user, @PathVariable String taskId){
        Task task  =taskService.assignTask(user,taskId);
        return  ResponseEntity.ok(task);
    }
}
