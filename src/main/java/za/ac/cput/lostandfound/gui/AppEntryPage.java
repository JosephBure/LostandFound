/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.lostandfound.gui;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author rjbur
 */
public class AppEntryPage extends JFrame {

    public AppEntryPage() {
        setTitle("Lost & Found - Welcome");
        setSize(420,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        
        add(buildCenterPanel(),BorderLayout.CENTER);
        setVisible(true);
        
    }
    
 
    private JPanel buildCenterPanel() { 
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 30, 30, 30));
 
        JLabel title = new JLabel("Welcome to Lost & Found");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
 
        JLabel tagline = new JLabel("\"Report, Claim and Recover easily.\"");
        tagline.setFont(new Font("SansSerif", Font.ITALIC, 13));
        tagline.setAlignmentX(Component.CENTER_ALIGNMENT);
        tagline.setBorder(BorderFactory.createEmptyBorder(10, 0, 25, 0));
 
        JPanel features = new JPanel(new GridLayout(1, 3, 15, 0));
        features.add(featureLabel("Find Faster"));
        features.add(featureLabel("Report Faster"));
        features.add(featureLabel("Secure"));
        features.setMaximumSize(new Dimension(360, 30));
        features.setAlignmentX(Component.CENTER_ALIGNMENT);
 
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttons.setBorder(BorderFactory.createEmptyBorder(30, 0, 15, 0));
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
 
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Signup");
        signupButton.setBackground(new Color(0, 128, 128));
        signupButton.setForeground(Color.WHITE);
 
        loginButton.addActionListener(e -> openLoginPage());
        signupButton.addActionListener(e -> openSignUpPage());
 
        buttons.add(loginButton);
        buttons.add(signupButton);
 
        JLabel footer = new JLabel("Reuniting people to their belongings");
        footer.setFont(new Font("SansSerif", Font.PLAIN, 11));
        footer.setForeground(new Color(0, 90, 90));
        footer.setAlignmentX(Component.CENTER_ALIGNMENT);
        footer.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
 
        panel.add(title);
        panel.add(tagline);
        panel.add(features);
        panel.add(buttons);
        panel.add(footer);
 
        return panel;
    }
 
    private JLabel featureLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        label.setForeground(new Color(20, 40, 120));
        return label;
    }
 
    private void openLoginPage() {
       
        JOptionPane.showMessageDialog(this, "Login page not wired in yet.");
        
    }
 
    private void openSignUpPage() {
        new SignUpPage();
        dispose();
    }
    
    }

