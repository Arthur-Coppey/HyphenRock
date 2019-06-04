package model;

import java.awt.image.BufferedImage;
import java.util.Observable;

import contract.Direction;
import contract.IModel;
import model.dao.DAOMap;
import model.dao.DBConnection;
import model.dao.GameSettingsProperties;
import model.element.Element;

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
	public void gameUpdate(final Direction direction) throws Exception {
		// System.out.println(direction);
		this.map.getPlayer().playerUpdate(direction, this.map);
		for (final Element element : this.map.getElements()) {
			// System.out.println(this.map.getElements().size());
			// System.out.println(element.isAlive());
			element.update();
		}
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
	public BufferedImage[][] getSprites() {
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

}
