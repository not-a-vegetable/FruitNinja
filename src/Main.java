import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import view.Window;

public class Main {
    public static void main(String[] args) {
        AppGameContainer container;

        try {
            container = new AppGameContainer(new Controller(Window.title));
            container.setDisplayMode(Window.x, Window.y, false);
            container.setVSync(true);
            container.setShowFPS(false);
            container.start();
        } catch (SlickException exception) {
            exception.printStackTrace();
        }
    }
}
