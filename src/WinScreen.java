import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class WinScreen extends GraphicsObject {

    public WinScreen(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(0,0,600,400);

        g.setColor(new Color(255, 64, 64));
        g.fillRect(160, 60, 40, 40);
        g.setColor(Color.black);
        g.fillRect(200, 60, 40, 40);
        g.setColor(new Color(255, 64, 64));
        g.fillRect(160, 100, 40, 40);
        g.fillRect(200, 100, 40, 40);
        g.fillRect(360, 60, 40, 40);
        g.fillRect(400, 60, 40, 40);
        g.setColor(Color.black);
        g.fillRect(360, 100, 40, 40);
        g.setColor(new Color(255, 64, 64));
        g.fillRect(400, 100, 40, 40);





        g.setColor(Color.white);
        g.fillRect(150, 260, 300, 40);
        g.setColor(Color.black);
        g.fillRect(170, 300, 260, 40);
        g.setColor(Color.red);
        g.fillRect(300, 310, 80, 30);
        g.setColor(Color.white);
        g.fillRect(190, 340, 220, 40);





    }
}