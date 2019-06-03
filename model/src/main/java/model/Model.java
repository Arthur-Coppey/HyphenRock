package model;

import java.util.Observable;

import contract.Direction;
import contract.IModel;
import model.dao.DAOMap;
import model.dao.DBConnection;
import model.dao.GameSettingsProperties;
import model.element.Element;

public final class Model extends Observable implements IModel {

    private final DAOMap                 daoMap;
    private final GameSettingsProperties gameSettings = new GameSettingsProperties();
    private Map                          map;
    private Element[][]                  mapping;
    private int                          score;

    public Model() {
        this.daoMap = new DAOMap(DBConnection.getInstance().getConnection());
        this.map    = this.daoMap.loadMap(this.gameSettings.getMapId());
    }

    public Map createMapFromFile(final String fileName) {
        return this.daoMap.createMapFromFile(fileName);
    }

    @Override
    public void gameUpdate(final Direction direction) throws Exception {
        this.map.getPlayer().playerUpdate(direction, this.map);
        for (final Element element : this.map.getElements()) {
            element.update();
        }
    }

    public Map getMap() {
        return this.map;
    }
    
    public Element[][] getMapping(final int level) {
        return this.mapping;
    }

    @Override
    public Observable getObservable() {
        return this;
    }

    public int getScore() {
        return this.score;
    }

    public void saveMap() {
        this.daoMap.saveMap(this.map);
    }

    public void setMap(final Map map) {
        this.map = map;
    }

    public void setMapping(final Element[][] mapping) {
        this.mapping = mapping;
    }

    public void setScore(final int score) {
        this.score = score;
    }

}
