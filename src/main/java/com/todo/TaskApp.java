package com.todo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskApp {
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private static final String TASKS_FILE = "tasklist/tasks.txt";


    public TaskApp() {
        JFrame frame = new JFrame("Task App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = JOptionPane.showInputDialog(frame, "Enter Task");
                if (task != null && !task.trim().isEmpty()) {
                    listModel.addElement(task);
                    saveTasks();
                }
            }
        });

        JButton removeButton = new JButton("Remove Task");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
                saveTasks();
            }
        });

        JButton editButton = new JButton("Edit Task");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String task = JOptionPane.showInputDialog(frame, "Edit Task", listModel.get(selectedIndex));
                    if (task != null && !task.trim().isEmpty()) {
                        listModel.set(selectedIndex, task);
                    }
                }
                saveTasks();
            }
        });

        frame.add(new JScrollPane(taskList));
        frame.add(addButton);
        frame.add(removeButton);
        frame.add(editButton);
        frame.setVisible(true);
        loadTasks();
    }
    private void saveTasks() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(TASKS_FILE))) {
            for (int i = 0; i < listModel.getSize(); i++) {
                writer.write(listModel.getElementAt(i));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTasks() {
        Path path = Paths.get(TASKS_FILE);
        if (!Files.exists(path)) {
            return;
        }

        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                listModel.addElement(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskApp();
            }
        });
    }
}