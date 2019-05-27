package model.Element;

import java.awt.image.BufferedImage;

public abstract class Element {
	private BufferedImage sprite;

	Element(BufferedImage Sprite) {
		this.sprite = Sprite;
	}

	void update() {

	}

	public BufferedImage getSprite() {
		return this.sprite;
	}

	public void setSprite(BufferedImage Sprite) {
		this.sprite = Sprite;
	}

}
