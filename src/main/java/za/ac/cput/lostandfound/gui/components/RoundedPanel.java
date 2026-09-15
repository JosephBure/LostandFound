package za.ac.cput.lostandfoundchatroom.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 *
 * @author Khanya Bhixa
 */

public class RoundedPanel extends JPanel {

    private int radius = 20;

    public RoundedPanel() {

        setOpaque(false);
    }

    public RoundedPanel(int radius) {

        this.radius = radius;

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
   