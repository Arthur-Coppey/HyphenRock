package model.element;

import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Mobile extends Element {
    private int     x;
    private int     y;
    private boolean falling = false;

    public Mobile(BufferedImage Sprite) throws IOException {
        super(Sprite);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isFalling() {
        return this.falling;
    }

    public void kill() {
        map.setElementToPosition(null, this.x, this.y);
        map.getElements.remove(this);
    }

    public void setFalling(boolean i) {
        this.falling = i;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
