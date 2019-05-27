package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mob extends Mobile {
	private static String spritePath = "mob.jpg";

	Mob() throws IOException {
		super(ImageIO.read(new File(Mob.spritePath)));

	}
}
