package model.Element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall extends Motionless {
	private static String spritePath = "wall.jpg";

	Wall() throws IOException {
		super(ImageIO.read(new File(Wall.spritePath)));

	}
}
