package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.HelloWorld;
import model.Element.Element;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private Element[][] map;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.helloWorld = new HelloWorld();
	}

	/**
	 * Gets the hello world.
	 *
	 * @return the hello world
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public HelloWorld getHelloWorld() {
		return this.helloWorld;
	}

	/**
	 * Sets the hello world.
	 *
	 * @param helloWorld
	 *            the new hello world
	 */
	private void setHelloWorld(final HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Load hello world.
	 *
	 * @param code
	 *            the code
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	@Override
	public void loadHelloWorld(final String code) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setHelloWorld(daoHelloWorld.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
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

	public Element[][] getMap() {
		return map;
	}

	public void setMap(Element[][] map) {
		this.map = map;
	}
}
