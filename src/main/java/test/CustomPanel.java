package test;

import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Your custom painting code here
        g.setColor(Color.BLUE);
        g.fillRect(50, 50, 100, 100);
    }
}
