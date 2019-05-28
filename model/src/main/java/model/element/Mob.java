package model.element;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

public class Mob extends Mobile {
    private static String spritePath = "mob.jpg";

    Mob() throws IOException {
        super(ImageIO.read(new File(Mob.spritePath)));

    }

    public void update(Map map) {
        final int x = this.getX();
        final int y = this.getY();

        if (map.getElementByPosition(x + 1, y) == null) {
            this.setX(x + 1);
        } else if (map.getElementByPosition(x - 1, y) == null) {
            this.setX(x - 1);
        }

    }
}
