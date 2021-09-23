import gameObjects.GameObject;

import java.util.LinkedList;
import java.awt.*;

public class Handler {
    LinkedList<GameObject> objects = new LinkedList<>();

    private Game game;
    public Handler(Game game) {
        this.game = game;
    }

    public void tick() {
        for (int i=0; i < objects.size(); i++) {
            GameObject obj = objects.get(i);
            obj.tick();
        }
    }
    public void render(Graphics g) {
        for (int i=0; i < objects.size(); i++) {
            GameObject obj = objects.get(i);
            obj.render(g);
        }
    }

    public void addObj(GameObject gObj) {
        objects.add(gObj);
    }

    public void remObj(GameObject gObj) {
        objects.remove(gObj);
    }
}
