import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameLoop {
    // The game loop, nothing too interesting here.

    private final Game game;
    private final Handler handler;
    private final KeyInput keyinput;

    public GameLoop(Game game) {
        this.game = game;
        this.handler = new Handler(game);
        this.keyinput = new KeyInput(handler);
        game.addKeyListener(keyinput);
    }

    public void render() {
        BufferStrategy bs = this.game.getBufferStrategy();
        if (bs == null) {
            this.game.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        // render background - DO NOT REMOVE OR SCREEN WILL FLASH
        g.setColor(Game.BACKGROUND_COLOR);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        handler.render(bs.getDrawGraphics());

        g.dispose();
        bs.show();
    }

    public void tick() {
        handler.tick();
    }
}
