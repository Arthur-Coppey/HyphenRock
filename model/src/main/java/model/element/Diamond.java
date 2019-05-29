package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Direction;
import model.Map;

public class Diamond extends Mobile {
    private static String        spritePath = "diamond.jpg";
    private final static boolean unstable   = true;

    Diamond(final int x, final int y) throws IOException {
        super(ImageIO.read(new File(Diamond.spritePath)));
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void update(final Map map) throws Exception {
        final int x = this.getX();
        final int y = this.getY();
        if (map.getElementByPosition(x, y - 1) == null) {
            this.setY(y - 1);
            this.setFalling(true);
        }
        else if ((map.getElementByPosition(x, y - 1).isUnstable())) {
            if ((map.getElementByPosition(x - 1, y) == null) && (map.getElementByPosition(x - 1, y - 1) == null)) {
                this.setX(x - 1);
                this.setFalling(true);
            }
            else if ((map.getElementByPosition(x + 1, y) == null) && (map.getElementByPosition(x + 1, y - 1) == null)) {
                this.setX(x + 1);
                this.setFalling(true);
            }
            else {
                this.setFalling(false);
            }
        }
        else {
            this.setFalling(false);
        }
    }

    @Override
    public void use(final Direction direction) {

    }
}
// oui
