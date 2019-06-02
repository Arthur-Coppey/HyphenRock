/**
 *
 */
package model.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		Map map = null;
		final ResultSet mapResultSet = this.getMapById(mapId);
		final ResultSet elementsResultSet = this.getElementsByMapId(mapId);
		try {
			mapResultSet.next();
			final String name = mapResultSet.getString("NAME");
			final int width = mapResultSet.getInt("WIDTH");
			final int height = mapResultSet.getInt("HEIGHT");
			map = new Map(width, height);
			map.setName(name);
			map = this.setElementsFromResultSet(map, elementsResultSet);
		} catch (final Exception error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
		}

		return map;
	}

	public void saveMap(final Map map) {

	}

	private void addCoordinates(final int mapId, final int elementId, final int x, final int y) {

	}

	private void addElement(final Element element) {

	}

	private void addMap(final Map map) {

	}

	private ResultSet getElementsByMapId(final int mapId) {
		final String query = "{ call getElementsByMapId(?) }";
		ResultSet resultSet = null;

		try (CallableStatement statement = this.connection.prepareCall(query)) {

			statement.setInt(1, mapId);

			resultSet = statement.executeQuery();
			return resultSet;
		} catch (final Exception exception) {
			exception.printStackTrace();
		}
		return resultSet;
	}

	private ResultSet getMapById(final int mapId) {
		final String query = "{ call getMapById(?) }";
		ResultSet resultSet = null;

		try (CallableStatement statement = this.connection.prepareCall(query)) {

			statement.setInt(1, mapId);

			resultSet = statement.executeQuery();
		} catch (final Exception exception) {
			exception.printStackTrace();
		}
		return resultSet;
	}

	private Map setElementsFromResultSet(final Map map, final ResultSet elementsRes)
			throws SQLException, IOException, Exception {
		String elementType;
		int x;
		int y;
		final ElementFactory factory = new ElementFactory();
		while (elementsRes.next()) {
			elementType = elementsRes.getString("TYPE");
			x = elementsRes.getInt("X");
			y = elementsRes.getInt("Y");
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
