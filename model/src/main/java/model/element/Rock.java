package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Direction;
import model.Map;

public class Rock extends Mobile {

	private static String spritePath = "Rock.png";

	@SuppressWarnings("unused")

	Rock(final int x, final int y) throws IOException {
		super(ImageIO.read(new File(Rock.spritePath)));
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
	public boolean use(final Direction direction, final Map map) throws Exception {
		final int directionInInt = this.directionToInt(direction);
		if ((this.getInDirection(direction, map) == null) && (((directionInInt % 2)) == 1)) {
			map.setElementToPosition(null, this.getX(), this.getY());
			this.setX(this.directionCoordinate(directionInInt)[0] + this.getX());
			this.setY(this.directionCoordinate(directionInInt)[1] + this.getY());
			map.setElementToPosition(this, this.getX(), this.getY());
			return true;
		} else {
			return false;
		}
	}
}
