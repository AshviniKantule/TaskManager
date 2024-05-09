package com.task.manager.TaskManager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
    @Id
    private String taskId;
    private String title;
    private String description;
    private String dueDate;
    private String status;
    @OneToOne(mappedBy = "task",cascade=CascadeType.ALL)
    private User user;
}
