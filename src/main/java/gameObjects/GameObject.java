package gameObjects;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class GameObject {

    // The game object class.
    //
    // How to make a game object:
    // 1. Make a new class in the gameObjects package
    // 2. extends GameObject
    // 3. insert methods (init, tick, render)
    // 4. code the object
    //
    // Read KeyInput.java to learn how to listen for key events

    protected float x, y, velX, velY;
    protected ID id;

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void keyPressEvent(int key);

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public ID getId() {
        return id;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }
}
