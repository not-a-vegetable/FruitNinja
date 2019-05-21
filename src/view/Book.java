package view;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public class Book extends Image {
    public String name;
    public Rectangle bounds = new Rectangle();

    Book(String s, String name) throws SlickException {
        super(s);
        this.name = name;
    }

    public boolean inBounds(int x, int y) {
        return bounds.intersects(x, y, 1, 1);
    }
}
