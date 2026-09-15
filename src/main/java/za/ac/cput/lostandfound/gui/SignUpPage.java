/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.lostandfound.gui;




import za.ac.cput.lostandfound.DAO.UserDAO;
import za.ac.cput.lostandfound.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.regex.Pattern;

public class SignUpPage extends JFrame implements ActionListener, ItemListener {

    private final UserDAO userDAO = new UserDAO();

    private static final Pattern CPUT_EMAIL =
            Pattern.compile("^[\\w.+-]+@(mycput\\.ac\\.za|cput\\.ac\\.za)$", Pattern.CASE_INSENSITIVE);

    private static final Color TEAL = new Color(0, 137, 137);
    private static final Color TEAL_DARK = new Color(0, 110, 110);
    private static final Color NAVY = new Color(26, 35, 126);
    private static final Color BORDER_GREY = new Color(190, 190, 190);
    private static final Color PLACEHOLDER_GREY = new Color(140, 140, 140);

    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JComboBox<String> roleBox;
    private JCheckBox agreeBox;
    private JLabel lblStatus;
    private JButton btnSignUp;
    private JButton btnLoginLink;

    public SignUpPage() {
        setTitle("Lost & Found - Create Account");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(buildSidebar(), BorderLayout.WEST);
        add(buildFormPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel buildSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(TEAL);
        sidebar.setPreferredSize(new Dimension(230, 0));

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(TEAL);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 15));
        headerPanel.setMaximumSize(new Dimension(230, 90));

        JLabel titleLabel = new JLabel("<html>Lost &<br>Found</html>");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        headerPanel.add(titleLabel);

        JSeparator separator = new JSeparator();
        separator.setForeground(TEAL_DARK);
        separator.setMaximumSize(new Dimension(230, 1));

        sidebar.add(headerPanel);
        sidebar.add(separator);
        sidebar.add(Box.createRigidArea(new Dimension(0, 15)));
        sidebar.add(sidebarItem("Profile"));
        sidebar.add(sidebarItem("Settings"));
        sidebar.add(sidebarItem("Item Report"));
        sidebar.add(sidebarItem("Item Claim"));
        sidebar.add(sidebarItem("Chatroom"));
        sidebar.add(sidebarItem("Location/Map"));
        sidebar.add(sidebarItem("Item Verification"));
        sidebar.add(sidebarItem("Help & Support"));
        sidebar.add(Box.createVerticalGlue());

        return sidebar;
    }

    private JLabel sidebarItem(String text) {
        JLabel item = new JLabel(text);
        item.setFont(new Font("SansSerif", Font.PLAIN, 16));
        item.setForeground(Color.WHITE);
        item.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 15));
        item.setAlignmentX(Component.LEFT_ALIGNMENT);
        return item;
    }

    private JPanel buildFormPanel() {
        JPanel outer = new JPanel(new GridBagLayout());
        outer.setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 20, 30));

        JLabel heading = new JLabel("Create Your Account");
        heading.setFont(new Font("SansSerif", Font.PLAIN, 26));
        heading.setForeground(NAVY);
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subheading = new JLabel("<html>Join lost &amp; found platform<b>.</b></html>");
        subheading.setFont(new Font("SansSerif", Font.BOLD, 16));
        subheading.setForeground(NAVY);
        subheading.setAlignmentX(Component.CENTER_ALIGNMENT);
        subheading.setBorder(BorderFactory.createEmptyBorder(5, 0, 30, 0));

        txtName = new PlaceholderTextField("Full name");
        txtEmail = new PlaceholderTextField("Email Address");
        txtPhone = new PlaceholderTextField("Phone Number");
        pfPassword = new PlaceholderPasswordField("Create password");
        pfConfirmPassword = new PlaceholderPasswordField("Confirm password");
        roleBox = new JComboBox<>(new String[]{"Student", "Staff", "Admin"});
        roleBox.setBorder(BorderFactory.createEmptyBorder());

        agreeBox = new JCheckBox();
        JLabel agreeLabel = new JLabel("<html>I agree to the <font color='#1478C8'>Terms of Services</font> and "
                + "<font color='#1478C8'>Privacy Policy</font>.</html>");
        agreeLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));

        lblStatus = new JLabel(" ");
        lblStatus.setForeground(Color.RED);
        lblStatus.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblStatus.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnSignUp.setBackground(TEAL);
        btnSignUp.setForeground(NAVY);
        btnSignUp.setFocusPainted(false);
        btnSignUp.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSignUp.setMaximumSize(new Dimension(400, 42));
        btnSignUp.setPreferredSize(new Dimension(400, 42));

        btnLoginLink = new JButton("<html>Already have an account?<font color='#1478C8'>log in</font>.</html>");
        btnLoginLink.setBorderPainted(false);
        btnLoginLink.setContentAreaFilled(false);
        btnLoginLink.setForeground(NAVY);
        btnLoginLink.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnLoginLink.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLoginLink.setFocusPainted(false);

        // Add Event Listeners
        btnSignUp.addActionListener(this);
        btnLoginLink.addActionListener(this);
        roleBox.addItemListener(this);
        agreeBox.addItemListener(this);

        JPanel agreeRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 0));
        agreeRow.setBackground(Color.WHITE);
        agreeRow.setAlignmentX(Component.CENTER_ALIGNMENT);
        agreeRow.add(agreeBox);
        agreeRow.add(agreeLabel);

        panel.add(heading);
        panel.add(subheading);
        panel.add(roundedField(txtName));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(roundedField(txtEmail));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(roundedField(txtPhone));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(roundedField(pfPassword));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(roundedField(pfConfirmPassword));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(roundedField(roleBox));
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(agreeRow);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblStatus);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(btnSignUp);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnLoginLink);

        outer.add(panel);
        return outer;
    }

 
    private JPanel roundedField(JComponent field) {
        JPanel wrapper = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                g2.setColor(BORDER_GREY);
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        wrapper.setOpaque(false);
        wrapper.setBorder(BorderFactory.createEmptyBorder(6, 14, 6, 14));
        wrapper.setMaximumSize(new Dimension(400, 44));
        wrapper.setPreferredSize(new Dimension(400, 44));
        wrapper.setAlignmentX(Component.CENTER_ALIGNMENT);

        field.setOpaque(false);
        if (field instanceof JTextField) {
            ((JTextField) field).setBorder(BorderFactory.createEmptyBorder());
        }

        wrapper.add(field, BorderLayout.CENTER);
        return wrapper;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnSignUp) {
                handleSignUp();
            } else if (e.getSource() == btnLoginLink) {
                new LoginPage();
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Something went wrong: " + ex.getMessage());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        try {
            if (e.getSource() == roleBox) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Role selection changed - handleSignUp() reads roleBox directly when clicked
                }
            } else if (e.getSource() == agreeBox) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    lblStatus.setForeground(Color.RED);
                    lblStatus.setText(" ");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Something went wrong: " + ex.getMessage());
        }
    }


    private void handleSignUp() {
        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();
        String phoneText = txtPhone.getText().trim();
        String password = new String(pfPassword.getPassword());
        String confirmPassword = new String(pfConfirmPassword.getPassword());
        String role = (String) roleBox.getSelectedItem();

        if (name.isEmpty() || email.isEmpty() || phoneText.isEmpty() || password.isEmpty()) {
            showError("Please fill in all required fields.");
            return;
        }

        if (!CPUT_EMAIL.matcher(email).matches()) {
            showError("Please use a valid CPUT institutional email.");
            return;
        }

        int phone;
        try {
            phone = Integer.parseInt(phoneText);
        } catch (NumberFormatException nfe) {
            showError("Please enter a valid phone number (digits only).");
            return;
        }

        if (!isPasswordStrong(password)) {
            showError("Password must be 15+ characters and include letters, numbers, and a symbol.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showError("Passwords do not match.");
            return;
        }

        if (!agreeBox.isSelected()) {
            showError("You must agree to the Terms of Service and Privacy Policy.");
            return;
        }

        try {
            if (userDAO.isEmailRegistered(email)) {
                showError("An account with this email already exists.");
                return;
            }

            User newUser = new User(0, name, email, password, phone, role);
            int newUserId = userDAO.insertValue(newUser);

            if (newUserId == -1) {
                showError("Could not create account. Please try again.");
                return;
            }

           
            switch (role) {
                case "Admin":
                    userDAO.insertAdminUser(newUserId);
                    break;
                case "Staff":
                    userDAO.insertStaffUser(newUserId);
                    break;
                case "Student":
                default:
                    userDAO.insertStudentUser(newUserId);
                    break;
            }

            lblStatus.setForeground(new Color(0, 120, 0));
            lblStatus.setText("Account created successfully.");

            JOptionPane.showMessageDialog(this,
                    "Welcome, " + name + "! Your account has been created.\nRole: " + role,
                    "Sign Up Successful", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception dbEx) {
            showError("Could not create account: " + dbEx.getMessage());
        }
    }

    /**
     * At least 15 characters, with at least one letter, one digit,
     * and one non-alphanumeric character.
     */
    private boolean isPasswordStrong(String password) {
        if (password.length() < 15) {
            return false;
        }
        boolean hasLetter = password.chars().anyMatch(Character::isLetter);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSymbol = password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
        return hasLetter && hasDigit && hasSymbol;
    }

    private void showError(String message) {
        lblStatus.setForeground(Color.RED);
        lblStatus.setText(message);
    }

   
    private static class PlaceholderTextField extends JTextField {
        private final String placeholder;

        PlaceholderTextField(String placeholder) {
            this.placeholder = placeholder;
            setFont(new Font("SansSerif", Font.PLAIN, 13));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (getText().isEmpty()) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(PLACEHOLDER_GREY);
                g2.setFont(getFont());
                FontMetrics fm = g2.getFontMetrics();
                int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g2.drawString(placeholder, 2, y);
                g2.dispose();
            }
        }
    }

    private static class PlaceholderPasswordField extends JPasswordField {
        private final String placeholder;

        PlaceholderPasswordField(String placeholder) {
            this.placeholder = placeholder;
            setFont(new Font("SansSerif", Font.PLAIN, 13));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (getPassword().length == 0) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(PLACEHOLDER_GREY);
                g2.setFont(getFont());
                FontMetrics fm = g2.getFontMetrics();
                int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g2.drawString(placeholder, 2, y);
                g2.dispose();
            }
        }
    }

}