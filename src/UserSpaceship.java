import java.awt.Color;
import java.awt.Graphics;

public class UserSpaceship extends GraphicsObject {

    public UserSpaceship(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw (Graphics g) {
        g.setColor(new Color(19, 219, 43));
        g.fillRect(300, 375, 20, 20);
    }
}