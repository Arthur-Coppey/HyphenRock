package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Direction;
import model.Map;

public class Dirt extends Motionless {
	private static String spritePath = "src/main/resources/Dirt.png";

	Dirt() throws IOException {
		super(ImageIO.read(new File(Dirt.spritePath)));
	}

	@Override
	public boolean use(Direction direction, Map map) {
		return true;
	}
}
