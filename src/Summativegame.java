
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author manok5757
 */
public class Summativegame extends JComponent implements KeyListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // create a variable to move the cannon up 
    boolean moveUp = false;
    //create a variable to move the cannon down
    boolean moveDown = false;
    // create speed when moving up
    int upSpeed = -15;
    // create speed when moving down
    int downSpeed = 15;
    // create boolean to see if game starts
    boolean begin = false;

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        // set a colour for the background
        g.setColor(Color.BLACK);
        // draw the background of the game and leave a gap for the floor
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // set a colour for the floor
        g.setColor(Color.BLUE);
        // draw the floor
        g.fillRect(0, 572, WIDTH, 28);
        // set the colour of the cannon'
        g.setColor(Color.red);
        // create a cannon barrel
        g.fillRect(6, 542, 75, 30);
        // set the colour of the wheel of the cannon
        g.setColor(Color.GREEN);
        // create the wheel of the barrel
        g.fillArc(10, 522, 50, 50, 360, 360);

        // GAME DRAWING ENDS HERE
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            if (moveUp || moveDown) {
                
            }


            // GAME LOGIC ENDS HERE 

            // update the drawing (calls paintComponent)
            repaint();



            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        Summativegame game = new Summativegame();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // starts my game loop
        game.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_DOWN) {
            begin = true;
            moveDown = true;
        }
        if (key == KeyEvent.VK_UP){
        moveUp = true;
        begin = true;
    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }
}