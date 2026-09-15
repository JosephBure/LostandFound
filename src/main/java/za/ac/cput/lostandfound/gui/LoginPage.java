/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.lostandfound.gui;




import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.SwingUtilities;
import za.ac.cput.lostandfound.DAO.UserDAO;
import za.ac.cput.lostandfound.domain.User;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.SwingUtilities;
import za.ac.cput.lostandfound.DAO.UserDAO;
import za.ac.cput.lostandfound.domain.User;


/**
 *
 * @author Khanya Bhixa
 *
 */

public class LoginPage extends JFrame implements ActionListener {

    // Labels
    private JLabel lblTitle;
    private JLabel lblSlogan;
    private JLabel lblWelcome;
    private JLabel lblLoginText;
    private JLabel lblEmail;
    private JLabel lblPassword;
    private JLabel lblOr;
    private JLabel lblAccount;

    // Text fields
    private JTextField txtEmail;
    private JPasswordField txtPassword;

    // Buttons
    private JButton btnLogin;
    private JButton btnForgotPassword;
    private JButton btnMicrosoft;
    private JButton btnOutlook;
    private JButton btnSignUp;
    private JButton btnShowPassword;

    // Panel
    private JPanel panel;

    // Database access
    private UserDAO dao;

    public LoginPage() {

        dao = new UserDAO();

        setTitle("Lost & Found Login");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        // Title
        lblTitle = new JLabel("LOST & FOUND", JLabel.CENTER);
        lblTitle.setBounds(250, 30, 500, 50);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 38));
        lblTitle.setForeground(new Color(29, 45, 145));

        // Slogan
        lblSlogan = new JLabel(
                "Reuniting people to their belongings",
                JLabel.CENTER
        );
        lblSlogan.setBounds(250, 80, 500, 30);
        lblSlogan.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblSlogan.setForeground(new Color(29, 45, 145));

        // Welcome
        lblWelcome = new JLabel("WELCOME BACK!", JLabel.CENTER);
        lblWelcome.setBounds(250, 150, 500, 40);
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 34));
        lblWelcome.setForeground(new Color(29, 45, 145));

        // Login text
        lblLoginText = new JLabel(
                "Login to continue to your account",
                JLabel.CENTER
        );
        lblLoginText.setBounds(250, 195, 500, 30);
        lblLoginText.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblLoginText.setForeground(new Color(29, 45, 145));

        // Email
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(180, 270, 100, 30);
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 18));

        txtEmail = new JTextField();
        txtEmail.setBounds(290, 260, 560, 45);
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        txtEmail.setBackground(new Color(22, 150, 150)); // #169696
        txtEmail.setForeground(Color.WHITE);

        // Password
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(180, 335, 120, 30);
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 18));

        txtPassword = new JPasswordField();
        txtPassword.setBounds(290, 325, 560, 45);
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        txtPassword.setBackground(new Color(22, 150, 150)); // #169696
        txtPassword.setForeground(Color.WHITE);

        // Show password
        btnShowPassword = new JButton("👁");
        btnShowPassword.setBounds(860, 325, 55, 45);
        btnShowPassword.setFocusPainted(false);

        // Forgot password
        btnForgotPassword = new JButton("Forgot Password?");
        btnForgotPassword.setBounds(690, 380, 170, 30);
        btnForgotPassword.setBorderPainted(false);
        btnForgotPassword.setContentAreaFilled(false);
        btnForgotPassword.setFocusPainted(false);
        btnForgotPassword.setForeground(new Color(29, 45, 145));
        btnForgotPassword.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnForgotPassword.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        // Login button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(290, 425, 560, 50);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnLogin.setBackground(new Color(29, 45, 145));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);

        // Or Login With
        // Same font size as Don't have an account?
        // Centered above Microsoft and Outlook
        lblOr = new JLabel("Or Login With", JLabel.CENTER);
        lblOr.setBounds(340, 500, 470, 35);
        lblOr.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblOr.setForeground(Color.GRAY);

        // Microsoft
        btnMicrosoft = new JButton("Microsoft");
        btnMicrosoft.setBounds(340, 555, 200, 50);
        btnMicrosoft.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnMicrosoft.setForeground(Color.GRAY);
        btnMicrosoft.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        // Outlook
        btnOutlook = new JButton("Outlook");
        btnOutlook.setBounds(610, 555, 200, 50);
        btnOutlook.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnOutlook.setForeground(Color.GRAY);
        btnOutlook.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        // Account label
        lblAccount = new JLabel(
                "Don't have an account?",
                JLabel.CENTER
        );
        lblAccount.setBounds(310, 625, 250, 30);
        lblAccount.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblAccount.setForeground(Color.GRAY);

        // Sign Up
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(560, 622, 120, 35);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setContentAreaFilled(false);
        btnSignUp.setFocusPainted(false);
        btnSignUp.setForeground(new Color(29, 45, 145));
        btnSignUp.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnSignUp.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        // Add components
        panel.add(lblTitle);
        panel.add(lblSlogan);
        panel.add(lblWelcome);
        panel.add(lblLoginText);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnShowPassword);
        panel.add(btnForgotPassword);
        panel.add(btnLogin);
        panel.add(lblOr);
        panel.add(btnMicrosoft);
        panel.add(btnOutlook);
        panel.add(lblAccount);
        panel.add(btnSignUp);

        // Actions
        btnLogin.addActionListener(this);
        btnForgotPassword.addActionListener(this);
        btnShowPassword.addActionListener(this);
        btnMicrosoft.addActionListener(this);
        btnOutlook.addActionListener(this);
        btnSignUp.addActionListener(this);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Login
        if (e.getSource() == btnLogin) {

            String email = txtEmail.getText().trim();

            String password =
                    String.valueOf(
                            txtPassword.getPassword()
                    ).trim();

            if (email.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter email and password"
                );

                return;
            }

            User user = new User(email, password);

            if (dao.login(user)) {

                 SwingUtilities.invokeLater(
                MainMenu::new);
                

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid email or password"
                );
            }
        }

        // Show or hide password
        else if (e.getSource() == btnShowPassword) {

            if (txtPassword.getEchoChar() != 0) {

                txtPassword.setEchoChar((char) 0);
                btnShowPassword.setText("🙈");

            } else {

                txtPassword.setEchoChar('•');
                btnShowPassword.setText("👁");
            }
        }

        // Forgot password
        else if (e.getSource() == btnForgotPassword) {

            new ForgotPasswordGUI();
            dispose();
        }

        // Microsoft
        else if (e.getSource() == btnMicrosoft) {

            JOptionPane.showMessageDialog(
                    this,
                    "Microsoft Login coming soon"
            );
        }

        // Outlook
        else if (e.getSource() == btnOutlook) {

            JOptionPane.showMessageDialog(
                    this,
                    "Outlook Login coming soon"
            );
        }

        // Sign Up
        else if (e.getSource() == btnSignUp) {
     SwingUtilities.invokeLater(SignUpPage::new);
            
        }
    }
}