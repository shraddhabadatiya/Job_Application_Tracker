package com.mycompany.viewapplication;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableCellRenderer;


public class ViewApplication {

    public static void main(String[] args) {
       SwingUtilities.invokeLater(ViewApplication::createAndShowGUI);

    }
private static void createAndShowGUI() {
        // Main frame
        JFrame frame = new JFrame("Job Application Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(new BorderLayout());

        
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel Blue

        JLabel headerLabel = new JLabel("View Applications");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 36));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(headerLabel, BorderLayout.CENTER);

       
       JLabel profileLabel = new JLabel();

        ImageIcon profileIcon = new ImageIcon("C:/Users/gameo/Downloads/4092564_profile_about_mobile ui_user_icon.png");
        Image img = profileIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Resize to 40x40
        profileLabel.setIcon(new ImageIcon(img));
        headerPanel.add(profileLabel, BorderLayout.EAST);

        frame.add(headerPanel, BorderLayout.NORTH);

   
        String[] columnNames = {
                "Company Name", "Job Title", "Application Date", "Status",
                "Location", "Salary Range", "Follow-Up Date", "Notes"
        };

        Object[][] data = {
                {"ABC Corp", "Software Engineer", "2025-10-01", "Interview Scheduled", "Remote", "$80,000 - $100,000", "2025-10-15", "Great fit!"},
                {"XYZ Inc", "Data Analyst", "2025-09-25", "Rejected", "On-site", "$70,000 - $90,000", "N/A", "Follow up next time"},
                {"TechGenius", "Backend Developer", "2025-11-01", "Application Submitted", "Hybrid", "$95,000 - $120,000", "2025-11-10", "Requires Java experience."},
    {"SoftServe", "Product Manager", "2025-10-20", "Interview Scheduled", "Remote", "$100,000 - $130,000", "2025-10-30", "Exciting opportunity!"},
    {"FinTech Solutions", "Financial Analyst", "2025-09-15", "Offer Received", "On-site", "$85,000 - $105,000", "2025-09-25", "Negotiated salary."},
    {"DreamWorks", "UI/UX Designer", "2025-08-30", "Rejected", "Remote", "$75,000 - $95,000", "N/A", "Portfolio feedback was positive."},
    {"CodeNation", "Full Stack Developer", "2025-11-15", "Application Submitted", "Hybrid", "$110,000 - $140,000", "2025-11-25", "Strong React/Node.js skills required."},
    {"DataMinds", "Data Scientist", "2025-10-05", "Interview Scheduled", "Remote", "$120,000 - $150,000", "2025-10-18", "Focus on machine learning."},
    {"HealthCare Inc", "Business Analyst", "2025-09-01", "Offer Declined", "On-site", "$70,000 - $90,000", "2025-09-10", "Role not aligned with career goals."}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);

       
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setFont(new Font("Serif", Font.BOLD, 18)); // Unique font style and size for column headers
        headerRenderer.setBackground(new Color(200, 200, 200)); // Light gray background for headers
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

       
        addButton.addActionListener(e -> addRow(tableModel));
        editButton.addActionListener(e -> editRow(table, tableModel));
        deleteButton.addActionListener(e -> deleteRow(table, tableModel));

        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(70, 130, 180)); // Steel Blue
        JLabel footerLabel = new JLabel("© 2025 Job Application Tracker. All Rights Reserved.", JLabel.CENTER);
        footerLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(footerPanel, BorderLayout.SOUTH);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private static void addRow(DefaultTableModel tableModel) {
        tableModel.addRow(new Object[]{"", "", "", "", "", "", "", ""});
    }

    private static void editRow(JTable table, DefaultTableModel tableModel) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(table, "Please select a row to edit.");
            return;
        }

        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            String newValue = JOptionPane.showInputDialog(
                    table, "Edit value for " + tableModel.getColumnName(i),
                    tableModel.getValueAt(selectedRow, i)
            );

            if (newValue != null) {
                tableModel.setValueAt(newValue, selectedRow, i);
            }
        }
    }

    private static void deleteRow(JTable table, DefaultTableModel tableModel) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(table, "Please select a row to delete.");
            return;
        }

        tableModel.removeRow(selectedRow);
    }

}

   

