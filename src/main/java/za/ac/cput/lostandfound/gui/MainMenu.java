
package za.ac.cput.lostandfound.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Sinesipho bosch
 */
public class MainMenu extends JFrame implements ActionListener {

    private JLabel lblLogo;
    private JButton btnProfile;
    private JButton btnSettings;
    private JButton btnItemReport;
    private JButton btnItemClaim;
    private JButton btnChatroom;
    private JButton btnLocationMap;
    private JButton btnItemVerification;
    private JButton btnHelpSupport;
    private final Color TEAL = new Color(23, 143, 143);        
    private final Color TEAL_DARK = new Color(15, 110, 110);   
    private final Color TEAL_CARD = new Color(58, 128, 128);    
    private final Color NAVY = new Color(15, 27, 61);           
    private final Color BG_GREY = new Color(245, 246, 248);     
    private final Color TEXT_GREY = new Color(90, 90, 90);

    private JLabel lblTopBarTitle;

    private JLabel lblSubtitle;

    private JButton btnLostItem;
    private JButton btnReportFoundItem;
    private JButton btnSearchItems;
    private JButton btnMyReports;
    private JButton btnCategories;
    private JButton btnHelpSupportCard;

    public MainMenu() {
        setTitle("Lost & Found - Main Menu");
        setSize(950, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout(0, 0));
        mainPanel.setBackground(BG_GREY);

        JPanel sidePanel = new JPanel(new BorderLayout());
        sidePanel.setBackground(TEAL);
        sidePanel.setPreferredSize(new Dimension(190, 0));

        JPanel headingPanel = new JPanel(new BorderLayout());
        headingPanel.setBackground(TEAL_DARK);
        headingPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        lblLogo = new JLabel("Lost & Found");
        lblLogo.setForeground(Color.WHITE);
        lblLogo.setFont(new Font("SansSerif", Font.BOLD, 16));
        headingPanel.add(lblLogo, BorderLayout.WEST);

        JPanel buttonsPanel = new JPanel(new GridLayout(8, 1, 5, 8));
        buttonsPanel.setBackground(TEAL);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

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
            button.setForeground(Color.WHITE);
            button.setFont(new Font("SansSerif", Font.PLAIN, 14));
            button.addActionListener(this);
            buttonsPanel.add(button);
        }

        sidePanel.add(headingPanel, BorderLayout.NORTH);
        sidePanel.add(buttonsPanel, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel(new BorderLayout(0, 0));
        centerPanel.setBackground(BG_GREY);

        JPanel topBarPanel = new JPanel(new BorderLayout());
        topBarPanel.setBackground(NAVY);
        topBarPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        lblTopBarTitle = new JLabel("Lost & Found");
        lblTopBarTitle.setForeground(Color.WHITE);
        lblTopBarTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        topBarPanel.add(lblTopBarTitle, BorderLayout.WEST);

        JLabel lblHomeIcon = new JLabel("\u2302"); 
        lblHomeIcon.setForeground(Color.WHITE);
        lblHomeIcon.setFont(new Font("SansSerif", Font.BOLD, 18));
        topBarPanel.add(lblHomeIcon, BorderLayout.EAST);

        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBackground(BG_GREY);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        subtitlePanel.setBackground(BG_GREY);
        lblSubtitle = new JLabel("All lost and found items and their belongings");
        lblSubtitle.setForeground(TEXT_GREY);
        lblSubtitle.setFont(new Font("SansSerif", Font.PLAIN, 13));
        subtitlePanel.add(lblSubtitle);

        JPanel cardsPanel = new JPanel(new GridLayout(2, 3, 15, 15));
        cardsPanel.setBackground(BG_GREY);
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        btnLostItem = buildCardButton("\u25A3", "Lost Item", "Fill in the form for an item you lost");
        btnReportFoundItem = buildCardButton("\u25A4", "Report Found Item", "Submit a report for an item you found");
        btnSearchItems = buildCardButton("\u26B2", "Search Items", "Browse and search lost and found items");
        btnMyReports = buildCardButton("\u2637", "My Reports", "View all your submitted reports");
        btnCategories = buildCardButton("\u2637", "Categories", "Browse items by category");
        btnHelpSupportCard = buildCardButton("?", "Help & Support", "Get help and contact support");

        JButton[] cardButtons = {btnLostItem, btnReportFoundItem, btnSearchItems,
            btnMyReports, btnCategories, btnHelpSupportCard};

        for (JButton button : cardButtons) {
            button.addActionListener(this);
            cardsPanel.add(button);
        }

        contentPanel.add(subtitlePanel, BorderLayout.NORTH);
        contentPanel.add(cardsPanel, BorderLayout.CENTER);

        centerPanel.add(topBarPanel, BorderLayout.NORTH);
        centerPanel.add(contentPanel, BorderLayout.CENTER);

        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        this.add(mainPanel, BorderLayout.CENTER);
        this.getContentPane().setBackground(BG_GREY);
    }

    private JButton buildCardButton(String icon, String title, String subtitle) {
        String html = "<html><div style='text-align:center;'>"
                + "<span style='font-size:20px;'>" + icon + "</span><br/><br/>"
                + "<b>" + title + "</b><br/>"
                + "<span style='font-size:10px;'>" + subtitle + "</span>"
                + "</div></html>";
        JButton button = new JButton(html);
        button.setBackground(TEAL_CARD);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setFont(new Font("SansSerif", Font.PLAIN, 12));
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLostItem) {

            JOptionPane.showMessageDialog(this, "Opens Item Report page (Lost) - not wired in yet.");
        } else if (e.getSource() == btnReportFoundItem) {

            JOptionPane.showMessageDialog(this, "Opens Item Report page (Found) - not wired in yet.");
        } else if (e.getSource() == btnSearchItems) {

            JOptionPane.showMessageDialog(this, "Opens Search page - not wired in yet.");
        } else if (e.getSource() == btnMyReports) {
            JOptionPane.showMessageDialog(this, "Opens My Reports view - not wired in yet.");
        } else if (e.getSource() == btnCategories) {
            JOptionPane.showMessageDialog(this, "Opens Categories view - not wired in yet.");
        } else if (e.getSource() == btnHelpSupportCard) {
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
        } else if (e.getSource() == btnHelpSupport) {
            JOptionPane.showMessageDialog(this, "Opens Help & Support page - not wired in yet.");
        }
    }

    public void setGUI() {
        this.setVisible(true);
    }
}
 
   
 

