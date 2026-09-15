package za.ac.cput.lostandfoundchatroom.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Khanya Bhixa
 */
public class ChatBubble extends JPanel {

    private JLabel lblMessage;
    private boolean mine;

    public ChatBubble(
            String message,
            boolean mine) {

        this.mine = mine;

        setOpaque(false);

        setLayout(
                new BorderLayout());

        message =
                message.replace(
                        "<br>",
                        "<br/>");

        lblMessage =
                new JLabel(
                        "<html>"
                        + "<div style='width:260px;'>"
                        + message
                        + "</div>"
                        + "</html>");

        lblMessage.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16));

        lblMessage.setOpaque(false);

        lblMessage.setForeground(
                mine
                        ? Color.WHITE
                        : Color.BLACK);

        lblMessage.setBorder(
                BorderFactory.createEmptyBorder(
                        8,
                        13,
                        8,
                        13));

        add(
                lblMessage,
                BorderLayout.CENTER);

        setAlignmentX(
                mine
                        ? RIGHT_ALIGNMENT
                        : LEFT_ALIGNMENT);

        Dimension size =
                lblMessage.getPreferredSize();

        setPreferredSize(size);

        setMaximumSize(
                new Dimension(
                        size.width,
                        size.height));
    }

    @Override
    protected void paintComponent(
            Graphics g) {

        Graphics2D g2 =
                (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (mine) {

            g2.setColor(
                    new Color(
                            22,
                            150,
                            150));

        } else {

            g2.setColor(
                    new Color(
                            230,
                            230,
                            230));
        }

        g2.fillRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                22,
                22);

        g2.dispose();

        super.paintComponent(g);
    }
}