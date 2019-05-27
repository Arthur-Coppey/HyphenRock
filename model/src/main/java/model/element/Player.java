package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Mobile {
    private static String spritePath = "player.jpg";

    Player() throws IOException {
        super(ImageIO.read(new File(Player.spritePath)));
    }
}
