package model.element;

import java.io.IOException;

public class ElementFactory {

    private final Wall wall; // = new Wall();
    private final Dirt dirt; // = new Dirt();
    private final Exit exit; // = new Exit();

    public ElementFactory() throws IOException {

        this.wall = new Wall();
        this.dirt = new Dirt();
        this.exit = new Exit();
    }

    public Dirt createDirt() {
        return this.dirt;
    }

    public Exit createExit() {
        return this.exit;
    }

    public Wall createWall() {
        return this.wall;
    }
}
