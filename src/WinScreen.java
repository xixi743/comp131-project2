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

        //YOU WIN
        ImageIcon image = new ImageIcon("image/YouWin.jpg");
        JLabel label = new JLabel();
        label.setBounds(0, 0, x, y);
        label.setIcon(image);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(label);
    }
}