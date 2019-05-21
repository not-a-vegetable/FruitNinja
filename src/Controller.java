import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import view.EndScreen;
import view.GamePlay;
import view.Menu;


public class Controller extends StateBasedGame {
    public static final int menu = 0;
    public static final int gamePlay = 1;
    public static final int endScreen = 2;
    private Music music;

    public Controller(String title) throws SlickException {
        super(title);
        this.addState(new Menu(menu));
        this.addState(new GamePlay(gamePlay));
        this.addState(new EndScreen(endScreen));
    }

    public void initStatesList(GameContainer container) throws SlickException {
        this.getState(menu).init(container, this);
        this.getState(gamePlay).init(container, this);
        this.getState(endScreen).init(container, this);
        this.enterState(menu);

        music = new Music("res/Music/EphixaStephenWalkingMatch.ogg");
        music.loop();
    }
}
