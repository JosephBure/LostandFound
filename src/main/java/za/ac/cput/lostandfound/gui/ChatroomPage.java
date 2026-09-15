/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.lostandfound.gui;

import za.ac.cput.lostandfoundchatroom.components.ChatBubble;
import za.ac.cput.lostandfoundchatroom.components.RoundedButton;
import za.ac.cput.lostandfoundchatroom.components.RoundedTextField;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import za.ac.cput.lostandfound.dao.MessageDAO;
import za.ac.cput.lostandfound.domain.Message;



/**
 *
 * @author Khanya Bhixa
 */
public class ChatroomPage extends JFrame {

    private static final String CURRENT_USER =
            "Khanya Bhixa";

    private static final String OTHER_USER =
            "Lisa Booi";

    private static final Color TEAL =
            new Color(
                    22,
                    150,
                    150);

    private static final Color DARK_BLUE =
            new Color(
                    15,
                    34,
                    130);

    private JPanel messagePanel;
    private JScrollPane scrollPane;
    private RoundedTextField txtMessage;
    private MessageDAO messageDAO;
    private int lastMessageCount = -1;
    private Timer refreshTimer;

    public ChatroomPage() {

        messageDAO =
                new MessageDAO();

        setTitle(
                "Lost & Found ChatRoom");

        setSize(
                900,
                700);

        setMinimumSize(
                new Dimension(
                        850,
                        600));

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);

        createGUI();

        loadMessages(false);

        startRefresh();

        setVisible(true);
    }

    private void createGUI() {

        setLayout(
                new BorderLayout());

        add(
                createHeader(),
                BorderLayout.NORTH);

        add(
                createChatArea(),
                BorderLayout.CENTER);

        add(
                createMessageInput(),
                BorderLayout.SOUTH);
    }

    private JPanel createHeader() {

        JPanel header =
                new JPanel(
                        new BorderLayout());

        header.setBackground(
                TEAL);

        header.setPreferredSize(
                new Dimension(
                        900,
                        90));

        JPanel left =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                0,
                                0));

        left.setOpaque(false);

        left.setPreferredSize(
                new Dimension(
                        450,
                        90));

        JLabel back =
                new JLabel("<");

        back.setForeground(
                Color.WHITE);

        back.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        42));

        back.setHorizontalAlignment(
                SwingConstants.CENTER);

        back.setPreferredSize(
                new Dimension(
                        55,
                        90));

        left.add(back);

        JPanel user =
                new JPanel();

        user.setOpaque(false);

        user.setLayout(
                new BoxLayout(
                        user,
                        BoxLayout.Y_AXIS));

        JLabel name =
                new JLabel(
                        "Lisa Booi");

        name.setForeground(
                Color.WHITE);

        name.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        27));

        JLabel online =
                new JLabel(
                        "<html>"
                        + "<span style='color:#20C878;'>●</span>"
                        + "&nbsp;"
                        + "<span style='color:white;'>Online</span>"
                        + "</html>");

        online.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15));

        user.add(name);
        user.add(online);

        left.add(user);

        header.add(
                left,
                BorderLayout.WEST);

        JLabel menu =
        new JLabel("⋮");

menu.setForeground(
        Color.WHITE);

menu.setFont(
        new Font(
                "Segoe UI Symbol",
                Font.PLAIN,
                30));

        menu.setHorizontalAlignment(
                SwingConstants.CENTER);

        menu.setPreferredSize(
                new Dimension(
                        60,
                        90));

        header.add(
                menu,
                BorderLayout.EAST);

        return header;
    }

    private JPanel createChatArea() {

        JPanel main =
                new JPanel(
                        new BorderLayout());

        main.setBackground(
                Color.WHITE);

        JPanel post =
                new JPanel(
                        new BorderLayout());

        post.setBackground(
                DARK_BLUE);

        post.setPreferredSize(
                new Dimension(
                        900,
                        85));

        JLabel phone =
                new JLabel("▯");

        phone.setForeground(
                Color.WHITE);

        phone.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        48));

        phone.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        30,
                        0,
                        15));

        post.add(
                phone,
                BorderLayout.WEST);

        JPanel details =
                new JPanel();

        details.setOpaque(false);

        details.setLayout(
                new BoxLayout(
                        details,
                        BoxLayout.Y_AXIS));

        JLabel title =
                new JLabel(
                        "Lost Phone");

        title.setForeground(
                Color.WHITE);

        title.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        18));

        JLabel item =
                new JLabel(
                        "iPhone 12 Black");

        item.setForeground(
                Color.WHITE);

        item.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        17));

        JLabel location =
                new JLabel(
                        "Posted near library");

        location.setForeground(
                Color.WHITE);

        location.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14));

        details.add(title);
        details.add(item);
        details.add(location);

        post.add(
                details,
                BorderLayout.CENTER);

        RoundedButton viewPost =
                new RoundedButton(
                        "(!)  View Post");

        viewPost.setPreferredSize(
                new Dimension(
                        175,
                        48));

        JPanel viewPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                20,
                                18));

        viewPanel.setOpaque(false);

        viewPanel.add(viewPost);

        post.add(
                viewPanel,
                BorderLayout.EAST);

        main.add(
                post,
                BorderLayout.NORTH);

        messagePanel =
                new JPanel();

        messagePanel.setBackground(
                Color.WHITE);

        messagePanel.setLayout(
                new BoxLayout(
                        messagePanel,
                        BoxLayout.Y_AXIS));

        messagePanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        18,
                        10,
                        18));

        scrollPane =
                new JScrollPane(
                        messagePanel);

        scrollPane.setBorder(null);

        scrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants
                        .HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.setVerticalScrollBarPolicy(
                ScrollPaneConstants
                        .VERTICAL_SCROLLBAR_AS_NEEDED);

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        main.add(
                scrollPane,
                BorderLayout.CENTER);

        return main;
    }

    private JPanel createMessageInput() {

        JPanel input =
                new JPanel(
                        new BorderLayout(
                                10,
                                10));

        input.setBackground(
                new Color(
                        245,
                        245,
                        245));

        input.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        15,
                        10,
                        15));

        txtMessage =
                new RoundedTextField();

        txtMessage.setPreferredSize(
                new Dimension(
                        0,
                        48));

        RoundedButton send =
                new RoundedButton(
                        "Send");

        send.setPreferredSize(
                new Dimension(
                        100,
                        48));

        send.addActionListener(
                e -> sendMessage());

        txtMessage.addActionListener(
                e -> sendMessage());

        input.add(
                txtMessage,
                BorderLayout.CENTER);

        input.add(
                send,
                BorderLayout.EAST);

        return input;
    }

    private void sendMessage() {

        String text =
                txtMessage.getText()
                        .trim();

        if (text.isEmpty()) {
            return;
        }

        Message message =
                new Message(
                        CURRENT_USER,
                        OTHER_USER,
                        text);

        if (messageDAO.addMessage(
                message)) {

            txtMessage.setText("");

            loadMessages(true);

            txtMessage.requestFocus();
        }
    }

    private void loadMessages(
            boolean scrollToBottom) {

        List<Message> messages =
                messageDAO.getConversation(
                        CURRENT_USER,
                        OTHER_USER);

        if (!scrollToBottom
                && messages.size()
                == lastMessageCount) {

            return;
        }

        messagePanel.removeAll();

        JLabel today =
                new JLabel(
                        "Today");

        today.setForeground(
                new Color(
                        120,
                        120,
                        120));

        today.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14));

        JPanel todayPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                0,
                                0));

        todayPanel.setOpaque(false);

        todayPanel.add(today);

        messagePanel.add(
                todayPanel);

        messagePanel.add(
                Box.createVerticalStrut(5));

        for (Message message : messages) {

            boolean mine =
                    CURRENT_USER.equals(
                            message.getSender());

            JPanel row =
                    new JPanel(
                            new BorderLayout());

            row.setOpaque(false);

            ChatBubble bubble =
                    new ChatBubble(
                            message.getMessage(),
                            mine);

            if (mine) {

                row.add(
                        bubble,
                        BorderLayout.EAST);

            } else {

                row.add(
                        bubble,
                        BorderLayout.WEST);
            }

            messagePanel.add(row);

            messagePanel.add(
                    Box.createVerticalStrut(0));
        }

        lastMessageCount =
                messages.size();

        messagePanel.revalidate();
        messagePanel.repaint();

        if (scrollToBottom) {

            SwingUtilities.invokeLater(
                    this::scrollToBottom);
        }
    }

    private void scrollToBottom() {

        scrollPane
                .getVerticalScrollBar()
                .setValue(
                        scrollPane
                                .getVerticalScrollBar()
                                .getMaximum());
    }

    private void startRefresh() {

        refreshTimer =
                new Timer(
                        1000,
                        e -> loadMessages(false));

        refreshTimer.start();

        addWindowListener(
                new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(
                            java.awt.event.WindowEvent e) {
                        refreshTimer.stop();
                    }
                });
    }

}