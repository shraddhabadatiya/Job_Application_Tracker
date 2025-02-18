import javax.swing.*;
import java.awt.*;

public class AboutUsFrame {
    public static void main(String[] args) {
                JFrame frame = new JFrame("About Us - Task Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

       
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel Blue
        JLabel headerLabel = new JLabel("ABOUT US", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 36));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        frame.add(headerPanel, BorderLayout.NORTH);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 3, 10, 10)); // 3 columns with gaps
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        mainPanel.add(createCard("C:/Users/gameo/lena deni/ayush.50.jpg", "Ayush Kalyan Meher", 
                "https://www.linkedin.com/in/ayush-kalyan-meher/", "2026", "C V Raman Global University", "Team Leader & Developer"));
        mainPanel.add(createCard("C:/Users/gameo/Downloads/shraddha.png", "Shraddha Suman", 
                "https://www.linkedin.com/in/shraddha-suman-4193ab24a", "2026", "C V Raman Global University", "Developer"));
        mainPanel.add(createCard("C:/Users/gameo/Downloads/smruti.png", "Smruti Samal", 
                "https://www.linkedin.com/in/smruti-samal-a19305341", "2026", "C V Raman Global University", "Designer"));

        frame.add(mainPanel, BorderLayout.CENTER);


        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(70, 130, 180)); // Steel Blue
        JLabel footerLabel = new JLabel("© 2025 Job Application Tracker. All Rights Reserved.", JLabel.CENTER);
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);
        frame.add(footerPanel, BorderLayout.SOUTH);


        frame.setVisible(true);
    }

    private static JPanel createCard(String imagePath, String name, String linkedin, String year, String university, String role) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createDashedBorder(Color.GRAY, 5, 5));
        card.setBackground(Color.WHITE);

     
        JPanel circleImagePanel = new JPanel();
        circleImagePanel.setLayout(new BorderLayout());
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        circleImagePanel.add(imageLabel, BorderLayout.CENTER);
        circleImagePanel.setBackground(Color.LIGHT_GRAY);
        card.add(circleImagePanel, BorderLayout.NORTH);

       
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 1));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        infoPanel.add(new JLabel("Name: " + name, SwingConstants.CENTER));
        infoPanel.add(new JLabel("LinkedIn: " + linkedin, SwingConstants.CENTER));
        infoPanel.add(new JLabel("Graduating Year: " + year, SwingConstants.CENTER));
        infoPanel.add(new JLabel("University: " + university, SwingConstants.CENTER));
        infoPanel.add(new JLabel("Role: " + role, SwingConstants.CENTER));

    
        for (Component comp : infoPanel.getComponents()) {
            if (comp instanceof JLabel && ((JLabel) comp).getText().startsWith("LinkedIn:")) {
                ((JLabel) comp).setFont(new Font("Arial", Font.PLAIN, 12));
            }
        }

        card.add(infoPanel, BorderLayout.CENTER);
        return card;
    }
}