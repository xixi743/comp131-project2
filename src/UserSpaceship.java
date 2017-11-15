import java.awt.Color;
import java.awt.Graphics;

public class UserSpaceship extends GraphicsObject {

    public UserSpaceship(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw (Graphics g) {
        g.setColor(new Color(19, 219, 43));
        g.fillRect(this.x, this.y, 20, 20);
    }

/*    public void moveIt(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                myY += 5;
                break;
            case KeyEvent.VK_UP:
                myY -= 5;
                break;
            case KeyEvent.VK_LEFT:
                myX -= 5;
                break;
            case KeyEvent.VK_RIGHT:
                myX += 5;
                break;
        }*/
}