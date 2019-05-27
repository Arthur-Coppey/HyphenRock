package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The Class DAOElement.
 *
 * @author Jean-Aymeric Diet
 *
 * @param <E>
 *        the element type
 */
public class DAOElement<E> {

    /** The connection. */
    private final Connection connection;

    /**
     * Instantiates a new DAO element.
     *
     * @param connection
     *                   the connection
     * @throws SQLException
     *                      the SQL exception
     */
    public DAOElement(final Connection connection) throws SQLException {
        this.connection = connection;
    }

    /**
     * Creates the.
     *
     * @param element
     *                the element
     * @return true, if successful
     */
    public boolean create(final E element) {
        return false;
    }

    /**
     * Delete.
     *
     * @param element
     *                the entity
     * @return true, if successful
     */
    public boolean delete(final E element) {
        return false;
    }

    /**
     * Find.
     *
     * @param id
     *           the id
     * @return the e
     */
    public E find(final int id) {
        return null;
    }

    /**
     * Find.
     *
     * @param code
     *             the code
     * @return the e
     */
    public E find(final String code) {
        return null;
    }

    /**
     * Update.
     *
     * @param element
     *               the entity
     * @return true, if successful
     */
    public boolean update(final E element) {
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
