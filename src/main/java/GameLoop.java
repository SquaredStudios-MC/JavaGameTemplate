import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameLoop {
    private final Game game;
    private final Handler handler;
    public GameLoop(Game game) {
        this.game = game;
        this.handler = new Handler(game);
    }

    public void render() {
        BufferStrategy bs = this.game.getBufferStrategy();
        if (bs == null) {
            this.game.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        // render background - DO NOT REMOVE OR SCREEN WILL FLASH
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        handler.render(bs.getDrawGraphics());

        g.dispose();
        bs.show();
    }

    public void tick() {
        handler.tick();
    }
}
