package model.element;

import java.awt.image.BufferedImage;
import java.io.IOException;

import contract.Direction;
import model.Map;

public abstract class Mobile extends Element {
    protected int   x;
    protected int   y;
    private boolean falling = false;

    public Mobile(BufferedImage Sprite) throws IOException {
        super(Sprite);
    }

    protected int[] directionCoordinate(int direction) {
        final int[][] tabDirection = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        return tabDirection[direction];
    }

    public int DirectionToInt(Direction direction) {
        return (Direction.valueOf(direction.toString()).ordinal());
    }

    protected void explode(Map map) throws Exception {
        int x;
        int y;
        for (int i = 0; i < 9; i++) {
            x = ((i % 3) - 2);
            y = (int) Math.floor(i / 3);
            map.setElementToPosition(null, x, y);
            map.getElements().remove(map.getElementByPosition(x, y));
        }
    }

    protected Element getEast(Map map, int x, int y) throws Exception {
        return map.getElementByPosition(x + 1, y);
    }

    protected Element getInDirection(Direction direction, Map map) throws Exception {
        return map.getElementByPosition(this.directionCoordinate(this.DirectionToInt(direction))[0] + this.getX(),
                this.directionCoordinate(this.DirectionToInt(direction))[1] + this.getY());
    }

    protected Element getSouth(Map map, int x, int y) throws Exception {
        return map.getElementByPosition(x, y + 1);
    }

    protected Element getSouthEast(Map map, int x, int y) throws Exception {
        return map.getElementByPosition(x + 1, y - 1);
    }

    protected Element getSouthWest(Map map, int x, int y) throws Exception {
        return map.getElementByPosition(x - 1, y - 1);
    }

    protected Element getWest(Map map, int x, int y) throws Exception {
        return map.getElementByPosition(x - 1, y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction IntToDirection(int direction) {
        return Direction.values()[direction];
    }

    public boolean isFalling() {
        return this.falling;
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
