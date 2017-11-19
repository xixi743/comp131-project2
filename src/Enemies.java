import java.awt.Color;
import java.awt.Graphics;

public class Enemies extends GraphicsObject {


    public Enemies(int x, int y) {
        super(x,y);
        this.speed_x = 5;
        this.speed_y = 20;
    }

    @Override
    public void draw (Graphics g) {
        g.setColor(new Color(59, 229, 96));
        g.fillRect(this.x, this.y, 20, 20);
    }

    public void update(int pic_width, int pic_height, int frame) {

        this.x += this.speed_x;


        if (this.x < 0 || this.x + 20 > pic_width) {
            this.speed_x = -(this.speed_x);
            this.y += this.speed_y;

        }

    }
}