package com.mycompany.addApplications;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gameo
 */
public class AddApplicationFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField companyNameField;
    private JTextField positionField;
    private JTextField statusField;
    private JTextField dateField;

    public AddApplicationFrame() {
        setTitle("Job Application Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel Blue
        JLabel headerLabel = new JLabel("Add Applications");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 36));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Table Setup
        String[] columnNames = {"Company Name", "Position", "Status", "Due-Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Input Panel Setup
        JPanel inputPanel = new JPanel(new GridLayout(2, 5, 10, 10));

        JLabel companyNameLabel = new JLabel("Company Name:");
        companyNameField = new JTextField();

        JLabel positionLabel = new JLabel("Position:");
        positionField = new JTextField();

        JLabel statusLabel = new JLabel("Status:");
        statusField = new JTextField();

        JLabel dateLabel = new JLabel("Due-Date:");
        dateField = new JTextField();

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new AddButtonListener());

        JButton deleteButton = new JButton("Delete Selected");
        deleteButton.addActionListener(new DeleteButtonListener());

        inputPanel.add(companyNameLabel);
        inputPanel.add(companyNameField);
        inputPanel.add(positionLabel);
        inputPanel.add(positionField);
        inputPanel.add(statusLabel);
        inputPanel.add(statusField);
        inputPanel.add(dateLabel);
        inputPanel.add(dateField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        // Adding Components
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.add(inputPanel);
        
        add(scrollPane, BorderLayout.CENTER);
       // add(inputPanel, BorderLayout.SOUTH);

        // Footer Panel
       JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(70, 130, 180)); // Steel Blue
        JLabel footerLabel = new JLabel("© 2025 Job Application Tracker. All Rights Reserved.", JLabel.CENTER);
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);
        southPanel.add(statusBar, BorderLayout.NORTH);

        southPanel.add(footerPanel, BorderLayout.SOUTH);

        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String companyName = companyNameField.getText().trim();
            String position = positionField.getText().trim();
            String status = statusField.getText().trim();
            String date = dateField.getText().trim();

            if (companyName.isEmpty() || position.isEmpty() || status.isEmpty() || date.isEmpty()) {
                JOptionPane.showMessageDialog(AddApplicationFrame.this,
                        "All fields must be filled out.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            tableModel.addRow(new Object[]{companyName, position, status, date});

            companyNameField.setText("");
            positionField.setText("");
            statusField.setText("");
            dateField.setText("");
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(AddApplicationFrame.this,
                        "Please select a row to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
            } else {
                tableModel.removeRow(selectedRow);
            }
        }
    }

    public static void main(String[] args) {
          new AddApplicationFrame();
    }
}
