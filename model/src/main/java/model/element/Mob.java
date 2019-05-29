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

    @Override
    public void die(Map map) throws Exception {
        this.explode(map);
        map.setElementToPosition(null, this.x, this.y);
        map.getElements().remove(map.getElementByPosition(this.x, this.y));
    }

    @Override
    protected void explode(Map map) throws Exception {
        int x;
        int y;
        for (int i = 0; i < 9; i++) {
            x = ((i % 3) - 2);
            y = (int) Math.floor(i / 3);
            map.setElementToPosition(new Diamond(this.getX() + x, this.getY() + y), this.getX() + x, this.getY() + y);
            map.getElements().remove(map.getElementByPosition(x, y));
        }
    }

    private Element getForward(Map map) throws Exception {
        return this.getInDirection(this.IntToDirection(this.direction), map);
    }

    private Element getLeft(Map map) throws Exception {
        return this.getInDirection(this.IntToDirection(this.getRotation(3)), map);
    }

    private Element getRight(Map map) throws Exception {
        return this.getInDirection(this.IntToDirection(this.getRotation(1)), map);
    }

    private int getRotation(final int way) {
        return (this.direction + way) % 4;
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    private void moveForward(Map map) throws Exception {
        int check = 0;
        if (this.getLeft(map) != null) {
            check = 3;
        }
        if (this.getRight(map) != null) {
            check = 1;
        }
        this.setX(this.getX() + this.directionCoordinate(this.direction)[0]);
        this.setY(this.getY() + this.directionCoordinate(this.direction)[1]);
        if ((this.getLeft(map) == null) && (this.getRight(map) == null)) {
            this.setDirection(this.getRotation(check));
        }
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void update(Map map) throws Exception {
        final int x = this.getX();
        final int y = this.getY();
        if (this.getForward(map) != null) {
            this.moveForward(map);
        } else if ((this.getForward(map) != null) && (this.getRight(map) != null) && (this.getLeft(map) == null)) {
            this.setDirection(this.getRotation(3));
        } else {
            this.setDirection(this.getRotation(1));
        }
    }
}
