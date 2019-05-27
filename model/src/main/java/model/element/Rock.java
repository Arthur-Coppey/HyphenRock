package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rock extends Mobile {
	private static String spritePath = "rock.jpg";

	Rock() throws IOException {
		super(ImageIO.read(new File(Rock.spritePath)));

	}
}
