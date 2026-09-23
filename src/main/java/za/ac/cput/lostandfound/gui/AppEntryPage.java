package za.ac.cput.lostandfound.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

/*
 * Author: Runyararo Joseph Bure StudentNumber-240377222
 */
public class AppEntryPage extends JFrame implements ActionListener {

    // Path to the logo inside the resources folder, e.g. src/main/resources/images/logo.png.
    // Update this to match wherever you place the exported Figma logo.
    private static final String LOGO_PATH = "/images/logo.png";

    private JLabel lblLogo;
    private JLabel lblHeading;
    private JLabel lblTagline;
    private JLabel lblFeature1;
    private JLabel lblFeature2;
    private JLabel lblFeature3;
    private JLabel lblFooter;
    private JButton btnLogin;
    private JButton btnSignup;

    public AppEntryPage() {
        setTitle("Lost & Found");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(buildEntryPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel buildEntryPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(60, 30, 30, 30));

        ImageIcon logoIcon = loadLogo();
        lblLogo = new JLabel(logoIcon);
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);

        lblHeading = new JLabel("<html>Welcome to <b>Lost &amp; Found</b></html>");
        lblHeading.setFont(new Font("SansSerif", Font.PLAIN, 24));
        lblHeading.setForeground(new Color(26, 35, 126));
        lblHeading.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblTagline = new JLabel("\"Report, Claim and Recover easily.\"");
        lblTagline.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblTagline.setForeground(new Color(26, 35, 126));
        lblTagline.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel featuresPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));
        featuresPanel.setBackground(Color.WHITE);
        featuresPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblFeature1 = new JLabel("Find Faster");
        lblFeature1.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblFeature1.setForeground(new Color(26, 35, 126));

        lblFeature2 = new JLabel("Report faster");
        lblFeature2.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblFeature2.setForeground(new Color(26, 35, 126));

        lblFeature3 = new JLabel("Secure");
        lblFeature3.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblFeature3.setForeground(new Color(26, 35, 126));

        featuresPanel.add(lblFeature1);
        featuresPanel.add(lblFeature2);
        featuresPanel.add(lblFeature3);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnLogin.setForeground(new Color(0, 137, 137));
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setBorder(BorderFactory.createLineBorder(new Color(0, 137, 137)));
        btnLogin.setFocusPainted(false);
        btnLogin.setPreferredSize(new Dimension(120, 38));

        btnSignup = new JButton("Signup");
        btnSignup.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnSignup.setForeground(Color.WHITE);
        btnSignup.setBackground(new Color(0, 137, 137));
        btnSignup.setFocusPainted(false);
        btnSignup.setPreferredSize(new Dimension(120, 38));

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 0));
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnSignup);

        lblFooter = new JLabel("Reuniting people to their belongings");
        lblFooter.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblFooter.setForeground(new Color(26, 35, 126));
        lblFooter.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add Event Listeners
        btnLogin.addActionListener(this);
        btnSignup.addActionListener(this);

        panel.add(lblLogo);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(lblHeading);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        panel.add(lblTagline);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        panel.add(featuresPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 35)));
        panel.add(buttonsPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(lblFooter);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnLogin) {
                new LoginPage();
                dispose();
            } else if (e.getSource() == btnSignup) {
                new SignUpPage();
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Something went wrong: " + ex.getMessage());
        }
    }

    /**
     * Loads the logo from LOGO_PATH and scales it to 120x120. If the file
     * can't be found on the classpath, this prints exactly what path was
     * tried (so you can see what's wrong) and shows a placeholder square
     * instead of crashing the whole app with a NullPointerException.
     */
    private ImageIcon loadLogo() {
        URL logoUrl = getClass().getResource(LOGO_PATH);

        if (logoUrl == null) {
            System.out.println("LOGO NOT FOUND. Tried classpath path: " + LOGO_PATH);
            System.out.println("Check that this exact path (case-sensitive) exists under your build output.");
            return placeholderLogo();
        }

        ImageIcon rawIcon = new ImageIcon(logoUrl);
        Image scaledImage = rawIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    /**
     * Plain placeholder square shown only if the real logo can't be loaded,
     * so the layout still looks right and the app doesn't crash.
     */
    private ImageIcon placeholderLogo() {
        BufferedImage placeholder = new BufferedImage(120, 120, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = placeholder.createGraphics();
        g2.setColor(new Color(230, 230, 230));
        g2.fillRoundRect(0, 0, 120, 120, 16, 16);
        g2.setColor(new Color(26, 35, 126));
        g2.drawRoundRect(0, 0, 119, 119, 16, 16);
        g2.dispose();
        return new ImageIcon(placeholder);
    }

}
