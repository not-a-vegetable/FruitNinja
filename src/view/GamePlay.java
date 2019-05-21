package view;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class GamePlay extends BasicGameState {

    boolean quit = false;
    int applePosX = 20;
    int applePosY = 0;
    int time;
    int orangePosX = 320;
    int orangePosY = 0;
    Book[] books = new Book[2];


    // List<Fruit> fruit = new ArrayList<>();


    public GamePlay(int state) {

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {


    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        g.drawString("Time: " + time / 1000, 500, 10);
        g.drawString("Lives: ", 400, 10);
        Image apple = new Image("fruitNinja1/images/apple.png");
        Image orange = new Image("fruitNinja1/images/orange.png");
        books[0] = apple;
        books[1] = orange;

        g.drawImage(apple, applePosX, applePosY);
        g.drawImage(orange, orangePosX, orangePosY);


        if (quit == true) {
            g.drawString("Resume (R)", 250, 100);
            g.drawString("Main Menu (M)", 250, 150);
            g.drawString("Quit Game (Q)", 250, 200);
            if (quit == false) {
                g.clear();
            }
        }

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

        time += delta;
        applePosX += 0.05 * delta;
        applePosY += 0.05 * delta;
        orangePosX += -0.05 * delta;
        orangePosY += 0.05 * delta;


        if (Mouse.isButtonDown(0)) {
            System.out.println("Mouse clicked at (" + Mouse.getX() + ", " + Mouse.getY() + ")");
            for (Image fruit : fruits) {
                if (fruit.inBounds(Mouse.getX(), Mouse.getY())) {
                    fruit.highlight();
                    System.exit(0);
                    System.out.println("Box clicked at (" + Mouse.getX() + ", " + Mouse.getY() + ").");
                    break;
                }
            }
        }


        //setLooping();


        //The losing criteria logic
        if (applePosY < 0 || applePosX > 640) {
            sbg.enterState(2);
        }


        //Keyboard input from user
        Input input = gc.getInput();
        //Logic for the pause menu , need to fix the pausing feature
        if (input.isKeyDown(Input.KEY_ESCAPE)) {
            quit = true;
        }

        if (quit == true) {
            gc.pause();

            if (input.isKeyDown(Input.KEY_R)) {
                quit = false;
                gc.resume();
            }
            if (input.isKeyDown(Input.KEY_M)) {
                sbg.enterState(0);
            }
            if (input.isKeyDown(Input.KEY_Q)) {
                System.exit(0);

            }
        }

    }


    public int getID() {
        return 1;
    }

}
