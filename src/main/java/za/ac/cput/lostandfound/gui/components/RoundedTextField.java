package za.ac.cput.lostandfoundchatroom.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JTextField;

/**
 *
 * @author Khanya Bhixa
 */

public class RoundedTextField extends JTextField {

    public RoundedTextField() {

        setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16));

        setForeground(Color.BLACK);

        setBackground(
                new Color(235, 235, 235));

        setOpaque(false);

        setBorder(null);

        setMargin(
                new Insets(
                        0,
                        15,
                        0,
                        15));
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
                25,
                25);

        g.dispose();

        super.paintComponent(graphics);
    }
}