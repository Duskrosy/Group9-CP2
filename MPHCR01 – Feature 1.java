/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.motorphemployeeapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MOTORPHEMPLOYEEAPP {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MOTORPHEMPLOYEEAPP().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("MotorPH Employee App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Dashboard Tab
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.add(new JLabel("Welcome to MotorPH Employee System!"));
        tabbedPane.addTab("Dashboard", dashboardPanel);

        // Profile Tab with Input Validation
        JPanel profilePanel = new JPanel(new GridLayout(6, 2, 10, 10));
        JTextField empNoField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField positionField = new JTextField();
        JTextField departmentField = new JTextField();
        JTextField emailField = new JTextField();

        profilePanel.add(new JLabel("Employee No:"));
        profilePanel.add(empNoField);
        profilePanel.add(new JLabel("Name:"));
        profilePanel.add(nameField);
        profilePanel.add(new JLabel("Position:"));
        profilePanel.add(positionField);
        profilePanel.add(new JLabel("Department:"));
        profilePanel.add(departmentField);
        profilePanel.add(new JLabel("Email:"));
        profilePanel.add(emailField);

        JButton saveButton = new JButton("Save");
        profilePanel.add(new JLabel()); // empty cell
        profilePanel.add(saveButton);

        saveButton.addActionListener(e -> {
            try {
                int empNo = Integer.parseInt(empNoField.getText().trim());
                String name = nameField.getText().trim();
                String position = positionField.getText().trim();
                String department = departmentField.getText().trim();
                String email = emailField.getText().trim();

                if (name.isEmpty() || position.isEmpty() || department.isEmpty() || email.isEmpty()) {
                    throw new IllegalArgumentException("All fields must be filled out.");
                }

                JOptionPane.showMessageDialog(frame, "Employee data saved successfully.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Employee Number. Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        tabbedPane.addTab("Profile", profilePanel);

        // Time Tracker Tab
        JPanel timePanel = new JPanel(new FlowLayout());
        JLabel timeLabel = new JLabel();
        updateTimeLabel(timeLabel);
        JButton timeInBtn = new JButton("Time In");
        JButton timeOutBtn = new JButton("Time Out");

        timeInBtn.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Time In recorded at: " + LocalTime.now()));
        timeOutBtn.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Time Out recorded at: " + LocalTime.now()));

        timePanel.add(timeLabel);
        timePanel.add(timeInBtn);
        timePanel.add(timeOutBtn);
        tabbedPane.addTab("Time Tracker", timePanel);

        // Payroll Tab
        String[] columns = {"Period", "Gross Pay", "Deductions", "Net Pay"};
        Object[][] data = {
                {"May 2025", "15000.00", "2450.00", "12550.00"}
        };
        JTable payrollTable = new JTable(data, columns);
        tabbedPane.addTab("Payroll", new JScrollPane(payrollTable));

        // Logout Tab
        JPanel logoutPanel = new JPanel();
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to logout?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        logoutPanel.add(logoutButton);
        tabbedPane.addTab("Logout", logoutPanel);

        frame.add(tabbedPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void updateTimeLabel(JLabel label) {
        Timer timer = new Timer(1000, e -> {
            label.setText("Current Time: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        });
        timer.start();
    }
}