// utility

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

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
    private LosingEndScreen gameOver;
    private UserSpaceship userspaceship;
    private ArrayList<Projectile> shots;
    private ArrayList<Projectile> Enemyshots;
    private ArrayList<Enemies> badGuys;
    private WinScreen youWin;


    // FIXME list your game objects here

    /* Constructor for a Space Invaders game
     */
    public SpaceInvaders() {
        // fix the window size and background color
        this.canvasWidth = 600;
        this.canvasHeight = 400;
        this.backgroundColor = Color.pink;
        setPreferredSize(new Dimension(this.canvasWidth, this.canvasHeight));
        this.objects = new ArrayList<Shape>();
        this.gameOver = new LosingEndScreen(0, 0);
        this.youWin = new WinScreen(0, 0);
        this.userspaceship = new UserSpaceship(280, 380);
        this.shots = new ArrayList<Projectile>();
        this.Enemyshots = new ArrayList<Projectile>();
        this.badGuys = new ArrayList<Enemies>();
        for (int column = 0; column < 10; column++) {
            for (int row = 0; row < 4; row++) {
                this.badGuys.add(new Enemies(55 * column + 30, 50 * row + 25));
            }
        }


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
            this.userspaceship.x -= 10;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.userspaceship.x += 10;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.shots.add(new Projectile(this.userspaceship.x, this.userspaceship.y - 21, 5, Color.black));
        }
    }

    /* Update the game objects
     */
    private void update() {
        this.userspaceship.update(this.canvasWidth, this.canvasHeight, this.frame);
        for (int i = 0; i < this.shots.size(); i += 1) {
            Projectile projectile = this.shots.get(i);
            projectile.update(this.canvasWidth, this.canvasHeight, this.frame);
            if (projectile.check() == true) {
                this.shots.remove(i);
            }
        }

        for (int i = 0; i < this.Enemyshots.size(); i += 1){
            Projectile projectile = this.Enemyshots.get(i);
            projectile.update(this.canvasWidth, this.canvasHeight, this.frame);
            if(projectile.check()){
                this.Enemyshots.remove(i);
            }

        }

        for (Enemies enemies : this.badGuys) {
            Random randy = new Random();
            if (randy.nextInt(400) == 3){
                this.Enemyshots.add(new Projectile(enemies.x, enemies.y + 21, -5, Color.white));
            }
            enemies.update(this.canvasWidth, this.canvasHeight, this.frame);
        }
        destroyEnemy();
        // FIXME update game objects here
    }


    private void destroyEnemy() {
        for (int projectileIndex = 0; projectileIndex < this.shots.size(); projectileIndex++) {
            Projectile projectile = this.shots.get(projectileIndex);
            for (int badGuyIndex = 0; badGuyIndex < this.badGuys.size(); badGuyIndex++) {
                Enemies enemy = this.badGuys.get(badGuyIndex);

                Rectangle EnemyHitBox = new Rectangle(enemy.x, enemy.y, 22, 22);
                Rectangle ShotHitBox = new Rectangle(projectile.x, projectile.y, 7, 10);
                if (EnemyHitBox.intersects(ShotHitBox)){
                    this.badGuys.remove(badGuyIndex);
                    this.shots.get(projectileIndex).x = - 40;
                }
            }
        }
    }

    /* Check if the player has lost the game
     *
     * @returns  true if the player has lost, false otherwise
     */
    private boolean hasLostGame() {
        for (Enemies enemies : this.badGuys) {
            if (enemies.y < 0 || enemies.y + 20 > canvasHeight) {
                return true;
            }
        }
        for (int projectileIndex = 0; projectileIndex < this.Enemyshots.size(); projectileIndex++) {
            Projectile projectile = this.Enemyshots.get(projectileIndex);

            Rectangle UserHitBox = new Rectangle(this.userspaceship.x, this.userspaceship.y, 22, 22);
            Rectangle ShotHitBox = new Rectangle(projectile.x, projectile.y, 7, 10);
            if (UserHitBox.intersects(ShotHitBox)) {
                projectile.y_speed = 0;
                return true;
            }
        }
        for (int badGuyIndex = 0; badGuyIndex < this.badGuys.size(); badGuyIndex++) {
            Enemies enemy = this.badGuys.get(badGuyIndex);

            Rectangle UserHitBox = new Rectangle(this.userspaceship.x, this.userspaceship.y, 20, 20);
            Rectangle EnemyHitBox = new Rectangle(enemy.x, enemy.y, 20, 20);

            if (UserHitBox.intersects(EnemyHitBox)){
                enemy.speed_x = 0;
                return true;
            }


        }


        return false;

    }

    /* Check if the player has won the game
     *
     * @returns  true if the player has won, false otherwise
     */
    private boolean hasWonGame() {
        if(badGuys.size() == 0){
            return true;
        }
        return false;
    }

    /* Paint the screen during normal gameplay
     *
     * @param g The Graphics for the JPanel
     */

    private void paintGameScreen(Graphics g) {
        this.userspaceship.draw(g);
        for (Projectile projectiles : this.shots) {
            projectiles.draw(g);
        }
        for (Projectile projectiles : this.Enemyshots){
            projectiles.draw(g);
        }
        for (Enemies enemies : this.badGuys) {
            enemies.draw(g);
        }
        // FIXME draw game objects here
    }

    /* Paint the screen when the player has won
     *
     * @param g The Graphics for the JPanel
     */
    private void paintWinScreen(Graphics g) {
        // FIXME draw the win screen here
        this.youWin.draw(g);
        new WinScreen(0,0);
    }

    /* Paint the screen when the player has lost
     *
     * @param g The Graphics for the JPanel
     */
    private void paintLoseScreen(Graphics g) {
        // FIX ME
        this.gameOver.draw(g);
        new LosingEndScreen(0, 0);
    }

    public static void main(String[] args) {
        SpaceInvaders invaders = new SpaceInvaders();
        EventQueue.invokeLater(invaders);

    }
}
