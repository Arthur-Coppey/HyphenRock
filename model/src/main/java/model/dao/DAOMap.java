/**
 *
 */
package model.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private ElementFactory   elementFactory;

    /**
     * @param connection
     *                   the connection
     */
    public DAOMap(final Connection connection) {
        this.connection = connection;
        try {
            this.elementFactory = new ElementFactory();
        }
        catch (final IOException error) {
            // TODO Auto-generated catch block
            error.printStackTrace();
        }
    }

    public Map createMapFromFile(final String fileName) {
        Map map = null;
        try {
            final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String               line;
            int                  y      = 0;
            int                  width;
            int                  height;
            Element              element;
            String               elementName;
            width  = Integer.parseInt(buffer.readLine());
            height = Integer.parseInt(buffer.readLine());
            map    = new Map(width, height);
            while ((line = buffer.readLine()) != null) {
                for (int x = 0; x < line.toCharArray().length; x++ ) {
                    element = this.elementFactory.createElementFromFileSymbol(line.toCharArray()[x], x, y);
                    map.setElementToPosition(element, x, y);
                    if (element != null) {
                        elementName = element.getClass().getSimpleName();
                        if ((elementName != "Dirt") && (elementName != "Wall") && (elementName != "Exit")) {
                            map.getElements().add(element);
                        }
                    }
                }
                y++ ;
            }
            buffer.close();
        }
        catch (final Exception error) {
            error.printStackTrace();
        }
        return map;
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
        final int mapId = this.addMap(map);
        for (int i = 0; i < map.getMapping().length; i++ ) {
            for (int j = 0; j < map.getMapping()[i].length; j++ ) {
                this.addCoordinates(this.addElement(map.getMapping()[i][j]), mapId, i, j);
            }
        }
    }
    
    private void addCoordinates(final int elementId, final int mapId, final int elementX, final int elementY) {
        final String     query      = "{ call addCoordinates(?, ?, ?, ?) }";
        final Connection connection = this.connection;
        try {
            final CallableStatement statement = connection.prepareCall(query);
            statement.setInt("elementId", elementId);
            statement.setInt("mapId", mapId);
            statement.setInt("elementX", elementX);
            statement.setInt("elementY", elementY);
            statement.executeUpdate();
            statement.close();
        }
        catch (final Exception exception) {
            exception.printStackTrace();
        }
    }
    
    private int addElement(final Element element) {
        final String     query      = "{ call addElement(?, ?) }";
        final Connection connection = this.connection;
        int              elementId  = -1;
        long             time;
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (element != null) {
                preparedStatement.setString(1, element.getClass().getSimpleName());
            }
            else {
                preparedStatement.setString(1, "Void");
            }
            time = System.nanoTime();
            preparedStatement.setLong(2, time);
            preparedStatement.executeUpdate();
            elementId = this.getElementIdByTime(time);
            preparedStatement.close();
        }
        catch (final SQLException exception) {
            exception.printStackTrace();
        }
        return elementId;
    }

    private int addMap(final Map map) {
        final String     query      = "{ call addMap(?, ?, ?, ?) }";
        final Connection connection = this.connection;
        int              mapId      = -1;
        long             time;
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, map.getName());
            preparedStatement.setInt(2, map.getWidth());
            preparedStatement.setInt(3, map.getHeight());
            time = System.nanoTime();
            preparedStatement.setLong(4, time);
            preparedStatement.executeUpdate();
            mapId = this.getMapIdByTime(time);
            preparedStatement.close();
        }
        catch (final SQLException exception) {
            exception.printStackTrace();
        }
        return mapId;
    }
    
    private int getElementIdByTime(final long time) {
        int              elementId  = 0;
        final String     query      = "{ call getElementIdByTime(?) }";
        ResultSet        result     = null;
        final Connection connection = this.connection;
        try {
            final CallableStatement statement = connection.prepareCall(query);
            statement.setLong(1, time);
            result = statement.executeQuery();
            if (result.next()) {
                elementId = result.getInt(1);
            }
            statement.close();
        }
        catch (final Exception error) {
            error.printStackTrace();
        }
        return elementId;
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

    private int getMapIdByTime(final long time) {
        int              mapId      = 0;
        final String     query      = "{ call getMapIdByTime(?) }";
        ResultSet        result     = null;
        final Connection connection = this.connection;
        try {
            final CallableStatement statement = connection.prepareCall(query);
            statement.setLong(1, time);
            result = statement.executeQuery();
            if (result.next()) {
                mapId = result.getInt(1);
            }
        }
        catch (final Exception error) {
            error.printStackTrace();
        }
        return mapId;
    }
    
    private Map setElementsFromResultSet(final Map map, final ResultSet elementsRes) throws Exception {
        String  elementType;
        int     x;
        int     y;
        Element element;
        while (elementsRes.next()) {
            elementType = elementsRes.getString("TYPE");
            x           = elementsRes.getInt("X");
            y           = elementsRes.getInt("Y");
            element     = this.elementFactory.createElementFromClassName(elementType, x, y);
            map.setElementToPosition(element, x, y);
            if ((elementType != "Dirt") && (elementType != "Exit") && (elementType != "Wall")) {
                map.getElements().add(element);
            }
        }
        return map;
    }
}
