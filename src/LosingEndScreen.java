import java.awt.Color;
import java.awt.Graphics;

public class LosingEndScreen extends GraphicsObject {

    public LosingEndScreen (int x, int y) {
        super(x,y);
    }

    @Override
    public void draw (Graphics g) {
        //background
        g.setColor(new Color(0,0,0));
        g.fillRect(0,0,600,400);

        //GAME OVER
        //the letter G
        g.setColor(new Color(59, 229, 96));
        g.fillRect(97, 81, 81, 16); //section 1
        g.fillRect(97, 81, 16, 32); //section 2
        g.fillRect(81, 97, 32, 16); //section 3
        g.fillRect(65, 113, 32, 49); //section 4
        g.fillRect(81, 162, 32, 16); //section 5
        g.fillRect(97, 178, 80, 16); //section 6
        g.fillRect(145, 130, 32, 49); //section 7
        g.fillRect(130, 130, 16, 16); //section 8

        //the letter A
        g.fillRect(194, 113, 32, 81); //section 1
        g.fillRect(276, 113, 32, 81); //section 2
        g.fillRect(220, 146, 56, 16); //section 3
        g.fillRect(211, 97, 32, 16); //section 4
        g.fillRect(227, 81, 49, 16); //section 5
        g.fillRect(259, 97, 32, 16); //section 6

        //the letter M
        g.fillRect(324, 81, 32, 113); //section 1
        g.fillRect(405, 81, 32, 113); //section 2
        g.fillRect(350, 113, 56, 32); //section 3
        g.fillRect(350, 97, 23, 16); //section 4
        g.fillRect(389, 97, 16, 16); //section 5
        g.fillRect(373, 141, 16, 21); //section 6

        //the letter E
        g.fillRect(454, 81, 32, 113); //section 1
        g.fillRect(486, 81, 81, 16); //section 2
        g.fillRect(486, 130, 65, 16); //section 3
        g.fillRect(486, 178, 81, 16); //section 4

        //the letter O
        g.fillRect(81, 210, 81, 16); //section 1
        g.fillRect(81, 308, 81, 16); //section 2
        g.fillRect(65, 226, 32, 82); //section 3
        g.fillRect(146, 226, 32, 82); //section 4

        //the letter V
        g.fillRect(194, 210, 33, 66); //section 1
        g.fillRect(276, 210, 32, 66); //section 2
        g.fillRect(211, 276, 16, 16); //section 3
        g.fillRect(227, 292, 16, 16); //section 4
        g.fillRect(243, 308, 16, 16); //section 5
        g.fillRect(259, 292, 16, 16); //section 6
        g.fillRect(276, 276, 16, 16); //section 7

        //the letter E
        g.fillRect(324, 210, 32, 114); //section 1
        g.fillRect(356, 210, 82, 16); //section 2
        g.fillRect(356, 259, 66, 16); //section 3
        g.fillRect(356, 308, 82, 16); //section 4

        //the letter R
        g.fillRect(454, 210, 32, 113); //section 1
        g.fillRect(486, 210, 65, 16); //section 2
        g.fillRect(535, 226, 32, 50); //section 3
        g.fillRect(486, 276, 49, 16); //section 4
        g.fillRect(519, 259, 16, 17); //section 5
        g.fillRect(503, 292, 49, 16); //section 6
        g.fillRect(519, 308, 49, 16); //section 7
    }
}
