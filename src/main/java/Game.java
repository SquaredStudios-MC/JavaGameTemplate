import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 700, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private final GameLoop gLoop = new GameLoop(this);

    public Game() {
        new Window(WIDTH, HEIGHT, "Game Title", this);
    }

    public static void main(String[] args) {
        new Game();
    }

    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    public synchronized void stop() {
        if (running) {
            try {
                running = false;
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Failed to join thread");
                System.exit(1);
            }
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0 ;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                gLoop.tick();
                delta--;
            }
            if(running)
                gLoop.render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
}
