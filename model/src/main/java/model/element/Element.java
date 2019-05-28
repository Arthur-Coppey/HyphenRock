package model.element;

import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Element {
    private BufferedImage sprite;

    Element(BufferedImage Sprite) throws IOException {
        this.sprite = Sprite;
    }

    public BufferedImage getSprite() {
        return this.sprite;
    }

    public void setSprite(BufferedImage Sprite) {
        this.sprite = Sprite;
    }

    void update() {

    }

}
