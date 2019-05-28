package model.element;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

public class Mob extends Mobile {
    private static String spritePath = "mob.jpg";
    private int           direction;

    Mob() throws IOException {
        super(ImageIO.read(new File(Mob.spritePath)));
        this.setDirection(1);
    }

    private int[] directionCoordinate(int direction) {
        final int[][] tabDirection = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        return tabDirection[direction];
    }

    private Element getForward(Map map) {
        return map.getElementByPosition(this.directionCoordinate(this.direction)[0] + this.getX(),
                this.directionCoordinate(this.direction)[1] + this.getY());
    }

    private Element getLeft(Map map) {
        return map.getElementByPosition(this.directionCoordinate(this.getRotation(3))[0] + this.getX(),
                this.directionCoordinate(this.getRotation(3))[1] + this.getY());
    }

    private Element getRight(Map map) {
        return map.getElementByPosition(this.directionCoordinate(this.getRotation(1))[0] + this.getX(),
                this.directionCoordinate(this.getRotation(1))[1] + this.getY());
    }

    private int getRotation(int way) {
        return (this.direction + way) % 4;
    }

    private void moveForward() {
        this.setX(this.getX() + this.directionCoordinate(this.direction)[0]);
        this.setY(this.getY() + this.directionCoordinate(this.direction)[1]);
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void update(Map map) {
        final int x = this.getX();
        final int y = this.getY();
        if (this.getForward(map) != null) {
            if (this.getLeft(map)) {
                this.moveForward();
            }
        }
    }

}
