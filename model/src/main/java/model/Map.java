package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.element.Element;
import model.element.Player;

public class Map {
    private ArrayList<Element>       elements;
    private final int                height;
    private final Element[][]        mapping;
    private String                   name;
    private Player                   player;
    private HashMap<String, Integer> score;
    private final int                width;

    public Map(final int width, final int height) {
        this.width   = width;
        this.height  = height;
        this.mapping = new Element[width][height];
    }
    
    public Element getElementByPosition(final int x, final int y) throws Exception {
        return this.mapping[x][y];
    }
    
    /**
     * @return the elements
     */
    public ArrayList<Element> getElements() {
        return this.elements;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    /**
     * @return the mapping
     */
    public Element[][] getMapping() {
        return this.mapping;
    }
    
    public String getName() {
        return this.name;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return this.player;
    }

    public HashMap<String, Integer> getScore() {
        return this.score;
    }
    
    public int getWidth() {
        return this.width;
    }

    public void setElements(final ArrayList<Element> elements) {
        this.elements = elements;
    }

    public void setElementToPosition(final Element element, final int x, final int y) throws Exception {
        this.mapping[x][y] = element;
    }

    public void setName(final String name) {
        this.name = name;
    }
    
    /**
     * @param player
     *               the player to set
     */
    public void setPlayer(final Player player) {
        this.player = player;
    }
    
    public void setScore(final HashMap<String, Integer> score) {
        this.score = score;
    }
}
