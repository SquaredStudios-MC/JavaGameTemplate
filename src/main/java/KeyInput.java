import gameObjects.GameObject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    // A class for detecting key input.
    // Built into GameObject, only code here if needed.
    //
    // Usage: check if the key is a certain key by using:
    // if (key == KeyEvent.VK_KEYNAME) {}
    // for example:
    // if (key == KeyEvent.VK_W) {}
    //

    private final Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject object :
                handler.objects) {
            object.keyPressEvent(key);
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject object :
                handler.objects) {
            object.keyPressEvent(key);
        }
    }
}
