/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.lostandfound.gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SettingPage extends JFrame {

    // Colours
    private final Color SIDEBAR = new Color(33, 156, 160);
    private final Color DARKBLUE = new Color(33, 46, 145);
    private final Color LIGHTGRAY = new Color(245, 245, 245);

    // Panels
    private JPanel sidebar;
    private JPanel mainPanel;
    private JPanel settingsCard;

    // Sidebar Components
    private JLabel logoLabel;
    private JLabel titleLabel;
    private JLabel homeLabel;
    private JLabel searchLabel;

    private JButton profileButton;
    private JButton settingsButton;
    private JButton reportButton;
    private JButton claimButton;
    private JButton chatroomButton;
    private JButton locationButton;
    private JButton verificationButton;
    private JButton helpButton;

    // Main Components
    private JLabel settingsTitle;
    private JLabel profileIcon;
    private JLabel folderIcon;

    public SettingPage() {

        setTitle("Lost & Found");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1200, 700));
        setLayout(new BorderLayout());

        buildSidebar();
        buildMainPanel();

        setVisible(true);
    }

    private void buildSidebar() {

        sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setPreferredSize(new Dimension(270, 0));
        sidebar.setBackground(SIDEBAR);

        // Logo
        logoLabel = new JLabel("⬡");
        logoLabel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 70));
        logoLabel.setForeground(DARKBLUE);
        logoLabel.setBounds(90, 25, 100, 80);
        sidebar.add(logoLabel);

        // Lost & Found title
        titleLabel = new JLabel("<html>Lost &<br>Found</html>");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(65, 95, 180, 80);
        sidebar.add(titleLabel);

        // Home
        homeLabel = new JLabel("HOME");
        homeLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        homeLabel.setForeground(Color.WHITE);
        homeLabel.setBounds(210, 20, 60, 20);
        sidebar.add(homeLabel);

        // Search
        searchLabel = new JLabel("SEARCH");
        searchLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        searchLabel.setForeground(Color.BLACK);
        searchLabel.setBounds(185, 95, 80, 20);
        sidebar.add(searchLabel);

        // Menu buttons
        profileButton = createMenuButton("Profile", 170, false);
        settingsButton = createMenuButton("Settings", 230, true);
        reportButton = createMenuButton("Item Report", 290, false);
        claimButton = createMenuButton("Item Claim", 350, false);
        chatroomButton = createMenuButton("Chatroom", 410, false);
        locationButton = createMenuButton("Location/Map", 470, false);
        verificationButton = createMenuButton("Item Verification", 530, false);
        helpButton = createMenuButton("Help & Support", 590, false);

        add(sidebar, BorderLayout.WEST);
    }

    private JButton createMenuButton(String text, int y, boolean selected) {

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

        return button;
    }

    private void buildMainPanel() {

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);

        add(mainPanel, BorderLayout.CENTER);

        // Header Icons
        profileIcon = new JLabel("PROFILE");
        profileIcon.setFont(new Font("Segoe UI", Font.BOLD, 13));
        profileIcon.setBounds(930, 25, 70, 20);
        profileIcon.setForeground(DARKBLUE);
        mainPanel.add(profileIcon);

        folderIcon = new JLabel("FOLDER");
        folderIcon.setFont(new Font("Segoe UI", Font.BOLD, 13));
        folderIcon.setBounds(1015, 25, 70, 20);
        folderIcon.setForeground(DARKBLUE);
        mainPanel.add(folderIcon);

        // Settings Title
        settingsTitle = new JLabel("Settings");
        settingsTitle.setFont(new Font("Segoe UI", Font.BOLD, 56));
        settingsTitle.setForeground(DARKBLUE);
        settingsTitle.setBounds(180, 80, 350, 80);
        mainPanel.add(settingsTitle);

        // Settings Card
        settingsCard = new JPanel();
        settingsCard.setLayout(null);
        settingsCard.setBackground(LIGHTGRAY);
        settingsCard.setBounds(180, 180, 700, 300);
        mainPanel.add(settingsCard);

        // Account Settings
        JLabel account = new JLabel("> Account Settings");
        account.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        account.setBounds(30, 35, 350, 35);
        account.setCursor(new Cursor(Cursor.HAND_CURSOR));

        account.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new AccountSettingsGUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                account.setForeground(DARKBLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                account.setForeground(Color.BLACK);
            }
        });

        settingsCard.add(account);

        // Privacy & Security
        JLabel privacy = new JLabel("> Privacy & Security");
        privacy.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        privacy.setBounds(30, 100, 350, 35);
        privacy.setCursor(new Cursor(Cursor.HAND_CURSOR));

        privacy.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new PrivacySettingsGUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                privacy.setForeground(DARKBLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                privacy.setForeground(Color.BLACK);
            }
        });

        settingsCard.add(privacy);

        // Notifications
        JLabel notification = new JLabel("> Notifications");
        notification.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        notification.setBounds(30, 165, 350, 35);
        notification.setCursor(new Cursor(Cursor.HAND_CURSOR));

        notification.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new NotificationsSettingsGUI();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                notification.setForeground(DARKBLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                notification.setForeground(Color.BLACK);
            }
        });

        settingsCard.add(notification);

        // Divider
        JSeparator line = new JSeparator();
        line.setBounds(40, 230, 620, 2);
        settingsCard.add(line);

        // Information
        JLabel info = new JLabel(
                "Select a settings category to manage your preferences."
        );

        info.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        info.setForeground(Color.GRAY);
        info.setBounds(40, 245, 550, 30);
        settingsCard.add(info);
    }

}
