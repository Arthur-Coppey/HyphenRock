package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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

    private final Connection connection;

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
        final String             query = "{ call getElementsByMapId(?) }";
        final ResultSet          resultSet;
        final ArrayList<Element> elements;
        final Element            element;
        try (CallableStatement statement = this.connection.prepareCall(query)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                switch (resultSet.getString("TYPE")) {
                    case "Diamond":
                }
            }
        }
        catch (final Exception exception) {
            
        }
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
