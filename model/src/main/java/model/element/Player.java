package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Direction;
import model.Map;

public class Player extends Mobile {
    private static String spritePath = "player.jpg";

    Player(final int x, final int y) throws IOException {
        super(ImageIO.read(new File(Player.spritePath)));
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void die(Map map) throws Exception {
        this.explode(map);
        map.setElementToPosition(null, this.x, this.y);
        map.getElements().remove(map.getElementByPosition(this.x, this.y));
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    private void kill(model.Map map, int x, int y) throws Exception {
        map.setElementToPosition(null, x, y);
        map.getElements().remove(map.getElementByPosition(x, y));
    }

    public void playerUpdate(Direction direction, Map map) throws Exception {
        final int tempX = this.getX();
        final int tempY = this.getY();
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
        if (!map.getElementByPosition(this.getX(), this.getY()).use(direction, map)) {
            super.setX(tempX);
            super.setY(tempY);
        } else {
            this.kill(map, this.getX(), this.getY());
        }
    }

}
