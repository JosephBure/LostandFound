package za.ac.cput.lostandfound.gui;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
import za.ac.cput.lostandfound.DAO.NotificationsSettingsDAO;
import za.ac.cput.lostandfound.domain.NotificationsSettings;


public class NotificationsSettingsGUI extends JFrame {

    // Colours
    private final Color SIDEBAR = new Color(33, 156, 160);
    private final Color DARKBLUE = new Color(33, 46, 145);
    private final Color LIGHTGRAY = new Color(245, 245, 245);

    // Main panel
    private JPanel mainPanel;
    private JPanel settingsCard;

    // Notification checkboxes
    private JCheckBox reportUpdatesCheckBox;
    private JCheckBox adminAnnouncementsCheckBox;
    private JCheckBox pushNotificationsCheckBox;

    // Buttons
    private JButton saveButton;
    private JButton backButton;

    // Database
    private NotificationsSettingsDAO notificationsSettingsDAO;

    // Temporary user ID
    private int userId = 1;

    public NotificationsSettingsGUI() {

        setTitle("Notifications - Lost & Found");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1200, 700));
        setLayout(new BorderLayout());

        notificationsSettingsDAO =
                new NotificationsSettingsDAO();

        buildSidebar();
        buildMainPanel();
        loadNotificationSettings();

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
        JLabel title = new JLabel("Notifications");
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

        // Report Updates
        JLabel reportLabel = new JLabel("Report Updates");
        reportLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        reportLabel.setBounds(40, 45, 300, 30);
        settingsCard.add(reportLabel);

        reportUpdatesCheckBox = new JCheckBox();
        reportUpdatesCheckBox.setBackground(LIGHTGRAY);
        reportUpdatesCheckBox.setBounds(600, 40, 50, 40);
        settingsCard.add(reportUpdatesCheckBox);

        // Admin Announcements
        JLabel adminLabel = new JLabel("Admin Announcements");
        adminLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        adminLabel.setBounds(40, 125, 300, 30);
        settingsCard.add(adminLabel);

        adminAnnouncementsCheckBox = new JCheckBox();
        adminAnnouncementsCheckBox.setBackground(LIGHTGRAY);
        adminAnnouncementsCheckBox.setBounds(600, 120, 50, 40);
        settingsCard.add(adminAnnouncementsCheckBox);

        // Push Notifications
        JLabel pushLabel = new JLabel("Push Notifications");
        pushLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        pushLabel.setBounds(40, 205, 300, 30);
        settingsCard.add(pushLabel);

        pushNotificationsCheckBox = new JCheckBox();
        pushNotificationsCheckBox.setBackground(LIGHTGRAY);
        pushNotificationsCheckBox.setBounds(600, 200, 50, 40);
        settingsCard.add(pushNotificationsCheckBox);

        // Save button
        saveButton = new JButton("Save Changes");
        saveButton.setBounds(300, 290, 220, 50);
        saveButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        saveButton.setBackground(DARKBLUE);
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setBorderPainted(false);

        saveButton.addActionListener(e -> saveNotificationSettings());

        settingsCard.add(saveButton);
    }

    // Load existing notification settings
    private void loadNotificationSettings() {

        try {

            NotificationsSettings settings =
                    (NotificationsSettings) notificationsSettingsDAO.getByUserId(userId);

            if (settings != null) {

                reportUpdatesCheckBox.setSelected(
                        settings.isReportUpdates()
                );

                adminAnnouncementsCheckBox.setSelected(
                        settings.isAdminAnnouncements()
                );

                pushNotificationsCheckBox.setSelected(
                        settings.isPushNotifications()
                );
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Could not load notification settings.\n"
                    + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Save notification settings
    private void saveNotificationSettings() {

        boolean reportUpdates =
                reportUpdatesCheckBox.isSelected();

        boolean adminAnnouncements =
                adminAnnouncementsCheckBox.isSelected();

        boolean pushNotifications =
                pushNotificationsCheckBox.isSelected();

        try {

            NotificationsSettings existingSettings =
                    (NotificationsSettings) notificationsSettingsDAO.getByUserId(userId);

            if (existingSettings == null) {

                // Create new record
                NotificationsSettings settings =
                        new NotificationsSettings();

                settings.setId(1);
                settings.setUserId(userId);
                settings.setReportUpdates(reportUpdates);
                settings.setAdminAnnouncements(adminAnnouncements);
                settings.setPushNotifications(pushNotifications);

                notificationsSettingsDAO.add(settings);

                JOptionPane.showMessageDialog(
                        this,
                        "Notification settings saved successfully."
                );

            } else {

                // Update existing record
                existingSettings.setReportUpdates(
                        reportUpdates
                );

                existingSettings.setAdminAnnouncements(
                        adminAnnouncements
                );

                existingSettings.setPushNotifications(
                        pushNotifications
                );

                notificationsSettingsDAO.update(existingSettings);

                JOptionPane.showMessageDialog(
                        this,
                        "Notification settings updated successfully."
                );
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Could not save notification settings.\n"
                    + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}