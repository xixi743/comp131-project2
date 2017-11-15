// utility
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

// graphics

// events
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// swing
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
Space invader requirements:
    the player must control a ship that moves left and right at the bottom of the screen
    the player must also be able to use the ship to fire projectiles at the enemy
    there must be a grid of aliens that move left and right, and that moves down towards the payer over time
    the aliens must randomly fire projectiles at the player
    if a player-fired projectile touches an alien, the alien must be removed
    if an alien-fired projectile touches the player, the player loses
    if an alien touches the player, the player loses
    if an alien gets past the bottom of the screen, the player loses
    if all aliens are destroyed the player wins
    there must be end screens when the player wins and loses
 */

public class SpaceInvaders extends JPanel implements ActionListener, KeyListener, Runnable {

    private final int canvasWidth;
    private final int canvasHeight;
    private final Color backgroundColor;

    private final int framesPerSecond = 25;
    private final int msPerFrame = 1000 / framesPerSecond;
    private Timer timer;
    private int frame = 0;
    private ArrayList<Shape> objects;
    private LosingEndScreen gameover;
    private UserSpaceship userspaceship;
    private Enemies enemies;

    // FIXME list your game objects here

    /* Constructor for a Space Invaders game
     */
    public SpaceInvaders() {
        // fix the window size and background color
        this.canvasWidth = 600;
        this.canvasHeight = 400;
        this.backgroundColor = Color.WHITE;
        setPreferredSize(new Dimension(this.canvasWidth, this.canvasHeight));
        this.objects = new ArrayList<Shape>();
        this.gameover = new LosingEndScreen(0, 0);
        this.userspaceship = new UserSpaceship(0, 0);
        this.enemies = new Enemies(0,0);


        // set the drawing timer
        this.timer = new Timer(msPerFrame, this);

        // FIXME initialize your game objects
    }

    /* Start the game
     */
    @Override
    public void run() {
        // show this window
        display();

        // set a timer to redraw the screen regularly
        this.timer.start();
    }

    /* Create the window and display it
     */
    private void display() {
        JFrame jframe = new JFrame();
        jframe.addKeyListener(this);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setContentPane(this);
        jframe.pack();
        jframe.setVisible(true);
    }

    /* Run all timer-based events
     *
     * @param e  An object describing the timer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // update the game objects
        update();
        // draw every object (this calls paintComponent)
        repaint(0, 0, this.canvasWidth, this.canvasHeight);
        // increment the frame counter
        this.frame++;
    }

    /* Paint/Draw the canvas.
     *
     * This function overrides the paint function in JPanel. This function is
     * automatically called when the panel is made visible.
     *
     * @param g The Graphics for the JPanel
     */
    @Override
    protected void paintComponent(Graphics g) {
        // clear the canvas before painting
        clearCanvas(g);
        if (hasWonGame()) {
            paintWinScreen(g);
        } else if (hasLostGame()) {
            paintLoseScreen(g);
        } else {
            paintGameScreen(g);
        }
    }

    /* Clear the canvas
     *
     * @param g The Graphics representing the canvas
     */
    private void clearCanvas(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(this.backgroundColor);
        g.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
        g.setColor(oldColor);
    }

    /* Respond to key release events
     *
     * A key release is when you let go of a key
     * 
     * @param e  An object describing what key was released
     */
    public void keyReleased(KeyEvent e) {
        // you can leave this function empty
    }

    /* Respond to key type events
     *
     * A key type is when you press then let go of a key
     * 
     * @param e  An object describing what key was typed
     */
    public void keyTyped(KeyEvent e) {
        // you can leave this function empty
    }

    /* Respond to key press events
     *
     * A key type is when you press then let go of a key
     * 
     * @param e  An object describing what key was typed
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // FIXME what happens when left arrow is pressed
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // FIXME what happens when right arrow is pressed
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            // FIXME what happens when space bar is pressed
        }
    }

    /* Update the game objects
     */
    private void update() {
        // FIXME update game objects here
    }

    /* Check if the player has lost the game
     * 
     * @returns  true if the player has lost, false otherwise
     */
    private boolean hasLostGame() {
        return false; // FIXME delete this when ready
    }

    /* Check if the player has won the game
     * 
     * @returns  true if the player has won, false otherwise
     */
    private boolean hasWonGame() {
        return false; // FIXME delete this when ready
    }

    /* Paint the screen during normal gameplay
     *
     * @param g The Graphics for the JPanel
     */
    private void paintGameScreen(Graphics g) {
        // FIXME draw game objects here
        this.userspaceship.draw(g);
        this.enemies.draw(g);
    }

    /* Paint the screen when the player has won
     *
     * @param g The Graphics for the JPanel
     */
    private void paintWinScreen(Graphics g) {
        // FIXME draw the win screen here
    }

    /* Paint the screen when the player has lost
     *
     * @param g The Graphics for the JPanel
     */
    private void paintLoseScreen(Graphics g) {
        // FIX ME
        this.gameover.draw(g);
        new LosingEndScreen(0,0);
        }

    public static void main(String[] args) {
        SpaceInvaders invaders = new SpaceInvaders();
        EventQueue.invokeLater(invaders);

    }
}
