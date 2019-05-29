package model.element;

import java.awt.image.BufferedImage;
import java.io.IOException;

import model.Map;

public abstract class Mobile extends Element {
    private boolean falling = false;
    private int     x;
    private int     y;

    public Mobile(final BufferedImage Sprite) throws IOException {
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

    public void setFalling(final boolean i) {
        this.falling = i;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public void setY(final int y) {
        this.y = y;
    }

    /**
     * @param map
     * @throws Exception
     */
    public void update(final Map map) throws Exception {
        // TODO Auto-generated method stub
        
    }

}
