
package za.ac.cput.lostandfound.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class AdminPage extends JFrame implements ActionListener {

    private JLabel lblLogo;
    private JButton btnProfile;
    private JButton btnSettings;
    private JButton btnItemReport;
    private JButton btnItemClaim;
    private JButton btnChatroom;
    private JButton btnLocationMap;
    private JButton btnItemVerification;
    private JButton btnHelpSupport;
    private JTextField txtSearch;
    private JButton btnNotifications;
    private JLabel lblTotalUsersTitle;
    private JLabel lblTotalUsersValue;
    private JLabel lblTotalUsersChange;
    private JLabel lblActiveSessionsTitle;
    private JLabel lblActiveSessionsValue;
    private JLabel lblActiveSessionsChange;

    private JLabel lblTotalContentTitle;
    private JLabel lblTotalContentValue;
    private JLabel lblTotalContentChange;

    private JLabel lblSecurityAlertsTitle;
    private JLabel lblSecurityAlertsValue;
    private JLabel lblSecurityAlertsChange;

    
    private JLabel lblRecentActivity;
    private JTable tblRecentActivity;
    private DefaultTableModel activityTableModel;
    private JLabel lblSystemHealth;
    private JLabel lblApiResponseTime;
    private JProgressBar barApiResponseTime;
    private JLabel lblDatabaseLoad;
    private JProgressBar barDatabaseLoad;
    private JLabel lblMemoryUsage;
    private JProgressBar barMemoryUsage;
    private JLabel lblDiskSpace;
    private JProgressBar barDiskSpace;

    public AdminPage() {
        setTitle("Lost & Found - Admin");
        setSize(950, 650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JPanel sidePanel = new JPanel(new BorderLayout());

        JPanel headingPanel = new JPanel();
        lblLogo = new JLabel("Lost & Found");
        headingPanel.add(lblLogo);

        JPanel buttonsPanel = new JPanel(new GridLayout(8, 1, 5, 5));

        btnProfile = new JButton("Profile");
        btnSettings = new JButton("Settings");
        btnItemReport = new JButton("Item Report");
        btnItemClaim = new JButton("Item Claim");
        btnChatroom = new JButton("Chatroom");
        btnLocationMap = new JButton("Location/Map");
        btnItemVerification = new JButton("Item Verification");
        btnHelpSupport = new JButton("Help & Support");

        JButton[] sideButtons = {btnProfile, btnSettings, btnItemReport, btnItemClaim,
            btnChatroom, btnLocationMap, btnItemVerification, btnHelpSupport};

        for (JButton button : sideButtons) {
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setOpaque(false);
            button.setHorizontalAlignment(SwingConstants.LEFT);
            button.addActionListener(this);
            buttonsPanel.add(button);
        }

        sidePanel.add(headingPanel, BorderLayout.NORTH);
        sidePanel.add(buttonsPanel, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));

        JPanel searchBarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        txtSearch = new JTextField("Search users, content, settings...", 25);
        btnNotifications = new JButton("Notifications");
        btnNotifications.addActionListener(this);
        searchBarPanel.add(txtSearch);
        searchBarPanel.add(btnNotifications);

        JPanel countPanel = new JPanel(new GridLayout(1, 4, 10, 10));

        JPanel totalUsersCard = new JPanel(new GridLayout(3, 1));
        lblTotalUsersTitle = new JLabel("Total Users");
        lblTotalUsersValue = new JLabel("12,543");
        lblTotalUsersChange = new JLabel("+12% vs last month");
        totalUsersCard.add(lblTotalUsersTitle);
        totalUsersCard.add(lblTotalUsersValue);
        totalUsersCard.add(lblTotalUsersChange);

        JPanel activeSessionsCard = new JPanel(new GridLayout(3, 1));
        lblActiveSessionsTitle = new JLabel("Active Sessions");
        lblActiveSessionsValue = new JLabel("3,421");
        lblActiveSessionsChange = new JLabel("+8% vs last month");
        activeSessionsCard.add(lblActiveSessionsTitle);
        activeSessionsCard.add(lblActiveSessionsValue);
        activeSessionsCard.add(lblActiveSessionsChange);

        JPanel totalContentCard = new JPanel(new GridLayout(3, 1));
        lblTotalContentTitle = new JLabel("Total Content");
        lblTotalContentValue = new JLabel("8,932");
        lblTotalContentChange = new JLabel("+24% vs last month");
        totalContentCard.add(lblTotalContentTitle);
        totalContentCard.add(lblTotalContentValue);
        totalContentCard.add(lblTotalContentChange);

        JPanel securityAlertsCard = new JPanel(new GridLayout(3, 1));
        lblSecurityAlertsTitle = new JLabel("Security Alerts");
        lblSecurityAlertsValue = new JLabel("3");
        lblSecurityAlertsChange = new JLabel("-40% vs last month");
        securityAlertsCard.add(lblSecurityAlertsTitle);
        securityAlertsCard.add(lblSecurityAlertsValue);
        securityAlertsCard.add(lblSecurityAlertsChange);

        countPanel.add(totalUsersCard);
        countPanel.add(activeSessionsCard);
        countPanel.add(totalContentCard);
        countPanel.add(securityAlertsCard);

        JPanel southPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        JPanel activityPanel = new JPanel(new BorderLayout(5, 5));
        lblRecentActivity = new JLabel("Recent Activity");

        String[] activityColumns = {"User", "Action", "Time"};
        Object[][] activityData = {
            {"John Smith", "Updated user permissions", "5 min ago"},
            {"Sarah Johnson", "Created new content item", "12 min ago"},
            {"Mike Davis", "Modified system settings", "1 hour ago"},
            {"Emma Wilson", "Deleted 3 user accounts", "2 hours ago"}
        };
        activityTableModel = new DefaultTableModel(activityData, activityColumns);
        tblRecentActivity = new JTable(activityTableModel);

        activityPanel.add(lblRecentActivity, BorderLayout.NORTH);

        JPanel healthPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        lblSystemHealth = new JLabel("System Health");

        lblApiResponseTime = new JLabel("API Response Time: 124ms");
        barApiResponseTime = new JProgressBar(0, 100);
        barApiResponseTime.setValue(60);

        lblDatabaseLoad = new JLabel("Database Load: 43%");
        barDatabaseLoad = new JProgressBar(0, 100);
        barDatabaseLoad.setValue(43);

        lblMemoryUsage = new JLabel("Memory Usage: 67%");
        barMemoryUsage = new JProgressBar(0, 100);
        barMemoryUsage.setValue(67);

        lblDiskSpace = new JLabel("Disk Space: 81%");
        barDiskSpace = new JProgressBar(0, 100);
        barDiskSpace.setValue(81);

        healthPanel.add(lblSystemHealth);
        healthPanel.add(barApiResponseTime);
        healthPanel.add(barDatabaseLoad);
        healthPanel.add(barMemoryUsage);
        healthPanel.add(barDiskSpace);

        southPanel.add(activityPanel);
        southPanel.add(healthPanel);

        centerPanel.add(searchBarPanel, BorderLayout.NORTH);
        centerPanel.add(countPanel, BorderLayout.CENTER);
        centerPanel.add(southPanel, BorderLayout.SOUTH);

        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        this.add(mainPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNotifications) {

            JOptionPane.showMessageDialog(this, "No new notifications.");
        } else if (e.getSource() == btnHelpSupport) {

            JOptionPane.showMessageDialog(this, "Opens Help & Support page - not wired in yet.");
        } else if (e.getSource() == btnProfile) {
            JOptionPane.showMessageDialog(this, "Opens Profile page - not wired in yet.");
        } else if (e.getSource() == btnSettings) {
            JOptionPane.showMessageDialog(this, "Opens Settings page - not wired in yet.");
        } else if (e.getSource() == btnItemReport) {
            JOptionPane.showMessageDialog(this, "Opens Item Report page - not wired in yet.");
        } else if (e.getSource() == btnItemClaim) {
            JOptionPane.showMessageDialog(this, "Opens Item Claim page - not wired in yet.");
        } else if (e.getSource() == btnChatroom) {
            JOptionPane.showMessageDialog(this, "Opens Chatroom page - not wired in yet.");
        } else if (e.getSource() == btnLocationMap) {
            JOptionPane.showMessageDialog(this, "Opens Location/Map page - not wired in yet.");
        } else if (e.getSource() == btnItemVerification) {
            JOptionPane.showMessageDialog(this, "Opens Item Verification page - not wired in yet.");
        }
    }

    public void setGUI() {
        this.setVisible(true);
    }
}
    
 


 

