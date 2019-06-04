package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Exit extends Motionless {
    private static String spritePath = "Exit.png";
    
    Exit() throws IOException {
        super(ImageIO.read(new File(Exit.spritePath)));
        
    }
}
