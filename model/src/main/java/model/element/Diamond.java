package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Direction;
import model.Map;

public class Diamond extends Mobile {
	private static String spritePath = "Diamond.png";
	// @SuppressWarnings("unused")

	Diamond(final int x, final int y) throws IOException {
		super(ImageIO.read(new File(Diamond.spritePath)));
		this.setX(x);
		this.setY(y);
		this.unstable = true;
	}

	@Override
	public synchronized void update(final Map map) throws Exception {
		final int tempX = this.getX();
		final int tempY = this.getY();

		if (this.getSouth(map, tempX, tempY) == null) {
			this.setY(tempY + 1);
			this.setFalling(true);

		} else if (this.getSouth(map, tempX, tempY).getClass().getSimpleName().equals("Player") && this.isFalling()) {
			this.getSouth(map, tempX, tempY).die(map);

		} else if ((this.getSouth(map, tempX, tempY).isUnstable())) {

			if ((this.getWest(map, tempX, tempY) == null) && (this.getSouthWest(map, tempX, tempY) == null)) {

				this.setX(tempX - 1);
				this.setFalling(true);
			} else if ((this.getEast(map, tempX, tempY) == null) && (this.getSouthEast(map, tempX, tempY) == null)) {
				this.setX(tempX + 1);
				this.setFalling(true);
			} else {
				this.setFalling(false);
			}
		} else {
			this.setFalling(false);
		}
		if (this.isFalling()) {
			map.setElementToPosition(this, this.getX(), this.getY());
			this.kill(map, tempX, tempY);
		}
	}

	@Override
	public synchronized boolean use(final Direction direction, Map map) throws Exception {
		System.out.println("1diams");
		this.kill(map, this.getX(), this.getY());
		return true;
	}
}
