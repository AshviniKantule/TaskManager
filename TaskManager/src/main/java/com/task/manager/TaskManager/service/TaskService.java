package com.task.manager.TaskManager.service;

import com.task.manager.TaskManager.entities.Task;
import com.task.manager.TaskManager.entities.User;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task saveTask(Task task);
    List<Task> getAllTask();
    Optional<Task> getTaskById(String taskId);

    Task updateTask(String taskId, Task task);

    void deleteTaskById(String taskId);

    Task assignTask(User user, String taskId);
}
