import java.awt.Color;
import java.awt.Graphics;

public class UserSpaceship extends GraphicsObject {

    public UserSpaceship(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw (Graphics g) {
        g.setColor(Color.white);
        g.fillRect(this.x, this.y, 20, 20);
    }
    public void update(int pic_width, int pic_height, int frame) {
        x %= pic_width + 1; // the + 1 is so you get numbers from 0 to screenW
        y %= pic_height + 1;
/* Below is correction for negative numbers
 * (as -10 % 3 = -1 in java, whereas you want the result to be 2)
 */
        if (x < 0)
            x += pic_width;
        if (y < 0)
            y += pic_height;




        super.update(pic_width, pic_height, frame);
    }
}