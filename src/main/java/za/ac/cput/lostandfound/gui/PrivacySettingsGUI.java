package za.ac.cput.lostandfound.gui;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
import za.ac.cput.lostandfound.DAO.PrivacySettingsDAO;
import za.ac.cput.lostandfound.domain.PrivacySettings;


public class PrivacySettingsGUI extends JFrame {

    // Colours
    private final Color SIDEBAR = new Color(33, 156, 160);
    private final Color DARKBLUE = new Color(33, 46, 145);
    private final Color LIGHTGRAY = new Color(245, 245, 245);

    // Main panel
    private JPanel mainPanel;
    private JPanel settingsCard;

    // Components
    private JComboBox<String> visibilityBox;
    private JCheckBox contactInfoCheckBox;
    private JCheckBox twoFactorCheckBox;

    // Buttons
    private JButton saveButton;
    private JButton backButton;

    // Database
    private PrivacySettingsDAO privacySettingsDAO;

    // Temporary user ID
    private int userId = 1;

    public PrivacySettingsGUI() {

        setTitle("Privacy & Security - Lost & Found");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1200, 700));
        setLayout(new BorderLayout());

        privacySettingsDAO = new PrivacySettingsDAO();

        buildSidebar();
        buildMainPanel();
        loadPrivacySettings();

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
        JLabel title = new JLabel("Privacy & Security");
        title.setFont(new Font("Segoe UI", Font.BOLD, 50));
        title.setForeground(DARKBLUE);
        title.setBounds(150, 70, 600, 70);
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

        // Profile visibility
        JLabel visibilityLabel = new JLabel("Profile Visibility");
        visibilityLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        visibilityLabel.setBounds(40, 45, 250, 30);
        settingsCard.add(visibilityLabel);

        visibilityBox = new JComboBox<>(
                new String[]{"Public", "Private"}
        );

        visibilityBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        visibilityBox.setBounds(300, 40, 300, 40);
        settingsCard.add(visibilityBox);

        // Show contact information
        JLabel contactLabel = new JLabel("Show Contact Information");
        contactLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        contactLabel.setBounds(40, 125, 300, 30);
        settingsCard.add(contactLabel);

        contactInfoCheckBox = new JCheckBox();
        contactInfoCheckBox.setBackground(LIGHTGRAY);
        contactInfoCheckBox.setBounds(300, 120, 50, 40);
        settingsCard.add(contactInfoCheckBox);

        // Two-factor authentication
        JLabel twoFactorLabel = new JLabel("Two-Factor Authentication");
        twoFactorLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        twoFactorLabel.setBounds(40, 205, 300, 30);
        settingsCard.add(twoFactorLabel);

        twoFactorCheckBox = new JCheckBox();
        twoFactorCheckBox.setBackground(LIGHTGRAY);
        twoFactorCheckBox.setBounds(300, 200, 50, 40);
        settingsCard.add(twoFactorCheckBox);

        // Save button
        saveButton = new JButton("Save Changes");
        saveButton.setBounds(300, 290, 220, 50);
        saveButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        saveButton.setBackground(DARKBLUE);
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setBorderPainted(false);

        saveButton.addActionListener(e -> savePrivacySettings());

        settingsCard.add(saveButton);
    }

    // Load existing privacy settings
    private void loadPrivacySettings() {

        try {

            PrivacySettings settings =
                    privacySettingsDAO.getByUserId(userId);

            if (settings != null) {

                visibilityBox.setSelectedItem(
                        settings.getProfileVisibility()
                );

                contactInfoCheckBox.setSelected(
                        settings.isShowContactInfo()
                );

                twoFactorCheckBox.setSelected(
                        settings.isTwoFactorAuth()
                );
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Could not load privacy settings.\n"
                    + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Save privacy settings
    private void savePrivacySettings() {

        String profileVisibility =
                visibilityBox.getSelectedItem().toString();

        boolean showContactInfo =
                contactInfoCheckBox.isSelected();

        boolean twoFactorAuth =
                twoFactorCheckBox.isSelected();

        try {

            PrivacySettings existingSettings =
                    privacySettingsDAO.getByUserId(userId);

            if (existingSettings == null) {

                // Create new record
                PrivacySettings settings =
                        new PrivacySettings();

                settings.setId(1);
                settings.setUserId(userId);
                settings.setProfileVisibility(profileVisibility);
                settings.setShowContactInfo(showContactInfo);
                settings.setTwoFactorAuth(twoFactorAuth);

                privacySettingsDAO.add(settings);

                JOptionPane.showMessageDialog(
                        this,
                        "Privacy settings saved successfully."
                );

            } else {

                // Update existing record
                existingSettings.setProfileVisibility(
                        profileVisibility
                );

                existingSettings.setShowContactInfo(
                        showContactInfo
                );

                existingSettings.setTwoFactorAuth(
                        twoFactorAuth
                );

                privacySettingsDAO.update(existingSettings);

                JOptionPane.showMessageDialog(
                        this,
                        "Privacy settings updated successfully."
                );
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Could not save privacy settings.\n"
                    + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

}