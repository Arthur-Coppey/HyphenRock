package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Direction;
import model.Map;

public class Player extends Mobile {
	private static String spritePath = "PlayerDown.png";

	Player(final int x, final int y) throws IOException {
		super(ImageIO.read(new File(Player.spritePath)));
		this.setX(x);
		this.setY(y);
	}

	@Override
	public void die(final Map map) throws Exception {
		this.explode(map);
		map.setElementToPosition(null, super.getX(), super.getY());
		map.getElements().remove(map.getElementByPosition(super.getX(), super.getY()));
		map.setPlayer(null);
	}

	public void playerUpdate(final Direction direction, final Map map) throws Exception {

		int tempX = super.getX();
		int tempY = super.getY();
		switch (direction) {
		case UP:
			tempY -= 1;
			break;
		case DOWN:
			tempY += 1;
			break;
		case RIGHT:
			tempX += 1;
			break;
		case LEFT:
			tempX -= 1;
			break;
		case NULL:
			break;
		default:
			break;
		}
		// debug
		// System.out.println(this.getX());
		// System.out.println(this.getY());
		// System.out.println(map.getElementByPosition(this.getX(),
		// this.getY()));
		// if ((map.getElementByPosition(this.getX(), this.getY()) != null)) {
		// System.out.println(map.getElementByPosition(this.getX(),
		// this.getY()).use(direction, map));
		// }
		// System.out.println("===");

		if ((map.getElementByPosition(tempX, tempY) != null)
				&& !map.getElementByPosition(tempX, tempY).use(direction, map)) {
		} else {
			this.kill(map, this.getX(), this.getY());
			this.kill(map, tempX, tempY);
			super.setX(tempX);
			super.setY(tempY);
			map.setElementToPosition(this, this.getX(), this.getY());

		}
	}

}
