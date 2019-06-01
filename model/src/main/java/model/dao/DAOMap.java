/**
 *
 */
package model.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Map;
import model.element.Element;
import model.element.ElementFactory;

/**
 * @author Arthur Coppey
 *
 */
public class DAOMap {
    private final Connection connection;
    
    /**
     *
     */
    public DAOMap(final Connection connection) {
        this.connection = connection;
    }
    
    public Map loadMap(final int mapId) {
        Map             map               = null;
        final ResultSet mapResultSet      = this.getMapById(mapId);
        final ResultSet elementsResultSet = this.getElementsByMapId(mapId);
        try {
            mapResultSet.next();
            final String name   = mapResultSet.getString("NAME");
            final int    width  = mapResultSet.getInt("WIDTH");
            final int    height = mapResultSet.getInt("HEIGHT");
            map = new Map(width, height);
            map.setName(name);
            map = this.setElementsFromResultSet(map, elementsResultSet);
        }
        catch (final Exception error) {
            error.printStackTrace();
        }
        return map;
    }
    
    public void saveMap(final Map map) {
        final int         mapId    = this.addMap(map);
        int               elementId;
        final Element[][] elements = map.getMapping();
        for (int i = 0; i < elements.length; i++ ) {
            for (int j = 0; j < elements[i].length; j++ ) {
                elementId = this.addElement(elements[i][j]);
                this.addCoordinates(elementId, mapId, i, j);
            }
        }
    }
    
    private void addCoordinates(final int elementId, final int mapId, final int x, final int y) {
        final String     query      = "{ call addCoordinates(?, ?, ?, ?) }";
        final Connection connection = this.connection;
        try {
            final CallableStatement statement = connection.prepareCall(query);
            statement.setInt(1, elementId);
            statement.setInt(2, mapId);
            statement.setInt(3, x);
            statement.setInt(4, y);
            statement.executeQuery();
        }
        catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    private int addElement(final Element element) {
        final String     query      = "{ call addElement(?) }";
        ResultSet        result;
        final Connection connection = this.connection;
        int              elementId  = -1;
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, element.getClass().getSimpleName());
            final int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1) {
                result = preparedStatement.getGeneratedKeys();
                if (result.next()) {
                    elementId = result.getInt(1);
                }
            }
        }
        catch (final SQLException exception) {
            exception.printStackTrace();
        }
        return elementId;
    }

    private int addMap(final Map map) {
        final String     query      = "{ call addMap(?, ?, ?) }";
        ResultSet        result;
        final Connection connection = this.connection;
        int              mapId      = -1;
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, map.getName());
            preparedStatement.setInt(2, map.getWidth());
            preparedStatement.setInt(3, map.getHeight());
            final int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1) {
                result = preparedStatement.getGeneratedKeys();
                if (result.next()) {
                    mapId = result.getInt(1);
                }
            }
        }
        catch (final SQLException exception) {
            exception.printStackTrace();
        }
        return mapId;
    }
    
    private ResultSet getElementsByMapId(final int mapId) {
        final String     query      = "{ call getElementsByMapId(?) }";
        ResultSet        resultSet  = null;
        final Connection connection = this.connection;
        try {
            final CallableStatement statement = connection.prepareCall(query);
            statement.setInt(1, mapId);
            resultSet = statement.executeQuery();
        }
        catch (final Exception exception) {
            exception.printStackTrace();
        }
        return resultSet;
    }
    
    private ResultSet getMapById(final int mapId) {
        final String     query      = "{ call getMapById(?) }";
        ResultSet        resultSet  = null;
        final Connection connection = this.connection;
        try {
            final CallableStatement statement = connection.prepareCall(query);
            statement.setInt(1, mapId);
            resultSet = statement.executeQuery();
        }
        catch (final Exception exception) {
            exception.printStackTrace();
        }
        return resultSet;
    }

    private Map setElementsFromResultSet(final Map map, final ResultSet elementsRes)
        throws SQLException, IOException, Exception {
        String               elementType;
        int                  x;
        int                  y;
        final ElementFactory factory = new ElementFactory();
        while (elementsRes.next()) {
            elementType = elementsRes.getString("TYPE");
            x           = elementsRes.getInt("X");
            y           = elementsRes.getInt("Y");
            switch (elementType) {
                case "Diamond":
                    map.setElementToPosition(factory.createDiamond(x, y), x, y);
                    map.getElements().add(map.getElementByPosition(x, y));
                    break;
                case "Dirt":
                    map.setElementToPosition(factory.createDirt(), x, y);
                    break;
                case "Exit":
                    map.setElementToPosition(factory.createExit(), x, y);
                    break;
                case "Mob":
                    map.setElementToPosition(factory.createMob(x, y), x, y);
                    map.getElements().add(map.getElementByPosition(x, y));
                    break;
                case "Player":
                    map.setElementToPosition(factory.createPlayer(x, y), x, y);
                    map.getElements().add(map.getElementByPosition(x, y));
                    break;
                case "Rock":
                    map.setElementToPosition(factory.createRock(x, y), x, y);
                    map.getElements().add(map.getElementByPosition(x, y));
                    break;
                case "Wall":
                    map.setElementToPosition(factory.createWall(), x, y);
                    break;
                default:
                    map.setElementToPosition(null, x, y);
                    break;
            }
        }
        return map;
    }
}
