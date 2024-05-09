package com.task.manager.TaskManager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private String userId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskId", referencedColumnName = "taskid")
    private Task task;
}
