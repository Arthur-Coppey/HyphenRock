package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall extends Motionless {
    private static String        spritePath = "Wall.png";
    private final static boolean unstable   = true;
    
    Wall() throws IOException {
        super(ImageIO.read(new File(Wall.spritePath)));
        
    }
}
