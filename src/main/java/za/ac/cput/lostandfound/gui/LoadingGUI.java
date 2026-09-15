package za.ac.cput.lostandfound.gui;

import javax.swing.*;
import java.awt.*;

public class LoadingGUI extends JFrame {

    // Labels
    private JLabel loadingLabel;
    private JLabel waitLabel;

    // Array to hold the five loading dots
    private JLabel[] dots = new JLabel[5];

    public LoadingGUI() {

        // ===========================
        // FRAME SETTINGS
        // ===========================
        setTitle("Lost & Found");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Allow resizing
        setResizable(true);
        // White background
        getContentPane().setBackground(Color.WHITE);
        // Center everything inside the frame
        setLayout(new GridBagLayout());

        // ===========================
        // MAIN PANEL
        // ===========================
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // ===========================
        // DOTS PANEL
        // ===========================
        JPanel dotsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        dotsPanel.setBackground(Color.WHITE);

        Color[] colours = {
            new Color(220, 220, 255),
            new Color(190, 190, 255),
            new Color(170, 170, 255),
            new Color(140, 140, 255),
            new Color(105, 105, 255)
        };

        for (int i = 0; i < dots.length; i++) {

            dots[i] = new JLabel("●");
            dots[i].setFont(new Font("Segoe UI", Font.PLAIN, 22));
            dots[i].setForeground(colours[i]);

            dotsPanel.add(dots[i]);
        }

        dotsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ===========================
        // LOADING LABEL
        // ===========================
        loadingLabel = new JLabel("Loading");
        loadingLabel.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        loadingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ===========================
        // PLEASE WAIT LABEL
        // ===========================
        waitLabel = new JLabel("Please wait...");
        waitLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        waitLabel.setForeground(Color.GRAY);
        waitLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ===========================
        // ADD COMPONENTS
        // ===========================
        centerPanel.add(dotsPanel);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(loadingLabel);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(waitLabel);

        add(centerPanel);

        setVisible(true);

        // Open SettingsGUI after 3 seconds
        startLoading();
    }

    private void startLoading() {

        Timer timer = new Timer(3000, e -> {

            new SettingPage();
            dispose();

        });

        timer.setRepeats(false);
        timer.start();
    }
}
