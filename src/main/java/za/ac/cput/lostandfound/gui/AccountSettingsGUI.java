package za.ac.cput.lostandfound.gui;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
import za.ac.cput.lostandfound.DAO.AccountSettingsDAO;
import za.ac.cput.lostandfound.domain.AccountSettings;


public class AccountSettingsGUI extends JFrame {

    // Colours
    private final Color SIDEBAR = new Color(33, 156, 160);
    private final Color DARKBLUE = new Color(33, 46, 145);
    private final Color LIGHTGRAY = new Color(245, 245, 245);

    // Main panel
    private JPanel mainPanel;
    private JPanel settingsCard;

    // Text fields
    private JTextField usernameField;
    private JTextField emailField;
    private JTextField phoneField;

    // Buttons
    private JButton saveButton;
    private JButton backButton;

    // Database
    private AccountSettingsDAO accountSettingsDAO;

    // Temporary user ID
    private int userId = 1;

    public AccountSettingsGUI() {

        setTitle("Account Settings - Lost & Found");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1200, 700));
        setLayout(new BorderLayout());

        accountSettingsDAO = new AccountSettingsDAO();

        buildSidebar();
        buildMainPanel();
        loadAccountSettings();

        setVisible(true);
    }

    private void buildSidebar() {

        JPanel sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setPreferredSize(new Dimension(270, 0));
        sidebar.setBackground(SIDEBAR);

        // Logo
        JLabel logoLabel = new JLabel("⬡");
        logoLabel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 70));
        logoLabel.setForeground(DARKBLUE);
        logoLabel.setBounds(90, 25, 100, 80);
        sidebar.add(logoLabel);

        // Lost & Found title
        JLabel titleLabel = new JLabel("<html>Lost &<br>Found</html>");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(65, 95, 180, 80);
        sidebar.add(titleLabel);

        // Menu buttons
        createMenuButton(sidebar, "Profile", 170, false);
        createMenuButton(sidebar, "Settings", 230, true);
        createMenuButton(sidebar, "Item Report", 290, false);
        createMenuButton(sidebar, "Item Claim", 350, false);
        createMenuButton(sidebar, "Chatroom", 410, false);
        createMenuButton(sidebar, "Location/Map", 470, false);
        createMenuButton(sidebar, "Item Verification", 530, false);
        createMenuButton(sidebar, "Help & Support", 590, false);

        add(sidebar, BorderLayout.WEST);
    }

    private void createMenuButton(JPanel sidebar, String text,
                                  int y, boolean selected) {

        JButton button = new JButton(text);

        button.setBounds(25, y, 220, 50);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setForeground(Color.WHITE);

        if (selected) {
            button.setBackground(DARKBLUE);
        } else {
            button.setBackground(SIDEBAR);
        }

        sidebar.add(button);
    }

    private void buildMainPanel() {

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);

        add(mainPanel, BorderLayout.CENTER);

        // Page title
        JLabel title = new JLabel("Account Settings");
        title.setFont(new Font("Segoe UI", Font.BOLD, 50));
        title.setForeground(DARKBLUE);
        title.setBounds(150, 70, 500, 70);
        mainPanel.add(title);

        // Back button
        backButton = new JButton("← Back");
        backButton.setBounds(150, 140, 120, 40);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        backButton.setFocusPainted(false);
        backButton.setBackground(LIGHTGRAY);
        backButton.setBorderPainted(false);

        backButton.addActionListener(e -> dispose());

        mainPanel.add(backButton);

        // Settings card
        settingsCard = new JPanel();
        settingsCard.setLayout(null);
        settingsCard.setBackground(LIGHTGRAY);
        settingsCard.setBounds(150, 200, 750, 400);

        mainPanel.add(settingsCard);

        // Username
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        usernameLabel.setBounds(40, 40, 200, 30);
        settingsCard.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        usernameField.setBounds(300, 35, 380, 40);
        settingsCard.add(usernameField);

        // Email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        emailLabel.setBounds(40, 110, 200, 30);
        settingsCard.add(emailLabel);

        emailField = new JTextField();
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        emailField.setBounds(300, 105, 380, 40);
        settingsCard.add(emailField);

        // Phone
        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        phoneLabel.setBounds(40, 180, 200, 30);
        settingsCard.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        phoneField.setBounds(300, 175, 380, 40);
        settingsCard.add(phoneField);

        // Save button
        saveButton = new JButton("Save Changes");
        saveButton.setBounds(300, 290, 220, 50);
        saveButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        saveButton.setBackground(DARKBLUE);
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setBorderPainted(false);

        saveButton.addActionListener(e -> saveAccountSettings());

        settingsCard.add(saveButton);
    }

    // Load existing information from the database
    private void loadAccountSettings() {

        try {

            AccountSettings settings =
                    accountSettingsDAO.getByUserId(userId);

            if (settings != null) {

                usernameField.setText(settings.getUsername());
                emailField.setText(settings.getEmail());
                phoneField.setText(settings.getPhoneNumber());

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Could not load account settings.\n" + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Save information to the database
    private void saveAccountSettings() {

        String username = usernameField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneField.getText();

        // Check that fields are not empty
        if (username.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all fields.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            AccountSettings existingSettings =
                    accountSettingsDAO.getByUserId(userId);

            if (existingSettings == null) {

                // Add new record
                AccountSettings settings = new AccountSettings();

                settings.setId(1);
                settings.setUserId(userId);
                settings.setUsername(username);
                settings.setEmail(email);
                settings.setPhoneNumber(phoneNumber);

                accountSettingsDAO.add(settings);

                JOptionPane.showMessageDialog(
                        this,
                        "Account settings saved successfully."
                );

            } else {

                // Update existing record
                existingSettings.setUsername(username);
                existingSettings.setEmail(email);
                existingSettings.setPhoneNumber(phoneNumber);

                accountSettingsDAO.update(existingSettings);

                JOptionPane.showMessageDialog(
                        this,
                        "Account settings updated successfully."
                );
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Could not save account settings.\n" + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

}
