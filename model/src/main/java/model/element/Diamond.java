package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Direction;
import model.Map;

public class Diamond extends Mobile {
    private static String        spritePath = "Diamond.png";
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

        if (this.getSouth(map, x, y) == null) {
            this.setY(y + 1);
            this.setFalling(true);
        }
        else if ((this.getSouth(map, x, y).isUnstable())) {
            if ((this.getWest(map, x, y) == null) && (this.getSouthWest(map, x, y) == null)) {
                this.setX(x - 1);
                this.setFalling(true);
            }
            else if ((this.getEast(map, x, y) == null) && (this.getSouthEast(map, x, y) == null)) {
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

    public boolean use(final Direction direction) {
        return true;
    }
}
