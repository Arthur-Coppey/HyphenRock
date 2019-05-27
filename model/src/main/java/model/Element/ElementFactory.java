package model.Element;

import java.io.IOException;

public class ElementFactory {
    private final Player  player;  // = new Player();
    private final Mob     mob;     // = new Mob();
    private final Rock    rock;    // = new Rock();
    private final Wall    wall;    // = new Wall();
    private final Diamond diamond; // = new Diamond();
    private final Dirt    dirt;    // = new Dirt();
    private final Exit    exit;    // = new Exit();

    public ElementFactory() throws IOException {
        this.player = new Player();
        this.mob = new Mob();
        this.rock = new Rock();
        this.wall = new Wall();
        this.diamond = new Diamond();
        this.dirt = new Dirt();
        this.exit = new Exit();
    }

    public Diamond createDiamond() {
        return this.diamond;
    }

    public Dirt createDirt() {
        return this.dirt;
    }

    public Exit createExit() {
        return this.exit;
    }

    public Mob createMob() {
        return this.mob;
    }

    public Player createPlayer() {
        return this.player;
    }

    public Rock createRock() {
        return this.rock;
    }

    public Wall createWall() {
        return this.wall;
    }
}
