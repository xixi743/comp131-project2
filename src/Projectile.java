import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GraphicsObject {

    public Projectile(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw (Graphics g) {
        g.setColor(new Color(19, 219, 43));
        g.fillRect(this.x, this.y, 20, 20);
    }
    public void fire () {
        while (this.y < 0) {
            this.y -= 5;
        }
    }

}
