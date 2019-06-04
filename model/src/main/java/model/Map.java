package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.element.Element;
import model.element.Player;

public class Map {
	private ArrayList<Element> elements;
	private final int height;
	private final Element[][] mapping;
	private String name;
	private Player player;
	private HashMap<String, Integer> score;
	private final int width;

	public Map(final int width, final int height) {
		this.width = width;
		this.height = height;
		this.name = "";
		this.mapping = new Element[width][height];
		this.elements = new ArrayList<Element>();
	}

	public synchronized Element getElementByPosition(final int x, final int y) {

		if ((x < 0) || (y < 0) || (x >= this.width) || (y >= this.height)) {
			return null;
		}
		return this.mapping[x][y];

	}

	/**
	 * @return the elements
	 */
	public synchronized ArrayList<Element> getElements() {
		return this.elements;
	}

	public int getHeight() {
		return this.height;
	}

	/**
	 * @return the mapping
	 */
	public Element[][] getMapping() {
		return this.mapping;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return this.player;
	}

	public HashMap<String, Integer> getScore() {
		return this.score;
	}

	public int getWidth() {
		return this.width;
	}

	public synchronized void setElements(final ArrayList<Element> elements) {
		this.elements = elements;
	}

	public synchronized void setElementToPosition(final Element element, final int x, final int y) {
		if ((x < 0) || (y < 0) || (x >= this.width) || (y >= this.height)) {
			return;
		}
		this.mapping[x][y] = element;
	}

	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @param element
	 *            the player to set
	 */
	public void setPlayer(final Player element) {
		this.player = element;
	}

	public void setScore(final HashMap<String, Integer> score) {
		this.score = score;
	}
}
