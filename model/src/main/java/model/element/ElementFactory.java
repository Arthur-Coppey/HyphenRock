package model.element;

import java.io.IOException;

public class ElementFactory {

    private final Dirt dirt; // = new Dirt();
    private final Exit exit; // = new Exit();
    private final Wall wall; // = new Wall();

    public ElementFactory() throws IOException {

        this.wall = new Wall();
        this.dirt = new Dirt();
        this.exit = new Exit();
    }

    public Diamond createDiamond(final int x, final int y) throws IOException {
        return new Diamond(x, y);
    }

    public Dirt createDirt() {
        return this.dirt;
    }

    public Exit createExit() {
        return this.exit;
    }

    public Mob createMob(final int x, final int y) throws IOException {
        return new Mob(x, y);
    }
    
    public Player createPlayer(final int x, final int y) throws IOException {
        return new Player(x, y);
    }
    
    public Rock createRock(final int x, final int y) throws IOException {
        return new Rock(x, y);
    }

    public Wall createWall() {
        return this.wall;
    }
}
