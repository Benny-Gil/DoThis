package com.todo;

public class Task {
    private String taskName;
    private String taskDescription;
    private String taskDueDate;
    private String taskStatus;

    public Task(String taskName, String taskDescription, String taskDueDate, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDueDate = taskDueDate;
        this.taskStatus = taskStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskDueDate() {
        return taskDueDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
