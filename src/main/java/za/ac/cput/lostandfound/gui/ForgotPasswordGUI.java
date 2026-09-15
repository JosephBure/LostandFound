/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package za.ac.cput.lostandfound.gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import za.ac.cput.lostandfound.DAO.UserDAO;



/**
 *
 * @author Khanya Bhixa
 *
 */
public class ForgotPasswordGUI extends JFrame implements ActionListener {

    // Labels
    private JLabel lblTitle;
    private JLabel lblEmail;
    private JLabel lblNewPassword;
    private JLabel lblConfirmPassword;

    // Text Fields
    private JTextField txtEmail;
    private JPasswordField txtNewPassword;
    private JPasswordField txtConfirmPassword;

    // Buttons
    private JButton btnUpdate;
    private JButton btnBack;

    // Panel
    private JPanel panel;

    // DAO
    private UserDAO dao;

    // Constructor
    public ForgotPasswordGUI() {

        // Create DAO object
        dao = new UserDAO();

        // Window settings
        setTitle("Forgot Password");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Create panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        // Title
        lblTitle = new JLabel("RESET PASSWORD");
        lblTitle.setBounds(150, 30, 320, 40);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(new Color(29, 45, 145));

        // Email Label
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(60, 100, 150, 30);
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 18));

        // Email TextField
        txtEmail = new JTextField();
        txtEmail.setBounds(220, 100, 280, 35);
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        // New Password Label
        lblNewPassword = new JLabel("New Password");
        lblNewPassword.setBounds(60, 160, 150, 30);
        lblNewPassword.setFont(new Font("Segoe UI", Font.BOLD, 18));

        // New Password Field
        txtNewPassword = new JPasswordField();
        txtNewPassword.setBounds(220, 160, 280, 35);
        txtNewPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        // Confirm Password Label
        lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setBounds(60, 220, 170, 30);
        lblConfirmPassword.setFont(new Font("Segoe UI", Font.BOLD, 18));

        // Confirm Password Field
        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setBounds(220, 220, 280, 35);
        txtConfirmPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        // Update Button
        btnUpdate = new JButton("Update Password");
        btnUpdate.setBounds(180, 290, 220, 40);
        btnUpdate.setBackground(new Color(29, 45, 145));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 16));

        // Back Button
        btnBack = new JButton("Back");
        btnBack.setBounds(240, 350, 100, 35);

        // Add Components
        panel.add(lblTitle);
        panel.add(lblEmail);
        panel.add(txtEmail);

        panel.add(lblNewPassword);
        panel.add(txtNewPassword);

        panel.add(lblConfirmPassword);
        panel.add(txtConfirmPassword);

        panel.add(btnUpdate);
        panel.add(btnBack);

        // Register Action Listeners
        btnUpdate.addActionListener(this);
        btnBack.addActionListener(this);

        // Add Panel to Frame
        add(panel);

        // Display GUI
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Update Password Button
        if (e.getSource() == btnUpdate) {

            String email = txtEmail.getText().trim();
            String password = String.valueOf(txtNewPassword.getPassword()).trim();
            String confirm = String.valueOf(txtConfirmPassword.getPassword()).trim();

            // Check for empty fields
            if (email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please complete all fields.");

                return;
            }

            // Check if passwords match
            if (!password.equals(confirm)) {

                JOptionPane.showMessageDialog(this,
                        "Passwords do not match.");

                return;
            }

            // Check if email exists
            if (!dao.userExists(email)) {

                JOptionPane.showMessageDialog(this,
                        "Email not found.");

                return;
            }

            // Update password in database
            boolean updated = dao.updatePassword(email, password);

            if (updated) {

                JOptionPane.showMessageDialog(this,
                        "Password updated successfully.");

                new LoginPage();
                dispose();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Password could not be updated.");
            }

        }

        // Back Button
        else if (e.getSource() == btnBack) {

            new LoginPage();
            dispose();

        }

    }

}
