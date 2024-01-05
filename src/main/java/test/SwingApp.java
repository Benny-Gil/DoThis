package test;
import javax.swing.*;

public class SwingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Painting Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Use the custom panel
            frame.getContentPane().add(new CustomPanel());

            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}
