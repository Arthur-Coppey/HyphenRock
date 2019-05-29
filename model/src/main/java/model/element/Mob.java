package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Map;

public class Mob extends Mobile {
    private static String spritePath = "mob.jpg";
    private int           direction;

    Mob(final int x, final int y) throws IOException {
        super(ImageIO.read(new File(Mob.spritePath)));
        this.setDirection(1);
        this.setX(x);
        this.setY(y);
    }

    public void setDirection(final int direction) {
        this.direction = direction;
    }

    @Override
    public void update(final Map map) throws Exception {
        final int x = this.getX();
        final int y = this.getY();
        if (this.getForward(map) != null) {
            if (this.getLeft(map) != null) {
                this.moveForward();
            }
        }
    }

    private int[] directionCoordinate(final int direction) {
        final int[][] tabDirection = {
            {
                -1, 0
            }, {
                0, -1
            }, {
                1, 0
            }, {
                0, 1
            }
        };
        return tabDirection[direction];
    }

    private Element getForward(final Map map) throws Exception {
        return map.getElementByPosition(
            this.directionCoordinate(this.direction)[0] + this.getX(), this.directionCoordinate(this.direction)[1] + this.getY()
        );
    }

    private Element getLeft(final Map map) throws Exception {
        return map.getElementByPosition(
            this.directionCoordinate(this.getRotation(3))[0] + this.getX(), this.directionCoordinate(this.getRotation(3))[1] + this.getY()
        );
    }

    private Element getRight(final Map map) throws Exception {
        return map.getElementByPosition(
            this.directionCoordinate(this.getRotation(1))[0] + this.getX(), this.directionCoordinate(this.getRotation(1))[1] + this.getY()
        );
    }

    private int getRotation(final int way) {
        return (this.direction + way) % 4;
    }

    private void moveForward() {
        this.setX(this.getX() + this.directionCoordinate(this.direction)[0]);
        this.setY(this.getY() + this.directionCoordinate(this.direction)[1]);
    }

}
