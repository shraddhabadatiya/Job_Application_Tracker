import javax.swing.*;
import java.awt.*;

public class JobApplicationTracker {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.showLoginScreen();
        });
    }
}

// Login Screen
class LoginScreen {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginScreen() {
        frame = new JFrame("Job Application Tracker - Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(100, 149, 237)); // Cornflower Blue
        JLabel headerLabel = new JLabel("Job Application Tracker");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Signup");

        centerPanel.add(usernameLabel);
        centerPanel.add(usernameField);
        centerPanel.add(passwordLabel);
        centerPanel.add(passwordField);
        centerPanel.add(loginButton);
        centerPanel.add(signupButton);

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(100, 149, 237)); // Cornflower Blue
        JLabel footerLabel = new JLabel("© 2025 Job Application Tracker");
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);

        // Add panels to frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);

        // Add action listeners
        loginButton.addActionListener(e -> {
            frame.dispose();
            new MainAppFrame();
        });

        signupButton.addActionListener(e -> {
            frame.dispose();
            SignupScreen signupScreen = new SignupScreen();
            signupScreen.showSignupScreen();
        });
    }

    public void showLoginScreen() {
        frame.setVisible(true);
    }
}

// Signup Screen
class SignupScreen {
    private JFrame frame;

    public SignupScreen() {
        frame = new JFrame("Signup - Job Application Tracker");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(72, 61, 139)); // Dark Slate Blue
        JLabel headerLabel = new JLabel("Create an Account");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton createAccountButton = new JButton("Create Account");

        centerPanel.add(nameLabel);
        centerPanel.add(nameField);
        centerPanel.add(usernameLabel);
        centerPanel.add(usernameField);
        centerPanel.add(passwordLabel);
        centerPanel.add(passwordField);
        centerPanel.add(new JLabel()); // Empty placeholder
        centerPanel.add(createAccountButton);

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(72, 61, 139)); // Dark Slate Blue
        JLabel footerLabel = new JLabel("© 2025 Job Application Tracker");
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);

        // Add panels to frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);

        // Add action listener
        createAccountButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Account created successfully!");
            frame.dispose();
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.showLoginScreen();
        });
    }

    public void showSignupScreen() {
        frame.setVisible(true);
    }
}

// Main Application Frame
class MainAppFrame {
    public MainAppFrame() {
        JFrame frame = new JFrame("Job Application Tracker");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel Blue color
        JLabel headerLabel = new JLabel("Job Application Tracker");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 38));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        // Menu Panel (left sidebar)
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(5, 1, 10, 10));
        menuPanel.setBackground(new Color(220, 220, 220)); // Light gray
        menuPanel.setPreferredSize(new Dimension(200, 0));

        JButton dashboardButton = new JButton("Dashboard");
        JButton addApplicationButton = new JButton("Add Application");
        JButton viewApplicationsButton = new JButton("View Applications");
        JButton tasksButton = new JButton("Tasks");
        JButton settingsButton = new JButton("Settings");

        menuPanel.add(dashboardButton);
        menuPanel.add(addApplicationButton);
        menuPanel.add(viewApplicationsButton);
        menuPanel.add(tasksButton);
        menuPanel.add(settingsButton);

        // Main Content Panel
        JPanel mainContentPanel = new JPanel();
        mainContentPanel.setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to Job Application Tracker", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Noto Sans", Font.PLAIN, 30));
        mainContentPanel.add(welcomeLabel, BorderLayout.CENTER);

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(70, 130, 180)); // Steel Blue color
        JLabel footerLabel = new JLabel("© 2025 Job Application Tracker. All Rights Reserved.");
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);

        // Add panels to the frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(mainContentPanel, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);

        // Set frame visibility
        frame.setVisible(true);
    }
}
