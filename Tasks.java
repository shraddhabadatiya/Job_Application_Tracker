package com.mycompany.tasks;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.data.gantt.Task;


public class Tasks extends JFrame  {
     public Tasks() {
        
        setTitle("Task Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

       
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel Blue

        JLabel headerLabel = new JLabel("Task Management", JLabel.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 36));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(70, 130, 180)); // Steel Blue

        JLabel footerLabel = new JLabel("© 2025 Job Application Tracker. All Rights Reserved.", JLabel.CENTER);
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);

        
        JPanel bodyPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JPanel uploadPanel = createFunctionPanel("Upload Resume", "C:\\Users\\gameo\\Downloads\\icons8-upload-50.png");
        JPanel deadlinesPanel = createFunctionPanel("Check Deadlines", "C:\\Users\\gameo\\Downloads\\icons8-calendar-50.png");
        JPanel researchPanel = createFunctionPanel("Research & Publish", "C:\\Users\\gameo\\Downloads\\icons8-book-50.png");

       
        bodyPanel.add(uploadPanel);
        bodyPanel.add(deadlinesPanel);
        bodyPanel.add(researchPanel);

        
        add(headerPanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private JPanel createFunctionPanel(String title, String iconPath) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createDashedBorder(Color.GRAY));

        ImageIcon icon = new ImageIcon(iconPath);
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        panel.add(iconLabel, BorderLayout.CENTER);
        panel.add(titleLabel, BorderLayout.SOUTH);

        return panel;
    }
    public static void main(String[] args) {  
         SwingUtilities.invokeLater(() -> {
            Tasks taskFrame = new Tasks();
            taskFrame.setVisible(true);
        });
         
    }

}
