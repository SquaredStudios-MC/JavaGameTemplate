import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    // This file just makes a new window for the game.
    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);
        frame.setTitle(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(game);
        game.start();
    }
}
