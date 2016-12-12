import java.awt.Color;
import java.util.Random;
 
 
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class of 5 to 50 balls bouncing off each other and the four walls. 
 *
 * @author Bill Crosbie
 * @author Dana Sabatino
 * @version 2016.12.11
 *
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private BoxBall myBoxBall;
    private Random rand;
    private int maxX;
    private int maxY;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        rand = new Random();
        maxX = 600;
        maxY = 500;
       BoxBounce((5+ rand.nextInt(46)), 600, 500);
    }
    
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     * 
     * @param balls the number of balls to be created in the box to bounce off each other
     * @param xWidth the maximum width of the canvas
     * @param yHeight the maximum height of the canvas
     */
    public BallDemo(int balls, int xWidth, int yHeight)
    {
        myCanvas = new Canvas("Ball Demo", xWidth, yHeight);
        rand = new Random();
        maxX = xWidth;
        maxY = yHeight;
        BoxBounce(balls, xWidth, yHeight);
    }

   /**
    * method to simulated bouncing and moving balls inside a box with four walls
    * 
    * @param balls the number of balls contained in the box
    * @param xWidth the width of the canvas
    * @param yHeight the height of the canvas
    */
   public void BoxBounce(int balls, int xWidth, int yHeight)
   {
       int numBalls = 0;
       if (balls < 51 && balls > 4)
       {
           numBalls = balls;
       }
       else
       {
           numBalls = 5 + rand.nextInt(46);
       }
       myBoxBall = new BoxBall(myCanvas, (yHeight - 50), 50, 50, (xWidth - 50), numBalls);
       myCanvas.setVisible(true);
       for(int i = 0; i < 10000; i++)
       {
            myCanvas.setForegroundColor(Color.black);
            myCanvas.drawLine(50, 50, 50, (maxY - 50));
            myCanvas.drawLine(50, 50, (maxX - 50), 50);
            myCanvas.drawLine((maxX- 50), 50, (maxX - 50), (maxY - 50));
            myCanvas.drawLine(50, (maxY - 50), (maxX - 50), (maxY - 50));
           myBoxBall.move();
           myCanvas.wait(50);
       }
    }
}