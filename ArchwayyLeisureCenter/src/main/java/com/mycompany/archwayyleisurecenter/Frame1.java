/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.archwayyleisurecenter;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author mitas
 */
public class Frame1 implements ActionListener
{
    private JFrame frame; //Vriable to create the frame
    
    
    //Variables for buttons in type JButton 
    private JButton Login;
    private JButton Register;
   
    
    public Frame1()
    {
        drawFrame1();
    }
    
    public void drawFrame1()
    {
        frame = new JFrame("Archway Leisure Center"); //craete the frame window
        frame.setLocation(500,400); //set the location of the frame on the screen 
        frame.setSize(400,300);
        
        JMenuBar menuBar = new JMenuBar(); //Create new empty menu bar
        frame.setJMenuBar(menuBar); //set the menu bar to the frame
        
        //File block 
        JMenu fileMenu = new JMenu("File"); // create the file menu
        menuBar.add(fileMenu); // add the file menu to the menu bar
        
        JMenuItem newFileItem = new JMenuItem("New File"); //create a new item
        newFileItem.addActionListener(this); //add the "new file" item to action listener to provide the comand
        fileMenu.add(newFileItem); // add the "new file" item to the file in menu bar menu
        
        JMenuItem openFileItem = new JMenuItem("Open");
        openFileItem.addActionListener(this);
        fileMenu.add(openFileItem);
        
        menuBar.add(Box.createHorizontalStrut(100)); // add a space between the 2 items in menu bar
        //menuBar.add(Box.createHorizontalGlue()); // add maximum available space between 2 menu items
        
        //Help block
        JMenu helpMenu = new JMenu("Help"); // create the file menu
        menuBar.add(helpMenu); // add the file menu to the menu bar
        
        Container contentPane = frame.getContentPane();//create the spase to be filed with butons and fields
        
        // Content pane with BoxLayout
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
       
         // Welcome Labels
        JLabel welcomeLabel1 = new JLabel("Welcome to");
        welcomeLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel welcomeLabel2 = new JLabel("Archway Leisure Center");
        welcomeLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPane.add(Box.createVerticalStrut(20)); // Spacer
        contentPane.add(welcomeLabel1);
        contentPane.add(Box.createVerticalStrut(10));
        contentPane.add(welcomeLabel2);
        contentPane.add(Box.createVerticalStrut(20));

        // Login Button
        Login = new JButton("Log In");
        Login.setAlignmentX(Component.CENTER_ALIGNMENT);
        Login.addActionListener(this);
        contentPane.add(Login);

        contentPane.add(Box.createVerticalStrut(10));

        // Register Button
        Register = new JButton("Register");
        Register.setAlignmentX(Component.CENTER_ALIGNMENT);
        Register.addActionListener(this);
        contentPane.add(Register);

        contentPane.add(Box.createVerticalStrut(20));
        
       
        
        frame.setVisible(true); 
    }
    
     //Creating action listener method to be able to interact with the program from GUI
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand(); //making action listener to read string commands
        
        if (e.getSource() == Register) {
            new Register();  // Open the registration window
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
            currentFrame.dispose();  // Closes the frame that triggered the event
        }
        
        if (e.getSource() == Login) {
            new LogIn();  // Open the registration window
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
            currentFrame.dispose();  // Closes the frame that triggered the event
        }
 
    }

}
        
