package model.Element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Diamond extends Mobile {
	private static String spritePath = "diamond.jpg";

	Diamond() throws IOException {
		super(ImageIO.read(new File(Diamond.spritePath)));

	}
}
// oui