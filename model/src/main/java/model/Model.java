package model;

import java.util.Observable;

import contract.Direction;
import contract.IModel;
import model.element.Element;

public final class Model extends Observable implements IModel {

    /** The helloWorld. */
    private Element[][] map;
    private int         score;
    private final Map   mapMaker;

    public Model() {

        this.mapMaker = new Map();
    }

    @Override
    public void gameUpdate(Direction direction) {
        this.map.player.playerUpdate(direction);
        for (final Element E : this.map.getElements()) {
            E.update(this.map);
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
