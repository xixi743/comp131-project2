import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GraphicsObject {

    public Projectile(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw (Graphics g) {
        g.setColor(new Color(19, 219, 43));
        g.fillRect((x + 8 ), (y + 21), 5, 8);
    }

    //overriding with this.y change
    public void update(int pic_width, int pic_height, int frame) {
        this.y -= 5;
    }
    public boolean check(){
        if (this.y < -8){
            return true;
        }
        else{
            return false;
        }
    }
}

