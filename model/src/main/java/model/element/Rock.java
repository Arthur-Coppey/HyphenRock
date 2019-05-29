package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Direction;
import model.Map;

public class Rock extends Mobile {

    private static String        spritePath = "rock.jpg";
    private final static boolean unstable   = true;

    Rock() throws IOException {
        super(ImageIO.read(new File(Rock.spritePath)));
    }

    public void update(Map map) throws Exception {
        final int x = this.getX();
        final int y = this.getY();
        final Element elementSouth = this.getSouth(map, x, y);

        if (this.isFalling() && elementSouth.isAlive()) {
            this.setFalling(false);
            elementSouth.die(map);
        }
        if (this.getSouth(map, x, y) == null) {
            this.setY(y + 1);
            this.setFalling(true);
        } else if ((this.getSouth(map, x, y).isUnstable())) {
            if ((this.getWest(map, x, y) == null) && (this.getSouthWest(map, x, y) == null)) {
                this.setX(x - 1);
                this.setFalling(true);
            } else if ((this.getEast(map, x, y) == null) && (this.getSouthEast(map, x, y) == null)) {
                this.setX(x + 1);
                this.setFalling(true);
            } else {
                this.setFalling(false);
            }
        }
    }

    @Override
    public boolean use(Direction direction, Map map) throws Exception {
        final int directionInInt = this.DirectionToInt(direction);
        if ((this.getInDirection(direction, map) == null) && (((directionInInt % 2)) == 1)) {
            this.setX(this.directionCoordinate(directionInInt)[0] + this.getX());
            this.setY(this.directionCoordinate(directionInInt)[1] + this.getX());
            return true;
        } else {
            return false;
        }
    }
}
