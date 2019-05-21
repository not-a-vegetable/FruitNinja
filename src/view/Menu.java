package view;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Random;


public class Menu extends BasicGameState {
    Random rand;
    Book easy;
    Book moderate;
    Book hard;
    Book exit;
    private int score = 0;
    private Image tile;
    private Book[] books = new Book[2];

    public Menu(int state) throws SlickException {

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        rand = new Random();
        tile = new Image("res/images/tileset.png");
        books[0] = new Book("res/images/book1.png", "play");
        books[1] = new Book("res/images/book3.png", "exit");
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.black);
        for (int h = 0; h < Window.y; h += tile.getHeight()) {
            for (int w = 0; w < Window.x; w += tile.getWidth()) {
                g.drawImage(tile, w, h);
            }
        }
        g.drawString("Welcome to Book Ninja!", 30, 50);
        g.drawString("Instructions: Slice the falling fruits and avoid de bombs", 30, 70);
        g.drawImage(books[0], 30, 120);
        books[1].bounds.setBounds(30, 120, 50, 50);
        g.drawString("Easy", 80, 130);
        g.drawImage(books[1], 30, 170);
        books[0].bounds.setBounds(30, 170, 50, 50);
        g.drawString("Exit", 80, 180);
        g.drawString("High Score: " + score, (Window.x - (12 + String.valueOf(score).length()) * 10), 10);
    }

    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        if (Mouse.isButtonDown(0)) {
            for (Book book : books) {
                if (book.inBounds(Mouse.getX(), Mouse.getY())) {
                    if (book.name.equals("play")) {
                        sbg.enterState(1);
                    } else if (book.name.equals("exit")) {
                        System.exit(0);
                    }
                }
            }
        }


    }

    public int getID() {
        return 0;
    }


}
