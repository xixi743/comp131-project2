import java.awt.Color;
import java.awt.Graphics;

public class Enemies extends GraphicsObject {

    public Enemies(int x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        int size = 30;

        int displacement = size + 30;
        for (int column = 0; column < 5; column ++) {
            for (int row = 0; row < 9; row++) {
                //draw the enemies
                g.setColor(new Color(255, 0, 0));
                g.fillRect((int)x + (displacement * row), (int)y + (displacement * column), (int)size, (int)size);}
        }

        /*int w = 0;
        int i = 0;
        while (w < 6) {
            y = 50;
            while (i < 4) {
                x = 50;
                g.setColor(new Color(255, 0, 0));
                g.fillRect((int)x, (int) y, 40, 30);
                i++;
                y = y + 50;
            }
            i = 0;
            w++;
            x = x + 50;
            y = y + 50;
        }
    */}
}