package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observable;

import contract.Direction;
import contract.IModel;
import model.dao.DAOMap;
import model.dao.DBConnection;
import model.dao.GameSettingsProperties;
import model.element.Element;
import model.element.Mobile;

public final class Model extends Observable implements IModel {

	private final DAOMap daoMap;
	private final GameSettingsProperties gameSettings = new GameSettingsProperties();
	private Map map;
	private int score;

	public Model() {
		this.daoMap = new DAOMap(DBConnection.getInstance().getConnection());
		this.map = this.daoMap.loadMap(this.gameSettings.getMapId());
	}

	public Map createMapFromFile(final String fileName) {
		return this.daoMap.createMapFromFile(fileName);
	}

	@Override
	public synchronized void gameUpdate(final Direction direction) throws Exception {
		// final int tempX;
		// final int tempY;
		// System.out.println(direction);
		if (this.map.getPlayer() == null) {
			System.exit(0);
		}
		this.map.getPlayer().playerUpdate(direction, this.map);
		final ArrayList<Element> elementsTemp = new ArrayList<Element>(this.map.getElements());
		for (final Element element : elementsTemp) {
			// tempX = ((Mobile) element).getX();
			// tempY = ((Mobile) element).getY();

			((Mobile) element).update(this.map);

		}
		this.map.setElements(elementsTemp);
		// System.out.println("test");
		this.setChanged();
		this.notifyObservers();
	}

	public Map getMap() {
		return this.map;
	}

	public Element[][] getMapping() {
		return this.map.getMapping();
	}

	@Override
	public Observable getObservable() {
		return this;
	}

	public int getScore() {
		return this.score;
	}

	@Override
	public synchronized BufferedImage[][] getSprites() {
		final BufferedImage[][] sprites;
		final Element[][] elements = this.getMapping();
		sprites = new BufferedImage[this.map.getWidth()][this.map.getHeight()];
		for (int i = 0; i < sprites.length; i++) {
			for (int j = 0; j < sprites[i].length; j++) {
				if (elements[i][j] != null) {
					sprites[i][j] = elements[i][j].getSprite();
				}
			}
		}
		return sprites;
	}

	public void saveMap() {
		this.daoMap.saveMap(this.map);
	}

	public void setMap(final Map map) {
		this.map = map;
	}

	public void setScore(final int score) {
		this.score = score;
	}

	private synchronized void kill(final Map map, final int x, final int y) throws Exception {
		map.getElements().remove(map.getElementByPosition(x, y));
		map.setElementToPosition(null, x, y);

	}

}
