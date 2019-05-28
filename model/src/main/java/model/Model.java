package model;

import java.util.Observable;

import contract.Direction;
import contract.IModel;
import model.element.Element;

public final class Model extends Observable implements IModel {

    /** The helloWorld. */
    private Element[][]    map;
    private int            score;
    private final MapMaker mapMaker;
    private final String[] elementTab = { "player", "Mob", "Rock", "Diamond" };

    /**
     * Instantiates a new model.
     */
    public Model() {

        this.mapMaker = new MapMaker();
    }

    @Override
    public void gameUpdate(Direction direction) {

    }

    public Element[][] getMap(int level) {
        return this.map;
    }

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    /*
     * (non-Javadoc)
     *
     * @see contract.IModel#getObservable()
     */
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
