package com.todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskApp {
    private DefaultListModel<String> listModel;
    private JList<String> taskList;

    public TaskApp() {
        JFrame frame = new JFrame("Task App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
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
            }
        });

        frame.add(new JScrollPane(taskList));
        frame.add(addButton);
        frame.add(removeButton);
        frame.add(editButton);
        frame.setVisible(true);
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