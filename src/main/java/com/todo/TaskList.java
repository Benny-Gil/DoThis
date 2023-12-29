package com.todo;

public class TaskList {
    private Task[] tasks;
    private int size;

    public TaskList() {
        this.tasks = new Task[100];
        this.size = 0;
    }

    public TaskList(Task[] tasks) {
        this.tasks = tasks;
        this.size = tasks.length;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public int getSize() {
        return size;
    }

    public void addTask(Task task) {
        tasks[size] = task;
        size++;
    }

    public void removeTask(int index) {
        for (int i = index; i < size - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        size--;
    }

    public void editTask(int index, Task task) {
        tasks[index] = task;
    }

    public Task getTask(int index) {
        return tasks[index];
    }

    public TaskList searchTask(String keyword) {
        Task[] searchResults = new Task[100];
        int searchResultsSize = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].getTaskName().contains(keyword)) {
                searchResults[searchResultsSize] = tasks[i];
                searchResultsSize++;
            }
        }
        return new TaskList(searchResults);
    }

    public TaskList filterTask(String keyword) {
        Task[] filterResults = new Task[100];
        int filterResultsSize = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].getTaskStatus().equals(keyword)) {
                filterResults[filterResultsSize] = tasks[i];
                filterResultsSize++;
            }
        }
        return new TaskList(filterResults);
    }
}
