package contract;

import java.awt.image.BufferedImage;
import java.util.Observable;

public interface IModel {
    void gameUpdate(Direction direction) throws Exception;

    Observable getObservable();

    /**
     *
     */
    BufferedImage[][] getSprites();
}
