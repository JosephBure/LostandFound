package za.ac.cput.lostandfoundchatroom.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

/**
 *
 * @author Khanya Bhixa
 */

public class RoundedButton extends JButton {

    private int radius = 20;

    public RoundedButton(String text) {

        super(text);

        setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16));

        setForeground(Color.WHITE);

        setBackground(
                new Color(22, 150, 150));

        setFocusPainted(false);

        setBorderPainted(false);

        setContentAreaFilled(false);

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics graphics) {

        Graphics2D g =
                (Graphics2D) graphics.create();

        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(getBackground());

        g.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                radius,
                radius);

        g.dispose();

        super.paintComponent(graphics);
    }
}