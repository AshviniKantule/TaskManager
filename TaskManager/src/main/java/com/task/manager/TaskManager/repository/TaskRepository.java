package com.task.manager.TaskManager.repository;

import com.task.manager.TaskManager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,String> {

}
