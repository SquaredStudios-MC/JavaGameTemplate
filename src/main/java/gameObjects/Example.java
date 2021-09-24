package gameObjects;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Example extends GameObject {
    // This is not registered inside the game loop meaning
    // that this will not appear in game

    public Example() {
        super(0, 0, ID.Dummy);
    }

    @Override
    public void tick() {
        // What to happen on tick

        // Example: move to the right
        setX(x + 1);
        if (x > 100) {
            setX(0);
        }
    }

    @Override
    public void render(Graphics g) {
        // Rendering the sprite

        // Example: render an orange circle
        g.setColor(Color.ORANGE);
        g.fillRect(((int) x), ((int) y), ((int) x) + 10, ((int) y) + 10);
    }

    @Override
    public void keyPressEvent(int key) {
        // On key press

        // Example: hello world when you press [HOME]
        if (key == KeyEvent.VK_HOME) {
            System.out.println("Hello World!");
        }
    }
}
