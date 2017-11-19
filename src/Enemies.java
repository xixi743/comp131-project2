import java.awt.Color;
import java.awt.Graphics;

public class Enemies extends GraphicsObject {

    public Enemies(int x, int y) {
        super(x,y);
        this.speed_x = 5;
    }


    @Override
    public void draw (Graphics g) {
        g.setColor(new Color(19, 219, 43));
        g.fillRect(this.x, this.y, 20, 20);
    }

    //public void moveRight() {
        //this.x += 5;
    //}


    public void update(int pic_width, int pic_height, int frame) {
        if (this.x > pic_width) {
            this.speed_x = -5;
           this.y += 10;
        }
        else if (this.x < 0){
            this.speed_x = 5;
            this. y += 10;
        }

        super.update(pic_width, pic_height, frame);
    }
}