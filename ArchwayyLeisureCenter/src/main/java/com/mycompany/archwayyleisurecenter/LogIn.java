package com.mycompany.archwayyleisurecenter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author mitas
 */

public class LogIn implements ActionListener {
    private JFrame frame;  // Main frame of the application
    
    private JTextField email;  // Text field for the email input
    private JPasswordField password;  // Password field for password input
    
    private JButton loginButton;  // Button to submit login credentials
    
    // Constructor to initialize the Login form
    public LogIn() {
        drawLogin();
    }
    
    // Method to design the Login form
    public void drawLogin() {
        frame = new JFrame("Archway Leisure Center - Login");
        frame.setLocation(600, 300);  // Positioning the frame on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ensures the application closes when the window is closed

        // Menu Bar Setup
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // File Menu with Exit Option
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));  // Exit the application
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // Adding Help Menu (not functional yet)
        menuBar.add(Box.createHorizontalStrut(100));  // Adding space between menus
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        // Content pane setup
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());  // Using BorderLayout for the overall structure

        // Header Panel with welcome messages
        JPanel headerPanel = new JPanel(new GridLayout(2, 1));  // GridLayout for two rows
        JLabel welcomeLabel1 = new JLabel("Welcome to", SwingConstants.CENTER);
        JLabel welcomeLabel2 = new JLabel("Archway Leisure Center", SwingConstants.CENTER);
        headerPanel.add(welcomeLabel1);
        headerPanel.add(welcomeLabel2);
        contentPane.add(headerPanel, BorderLayout.NORTH);  // Adding header panel to the north of the frame

        // Center panel with form fields using GridBagLayout
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();  // Creating constraints for layout management
        gbc.insets = new Insets(10, 10, 10, 10);  // Adding space between components

        // Email Label (aligned to the right)
        gbc.gridx = 0;  // Column position
        gbc.gridy = 0;  // Row position
        gbc.anchor = GridBagConstraints.LINE_END;  // Align label to the right
        centerPanel.add(new JLabel("Email:"), gbc);

        // Email Field (aligned to the left)
        gbc.gridx = 1;  // Move to the next column
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;  // Align field to the left
        email = new JTextField(15);  // Text field with a fixed width of 15 columns
        centerPanel.add(email, gbc);  // Adding the email field to the panel

        // Password Label (aligned to the right)
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        centerPanel.add(new JLabel("Password:"), gbc);

        // Password Field (aligned to the left)
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        password = new JPasswordField(15);  // Password field with a fixed width of 15 columns
        centerPanel.add(password, gbc);  // Adding the password field to the panel

        contentPane.add(centerPanel, BorderLayout.CENTER);  // Adding the center panel to the middle of the frame

        // Login Button Setup
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);  // Add action listener to handle login when clicked
        JPanel buttonPanel = new JPanel();  // Panel to hold the button
        buttonPanel.add(loginButton);  // Add the login button to the panel
        contentPane.add(buttonPanel, BorderLayout.SOUTH);  // Adding the button panel to the bottom of the frame

        frame.setSize(400, 250);  // Setting the window size
        frame.setVisible(true);  // Making the window visible
    }

    // Action listener method to handle the login button click
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals("Login")) {
            // Retrieve the entered email and password
            String userEmail = email.getText();
            String userPassword = new String(password.getPassword());
            
            // Simple check for valid login credentials
            if (userEmail.equals("admin@example.com") && userPassword.equals("password123")) {
                // If login is successful, show a success message
                JOptionPane.showMessageDialog(frame, "Login successful!");
            } else {
                // If login fails, show an error message
                JOptionPane.showMessageDialog(frame, "Invalid credentials. Try again.");
            }
        }
    }
}
