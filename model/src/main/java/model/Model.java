package model;

import java.util.Observable;

import contract.Direction;
import contract.IModel;
import model.dao.DAOMap;
import model.element.Element;

public final class Model extends Observable implements IModel {

    /** The helloWorld. */
    private Element[][]  map;
    private int          score;
    private final Map    mapMaker;
    private final DAOMap daoMap;

    public Model() {
        this.daoMap = new DAOMap(DBConnection.getInstance().getConnection());
        this.mapMaker = DAOMap.loadMap();
    }

    @Override
    public void gameUpdate(Direction direction) throws Exception {
        this.mapMaker.getPlayer().playerUpdate(direction, this.mapMaker);
        for (final Element E : this.mapMaker.getElements()) {
            E.update();

        }
    }

    public Element[][] getMap(int level) {
        return this.map;
    }

    @Override
    public Observable getObservable() {
        return this;
    }

    public int getScore() {
        return this.score;
    }

    public void setMap(Element[][] map) {
        this.map = map;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
