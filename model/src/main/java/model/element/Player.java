package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Direction;

public class Player extends Mobile {
    private static String spritePath = "player.jpg";

    Player() throws IOException {
        super(ImageIO.read(new File(Player.spritePath)));
    }

    public void update(Direction direction) {
        switch (direction) {
        case UP:
            super.setY(super.getY() - 1);
            break;
        case DOWN:
            super.setY(super.getY() + 1);
            break;
        case RIGHT:
            super.setX(super.getX() + 1);
            break;
        case LEFT:
            super.setX(super.getX() - 1);
            break;
        default:
            break;
        }
    }
}
