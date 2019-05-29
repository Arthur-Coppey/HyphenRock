package model.element;

import java.awt.image.BufferedImage;
import java.io.IOException;

import contract.Direction;
import model.Map;

public abstract class Element {
    private final static boolean unstable = false;
    private BufferedImage        sprite;

    Element(BufferedImage Sprite) throws IOException {
        this.sprite = Sprite;
    }

    public void die(Map map) throws Exception {

    }

    public BufferedImage getSprite() {
        return this.sprite;
    }

    public boolean isAlive() {
        return false;
    }

    public boolean isUnstable() {
        return Element.unstable;
    }

    public void setSprite(BufferedImage Sprite) {
        this.sprite = Sprite;
    }

    public void update() {

    }

    public boolean use(Direction direction, model.Map map) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

}
