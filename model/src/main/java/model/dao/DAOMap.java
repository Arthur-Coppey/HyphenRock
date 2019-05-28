/**
 *
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import model.Map;
import model.element.Element;

/**
 * @author Arthur Coppey
 *
 */
public class DAOMap {
    private final Connection    connection;
    private DAOElement<Element> daoElement;
    
    /**
     *
     */
    public DAOMap(final Connection connection) {
        this.connection = connection;
    }
    
    public void getMapById(final int mapId) {
        final String query = "{ call getMapById(?) }";
        ResultSet    resultSet;
        
        try (CallableStatement stmt = this.connection.prepareCall(query)) {
            
            stmt.setInt(1, mapId);
            
            resultSet = stmt.executeQuery();
            resultSet.next();
            final int    width  = resultSet.getInt("width");
            final int    height = resultSet.getInt("height");
            final String name   = resultSet.getString("name");
            final Map    map    = new Map(width, height);
            map.setName(name);
            
        }
        catch (final Exception exception) {
            exception.printStackTrace();
        }
    }
}
