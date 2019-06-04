package model.element;

import java.awt.image.BufferedImage;
import java.io.IOException;

import contract.Direction;
import model.Map;

public abstract class Element {
	protected boolean unstable = false;
	private BufferedImage sprite;

	Element(BufferedImage Sprite) throws IOException {
		this.sprite = Sprite;
	}

	public void die(Map map) throws Exception {

	}

	public BufferedImage getSprite() {
		return this.sprite;
	}

	public boolean isUnstable() {
		return this.unstable;
	}

	public void setSprite(BufferedImage Sprite) {
		this.sprite = Sprite;
	}

	public synchronized void update() {

	}

	public boolean use(Direction direction, model.Map map) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	protected synchronized void kill(final Map map, final int x, final int y) throws Exception {
		if (map.getElements().indexOf(map.getElementByPosition(x, y)) != -1) {
			map.getElements().remove(map.getElementByPosition(x, y));

		}
		map.setElementToPosition(null, x, y);

	}

}
