import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GraphicsObject {
    int y_speed;
    Color color;

    public Projectile(int x, int y, int speed, Color color) {
        super(x,y);
        this.y_speed = speed;
        this.color = color;
    }

    @Override
    public void draw (Graphics g) {
        g.setColor(this.color);
        g.fillRect((x + 8 ), (y + 21), 5, 8);
    }

    //overriding with this.y change
    public void update(int pic_width, int pic_height, int frame) {
        this.y -= this. y_speed;
    }
    public boolean check(){
        if ((this.y < -8) || (this.y > 600)){
            return true;
        }
        else{
            return false;
        }
    }
}

