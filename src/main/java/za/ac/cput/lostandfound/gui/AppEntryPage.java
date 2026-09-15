/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package za.ac.cput.lostandfound.gui;





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Author: Runyararo Joseph Bure StudentNumber-240377222
 */
public class AppEntryPage extends JFrame implements ActionListener {

    private JLabel lblHeading;
    private JLabel lblTagline;
    private JLabel lblFind;
    private JLabel lblReport;
    private JLabel lblSecure;
    private JLabel lblFooter;
    private JButton btnLogin;
    private JButton btnSignup;
    private JPanel panelFeature,panelButton,panel;

    public AppEntryPage() {
        setTitle("Lost & Found");
        setSize(1200, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(buildEntryPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel buildEntryPanel() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(40, 30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;

        lblHeading = new JLabel("<html>Welcome to <b>Lost &amp; Found</b></html>");
        lblHeading.setFont(new Font("SansSerif", Font.PLAIN, 48));
        lblHeading.setForeground(new Color(26, 35, 126));
        lblHeading.setHorizontalAlignment(SwingConstants.CENTER);

        lblTagline = new JLabel("\"Report, Claim and Recover easily.\"");
        lblTagline.setFont(new Font("SansSerif", Font.BOLD, 26));
        lblTagline.setForeground(new Color(26, 35, 126));
        lblTagline.setHorizontalAlignment(SwingConstants.CENTER);

        panelFeature = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));
        panelFeature.setBackground(Color.WHITE);

        lblFind= new JLabel("Find Faster");
        lblFind.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblFind.setForeground(new Color(26, 35, 126));

        lblReport= new JLabel("Report faster");
        lblReport.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblReport.setForeground(new Color(26, 35, 126));

        lblSecure = new JLabel("Secure");
        lblSecure.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblSecure.setForeground(new Color(26, 35, 126));

        panelFeature.add(lblFind);
        panelFeature.add(lblReport);
        panelFeature.add(lblSecure);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("SansSerif", Font.BOLD, 20));
        btnLogin.setForeground(new Color(0, 137, 137));
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setBorder(BorderFactory.createLineBorder(new Color(0, 137, 137), 2));
        btnLogin.setFocusPainted(false);
        btnLogin.setPreferredSize(new Dimension(180, 60));

        btnSignup = new JButton("Signup");
        btnSignup.setFont(new Font("SansSerif", Font.BOLD, 20));
        btnSignup.setForeground(Color.WHITE);
        btnSignup.setBackground(new Color(0, 137, 137));
        btnSignup.setFocusPainted(false);
        btnSignup.setPreferredSize(new Dimension(180, 60));

        panelButton= new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 0));
        panelButton.setBackground(Color.WHITE);
        panelButton.add(btnLogin);
        panelButton.add(btnSignup);

        lblFooter = new JLabel("Reuniting people to their belongings");
        lblFooter.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblFooter.setForeground(new Color(26, 35, 126));
        lblFooter.setHorizontalAlignment(SwingConstants.CENTER);

        // Add Event Listeners
        btnLogin.addActionListener(this);
        btnSignup.addActionListener(this);

        gbc.insets = new Insets(0, 0, 35, 0);
        panel.add(lblHeading, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 35, 0);
        panel.add(lblTagline, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 50, 0);
        panel.add(panelFeature, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 25, 0);
        panel.add(panelButton, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 0, 0);
        panel.add(lblFooter, gbc);

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

}