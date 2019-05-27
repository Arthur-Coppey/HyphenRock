package model;

import java.util.Observable;

import contract.IModel;
import model.Element.Element;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private Element[][] map;
	private int score;
	private final MapMaker mapMaker;

	/**
	 * Instantiates a new model.
	 */
	public Model() {

		this.mapMaker = new MapMaker();
	}

	public Element[][] getMap(int level) {
		return this.map;
	}

	public void setMap(Element[][] map) {
		this.map = map;
	}

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public void gameUpdate(String code) {
		// TODO Auto-generated method stub

	}

}
