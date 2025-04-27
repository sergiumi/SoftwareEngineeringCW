package com.mycompany.archwayyleisurecenter;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author mitas
 */

public class Register implements ActionListener {
    private JFrame frame;
    private JTextField fName, lName, email, phone, address, workTel, dobField;
    private JPasswordField password, checkPassword;
    private JButton registerButton;
    private ArrayList<Member> memberList = new ArrayList<>();

    // Constructor to initialize the Registration page
    public Register() {
        drawRegister();
    }

    // Method to design the Registration page
    public void drawRegister() {
        frame = new JFrame("Archway Leisure Center Registration");
        frame.setLocation(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu bar setup
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Content Panel
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // Header Panel with welcome labels
        JPanel headerPanel = new JPanel(new GridLayout(2, 1));
        JLabel welcomeLabel1 = new JLabel("Welcome to", SwingConstants.CENTER);
        JLabel welcomeLabel2 = new JLabel("Archway Leisure Center", SwingConstants.CENTER);
        headerPanel.add(welcomeLabel1);
        headerPanel.add(welcomeLabel2);
        contentPane.add(headerPanel, BorderLayout.NORTH);

        // Center panel with registration form
        JPanel centerPanel = new JPanel(new GridLayout(9, 2, 10, 10));  
        centerPanel.add(new JLabel("First Name:"));
        fName = new JTextField();
        centerPanel.add(fName);

        centerPanel.add(new JLabel("Last Name:"));
        lName = new JTextField();
        centerPanel.add(lName);

        centerPanel.add(new JLabel("Email:"));
        email = new JTextField();
        centerPanel.add(email);

        centerPanel.add(new JLabel("Phone:"));
        phone = new JTextField();
        centerPanel.add(phone);

        centerPanel.add(new JLabel("Address:"));
        address = new JTextField();
        centerPanel.add(address);

        centerPanel.add(new JLabel("Date of Birth (MM/DD/YYYY):"));
        dobField = new JTextField();
        centerPanel.add(dobField);
        
        centerPanel.add(new JLabel("Work Tel:"));
        workTel = new JTextField();
        centerPanel.add(workTel);

        centerPanel.add(new JLabel("Password:"));
        password = new JPasswordField();
        centerPanel.add(password);

        centerPanel.add(new JLabel("Confirm Password:"));
        checkPassword = new JPasswordField();
        centerPanel.add(checkPassword);

        

        contentPane.add(centerPanel, BorderLayout.CENTER);

        // Register Button
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(registerButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(400, 550);  // Adjusted window size for new field
        frame.setVisible(true);
    }

    // Action listener for the Register button
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Register")) {
            // Retrieve the user input from registration form
            String firstName = fName.getText();
            String lastName = lName.getText();
            String userEmail = email.getText();
            String userPhone = phone.getText();
            String userAddress = address.getText();
            String userWorkTel = workTel.getText();
            String userPassword = new String(password.getPassword());
            String confirmPassword = new String(checkPassword.getPassword());
            String dob = dobField.getText();  // Get the Date of Birth input

            // Validation checks
            if (firstName.isEmpty() || lastName.isEmpty() || userEmail.isEmpty() || userPhone.isEmpty() ||
                userAddress.isEmpty() || userPassword.isEmpty() || confirmPassword.isEmpty() || userWorkTel.isEmpty() || dob.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                return;
            }

            // Validate Date of Birth format
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date dateOfBirth = null;
            try {
                dateOfBirth = sdf.parse(dob);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid date of birth (MM/DD/YYYY).");
                return;
            }

            if (!userPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match.");
                return;
            }

            // Create new Member object
            Date dateOfJoining = new Date();  // Date of Joining
            Member newMember = new Member(
                "A" + (memberList.size() + 1),  // Generate unique membership ID
                firstName + " " + lastName,
                false,  // Default to not a team organizer
                "No Team",
                dateOfBirth,  // Set the valid Date of Birth
                userAddress,
                userPhone,
                userWorkTel,
                userEmail,
                dateOfJoining
            );

            // Add the member to the list
            memberList.add(newMember);

            // Proceed to Membership Selection Screen
            showMembershipSelectionScreen(newMember);
        }
    }

    // Show the Membership Selection Screen
    private void showMembershipSelectionScreen(Member member) {
        // Hide the registration frame
        frame.setVisible(false);

        // Create a new frame for Membership Selection
        JFrame selectionFrame = new JFrame("Choose Membership");
        selectionFrame.setLocation(600, 300);
        selectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for membership options
        JPanel selectionPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        JLabel chooseLabel = new JLabel("Select your membership type:", SwingConstants.CENTER);
        selectionPanel.add(chooseLabel);

        // Membership options (Full, Weekend, and Junior)
        JRadioButton fullMembershipButton = new JRadioButton("Full Membership - $300");
        JRadioButton weekendMembershipButton = new JRadioButton("Weekend Membership - $150");
        JRadioButton juniorMembershipButton = new JRadioButton("Junior Membership - $100");
        ButtonGroup group = new ButtonGroup();
        group.add(fullMembershipButton);
        group.add(weekendMembershipButton);
        group.add(juniorMembershipButton);

        selectionPanel.add(fullMembershipButton);
        selectionPanel.add(weekendMembershipButton);
        selectionPanel.add(juniorMembershipButton);

        // Proceed button
        JButton proceedButton = new JButton("Proceed to Payment");
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Determine the selected membership type and show payment screen
                String membershipType = "";
                double fee = 0;
                if (fullMembershipButton.isSelected()) {
                    membershipType = "Full Membership";
                    fee = 300;
                } else if (weekendMembershipButton.isSelected()) {
                    membershipType = "Weekend Membership";
                    fee = 150;
                } else if (juniorMembershipButton.isSelected()) {
                    membershipType = "Junior Membership";
                    fee = 100;
                }

                if (membershipType.isEmpty()) {
                    JOptionPane.showMessageDialog(selectionFrame, "Please select a membership type.");
                    return;
                }

                // Proceed to Payment with selected membership type
                showPaymentScreen(member, membershipType, fee);
            }
        });

        selectionPanel.add(proceedButton);

        // Add the selection panel to the frame and set visibility
        selectionFrame.add(selectionPanel);
        selectionFrame.setSize(400, 300);
        selectionFrame.setVisible(true);
    }

    // Show the Payment Screen with membership fee
    private void showPaymentScreen(Member member, String membershipType, double fee) {
        // Create a new frame for Membership Fee Payment
        JFrame paymentFrame = new JFrame("Membership Fee Payment");
        paymentFrame.setLocation(600, 300);
        paymentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for payment details (all fields in one column)
        JPanel paymentPanel = new JPanel(new GridLayout(6, 2, 10, 10)); // Adjusted for vertical layout

        // Membership Fee
        paymentPanel.add(new JLabel("Membership Fee:"));
        paymentPanel.add(new JLabel(String.valueOf(fee)));

        // Bank Account Name
        paymentPanel.add(new JLabel("Bank Account Name:"));
        JTextField bankAccountNameField = new JTextField();
        paymentPanel.add(bankAccountNameField);

        // Card Number
        paymentPanel.add(new JLabel("Card Number:"));
        JTextField cardNumberField = new JTextField();
        paymentPanel.add(cardNumberField);

        // Expiration Date
        paymentPanel.add(new JLabel("Expiration Date (MM/YY):"));
        JTextField expirationField = new JTextField();
        paymentPanel.add(expirationField);

        // CVV
        paymentPanel.add(new JLabel("CVV:"));
        JTextField cvvField = new JTextField();
        paymentPanel.add(cvvField);

        // Submit button for payment
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCardDetails(member, membershipType, fee, bankAccountNameField, cardNumberField, expirationField, cvvField);
            }
        });

        // Add the submit button at the bottom of the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        paymentFrame.add(paymentPanel, BorderLayout.CENTER);
        paymentFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Set window size and make it visible
        paymentFrame.setSize(400, 300);
        paymentFrame.setVisible(true);
    }

    // Handle the card details after submission
    private void handleCardDetails(Member member, String membershipType, double fee,
                                    JTextField bankAccountNameField, JTextField cardNumberField,
                                    JTextField expirationField, JTextField cvvField) {
        // Retrieve the entered card details
        String bankAccountName = bankAccountNameField.getText();
        String cardNumber = cardNumberField.getText();
        String expirationDate = expirationField.getText();
        String cvv = cvvField.getText();

        // Validation for empty fields and card details
        if (bankAccountName.isEmpty() || cardNumber.isEmpty() || expirationDate.isEmpty() || cvv.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all details.");
            return;
        }

        if (cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            JOptionPane.showMessageDialog(frame, "Card number must be exactly 16 digits.");
            return;
        }

        if (cvv.length() != 3 || !cvv.matches("\\d+")) {
            JOptionPane.showMessageDialog(frame, "CVV must be exactly 3 digits.");
            return;
        }

        // Simulating payment processing
        JOptionPane.showMessageDialog(frame, "Payment processed successfully! Membership activated.");

        // After successful payment, show member details
        JOptionPane.showMessageDialog(frame, "Member Details:\n" + member.displayMemberInfo() + "\nMembership Type: " + membershipType);

        // Close the payment window
        frame.setVisible(true);  // Show the original frame again
    }

}
