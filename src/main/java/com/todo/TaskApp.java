package com.todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TaskApp {
    private static final String TASKS_FILE = "tasklist/tasks.txt";
    private DefaultListModel<String> listModel;
    private JList<String> taskList;


    public TaskApp() {
        JFrame frame = new JFrame("Task App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Task");
        addButton.setToolTipText("Add a new task");

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
        removeButton.setToolTipText("Remove the selected task");
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
        editButton.setToolTipText("Edit the selected task");
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

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);

        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        loadTasks();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskApp();
            }
        });
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
}