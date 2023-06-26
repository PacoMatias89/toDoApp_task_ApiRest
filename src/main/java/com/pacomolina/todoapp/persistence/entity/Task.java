package com.pacomolina.todoapp.persistence.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createDate;

//    Fecha de finalización estimada
    private LocalDateTime eta;

    private boolean finished;

    private TaskStatus taskStatus;

    public Task() {
    }

    public Task(Long id,
                String title,
                String description,
                LocalDateTime createDate,
                LocalDateTime eta,
                boolean finished,
                TaskStatus taskStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createDate = createDate;
        this.eta = eta;
        this.finished = finished;
        this.taskStatus = taskStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getEta() {
        return eta;
    }

    public void setEta(LocalDateTime eta) {
        this.eta = eta;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
