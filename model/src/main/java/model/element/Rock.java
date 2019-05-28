package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rock extends Mobile {
    private static String spritePath = "rock.jpg";

    Rock() throws IOException {
        super(ImageIO.read(new File(Rock.spritePath)));
    }

    @Override
    public void update() {
        if (map.getElementByPosition(this.getX(), this.getY() - 1) == null) {
            this.setY(this.getY() - 1);
        } else if (map.getElementByPosition(this.getX(), this.getY() - 1) == (Rock || Diamond)) {
            if (map.getElemementByPosition(this.getX() - 1, this.getY()) == null) {
                if (map.getElementByPosition(this.getX() - 1, this.getY() - 1) == null) {
                    this.setX(this.getX() - 1);
                }
            }
            if (map.getElemementByPosition(this.getX() + 1, this.getY()) == null) {
                if (map.getElementByPosition(this.getX() + 1, this.getY() - 1) == null) {
                    this.setX(this.getX() + 1);
                }
        }
    }
}
