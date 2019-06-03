package model.element;

import java.awt.image.BufferedImage;
import java.io.IOException;

import contract.Direction;
import model.Map;

public abstract class Mobile extends Element {
    protected int   x;
    protected int   y;
    private boolean falling = false;
    
    public Mobile(final BufferedImage Sprite) throws IOException {
        super(Sprite);
    }
    
    public int directionToInt(final Direction direction) {
        return (Direction.valueOf(direction.toString()).ordinal());
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public Direction intToDirection(final int direction) {
        return Direction.values()[direction];
    }
    
    public boolean isFalling() {
        return this.falling;
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
     *            the map on which the element is
     * @throws Exception
     *                   any exception
     */
    public void update(final Map map) throws Exception {
        // TODO Auto-generated method stub

    }
    
    protected int[] directionCoordinate(final int direction) {
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
    
    protected void explode(final Map map) throws Exception {
        int x;
        int y;
        for (int i = 0; i < 9; i++ ) {
            x = ((i % 3) - 2);
            y = (int) Math.floor(i / 3);
            map.setElementToPosition(null, x, y);
            map.getElements().remove(map.getElementByPosition(x, y));
        }
    }
    
    protected Element getEast(final Map map, final int x, final int y) throws Exception {
        return map.getElementByPosition(x + 1, y);
    }
    
    protected Element getInDirection(final Direction direction, final Map map) throws Exception {
        return map.getElementByPosition(
            this.directionCoordinate(this.directionToInt(direction))[0] + this.getX(), this.directionCoordinate(this.directionToInt(direction))[1] + this.getY()
        );
    }
    
    protected Element getSouth(final Map map, final int x, final int y) throws Exception {
        return map.getElementByPosition(x, y + 1);
    }
    
    protected Element getSouthEast(final Map map, final int x, final int y) throws Exception {
        return map.getElementByPosition(x + 1, y - 1);
    }
    
    protected Element getSouthWest(final Map map, final int x, final int y) throws Exception {
        return map.getElementByPosition(x - 1, y - 1);
    }
    
    protected Element getWest(final Map map, final int x, final int y) throws Exception {
        return map.getElementByPosition(x - 1, y);
    }
    
}
