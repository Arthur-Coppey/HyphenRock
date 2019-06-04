package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Direction;
import model.Map;

public class Dirt extends Motionless {
    private static String spritePath = "Dirt.png";
    
    Dirt() throws IOException {
        super(ImageIO.read(new File(Dirt.spritePath)));
    }
    
    @Override
    public boolean use(final Direction direction, final Map map) {
        return true;
    }
}
