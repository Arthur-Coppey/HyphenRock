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

    public Element createElementFromClassName(final String className, final int x, final int y) throws IOException {
        final Element element;
        switch (className) {
            case "Diamond":
                element = this.createDiamond(x, y);
                break;
            case "Dirt":
                element = this.createDirt();
                break;
            case "Exit":
                element = this.createExit();
                break;
            case "Mob":
                element = this.createMob(x, y);
                break;
            case "Player":
                element = this.createPlayer(x, y);
                break;
            case "Rock":
                element = this.createRock(x, y);
                break;
            case "Wall":
                element = this.createWall();
                break;
            default:
                element = null;
                break;
        }
        return element;
    }

    /**
     * @param c
     * @return
     * @throws IOException
     */
    public Element createElementFromFileSymbol(final char symbol, final int x, final int y) throws IOException {
        String className;
        switch (symbol) {
            case 'd':
                className = "Diamond";
                break;
            case '.':
                className = "Dirt";
                break;
            case 'X':
                className = "Exit";
                break;
            case ' ':
                className = " ";
                break;
            case 'P':
                className = "Player";
                break;
            case 'r':
                className = "Rock";
                break;
            case 'w' | 'W':
                className = "Wall";
                break;
            default:
                className = "Mob";
                break;
        }
        return this.createElementFromClassName(className, x, y);
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
