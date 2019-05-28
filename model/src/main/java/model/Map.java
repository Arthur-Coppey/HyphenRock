package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.element.Element;

public class Map {
    private ArrayList<Element>       elements;
    private final Element[][]        mapping;
    private String                   name;
    private HashMap<String, Integer> score;
    private final int                width, height;
    
    Map(final String name, final int width, final int height) {
        this.name    = name;
        this.width   = width;
        this.height  = height;
        this.mapping = new Element[width][height];
    }

    Element getElementByPosition(final int x, final int y) throws Exception {
        return this.mapping[x][y];
    }

    void placeElement(final Element element) {
        final int x = element.getX();
        final int y = element.getY();
        if (this.getElementByPosition(x, y) == null) {
            this.setElementToPosition(element, x, y);
        }
    }
    
    void setElements(final ArrayList<Element> elements) {
        this.elements = elements;
    }
    
    void setElementToPosition(final Element element, final int x, final int y) throws Exception {
        this.mapping[x][y] = element;
    }
    
    void setName(final String name) {
        this.name = name;
    }

    void setScore(final HashMap<String, Integer> score) {
        this.score = score;
    }
}
