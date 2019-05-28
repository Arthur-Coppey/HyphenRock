package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The Class DAOElement.
 *
 * @author Jean-Aymeric Diet
 *
 * @param <E>
 *        the element type
 */
public class DAOElement<Element> {

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
    public boolean create(final Element element) {
        return false;
    }

    /**
     * Delete.
     *
     * @param element
     *                the entity
     * @return true, if successful
     */
    public boolean delete(final Element element) {
        return false;
    }

    /**
     * Find.
     *
     * @param code
     *             the code
     * @return the e
     */
    public Element find(final String code) {
        return null;
    }

    /**
     * Find.
     *
     * @param id
     *           the id
     * @return the e
     */
    public ArrayList<Element> getElementsByMapId(final int id) {
        return null;
    }

    /**
     * Update.
     *
     * @param element
     *                the entity
     * @return true, if successful
     */
    public boolean update(final Element element) {
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
