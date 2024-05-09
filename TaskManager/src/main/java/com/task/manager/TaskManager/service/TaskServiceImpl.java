package com.task.manager.TaskManager.service;

import com.task.manager.TaskManager.entities.Task;
import com.task.manager.TaskManager.entities.User;
import com.task.manager.TaskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(String userId){
        return taskRepository.findById(userId);
    }

    @Override
    public Task updateTask(String taskId, Task task) {
        Optional<Task> obj = taskRepository.findById(taskId);
        obj.get().setDescription(task.getDescription());
        obj.get().setStatus(task.getStatus());
        obj.get().setTitle(task.getTitle());
        obj.get().setStatus(task.getStatus());
        Task updatedTask = taskRepository.save(obj.get());
        return updatedTask;
    }

    @Override
    public void deleteTaskById(String taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override    public Task assignTask(User user, String taskId) {
        Task task = taskRepository.findById(taskId).get();
        //user.setTask(task);
        task.setUser(user);
        return taskRepository.save(task);
    }
}
