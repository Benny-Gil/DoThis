package com.todo;

import java.time.LocalDate;

public class Task {
    private String taskName;
    private String taskDescription;
    private LocalDate taskDueDate;
    private String taskStatus;
    private int taskPriority;

    public Task(String taskName, String taskDescription, LocalDate taskDueDate, String taskStatus, int taskPriority) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDueDate = taskDueDate;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getTaskDueDate() {
        return taskDueDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskDueDate(LocalDate taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }
}