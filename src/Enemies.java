import java.awt.Color;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Enemies extends GraphicsObject {

    public Enemies(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw (Graphics g) {
        g.setColor(new Color(19, 219, 43));
        g.fillRect(this.x, this.y, 20, 20);
    }

    //overriding with this.y change
    public void update(int pic_width, int pic_height, int frame) {
    }
}