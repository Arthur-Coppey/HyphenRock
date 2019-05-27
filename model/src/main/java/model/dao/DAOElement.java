package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The Class DAOEntity.
 *
 * @author Jean-Aymeric Diet
 *
 * @param <E>
 *            the element type
 */
public class DAOElement<E> {

	/** The connection. */
	private final Connection connection;

	/**
	 * Instantiates a new DAO entity.
	 *
	 * @param connection
	 *            the connection
	 * @throws SQLException
	 *             the SQL exception
	 */
	public DAOElement(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	/**
	 * Creates the.
	 *
	 * @param entity
	 *            the entity
	 * @return true, if successful
	 */
	public boolean create(E entity) {
		return false;
	}

	/**
	 * Delete.
	 *
	 * @param entity
	 *            the entity
	 * @return true, if successful
	 */
	public boolean delete(E entity) {
		return false;
	}

	/**
	 * Find.
	 *
	 * @param id
	 *            the id
	 * @return the e
	 */
	public E find(int id) {
		return null;
	}

	/**
	 * Find.
	 *
	 * @param code
	 *            the code
	 * @return the e
	 */
	public E find(String code) {
		return null;
	}

	/**
	 * Update.
	 *
	 * @param entity
	 *            the entity
	 * @return true, if successful
	 */
	public boolean update(E entity) {
		return false;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}

}
