package model.element;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

public class Rock extends Mobile {

    private static String        spritePath = "rock.jpg";
    private final static boolean unstable   = true;


	Rock() throws IOException {
		super(ImageIO.read(new File(Rock.spritePath)));
	}


    @Override
    public void update(Map map) {
        final int x = this.getX();
        final int y = this.getY();
        if (map.getElementByPosition(x, y - 1) == null) {
            this.setY(y - 1);
            this.setFalling(true);
        } else if ((map.getElementByPosition(x, y - 1).isUnstable())) {
            if ((map.getElemementByPosition(x - 1, y) == null) && (map.getElementByPosition(x - 1, y - 1) == null)) {
                this.setX(x - 1);
                this.setFalling(true);
            } else if ((map.getElemementByPosition(x + 1, y) == null)
                    && (map.getElementByPosition(x + 1, y - 1) == null)) {
                this.setX(x + 1);
                this.setFalling(true);
            } else {
                this.setFalling(false);
            }
        } else {
            this.setFalling(false);
        }
    }
}
