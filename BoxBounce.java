import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class BoxBounce here.
 * 
 * @author Tyler Friedberg
 * @version 2016-October
 * 
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class BoxBounce
{
    // instance variables - replace the example below with your own
    private Canvas theCanvas;
    private ArrayList<BoxBall> balls;
    private Random rand;
    private int randX;
    private int randY;
    private int r;
    private int g;
    private int b;
    private int xPos;
    private int yPos;
    private int diameter;
    /**
     * Constructor for objects of class BoxBounce
     */
    public BoxBounce()
    {
        theCanvas = new Canvas("Box Demo", 600, 600);
        balls = new ArrayList<BoxBall>();
        rand = new Random();
        
    }
    
    public void bounce() {
        //establishes the boundaries that the ball can move inside
        int ground = 550;
        int ceiling = 50;
        int leftWall = 50;
        int rightWall = 550;
        
       
        
        theCanvas.setVisible(true);//makes the canvas visible
        
        for (int i = 0; i < 100; i++){ //establishes how many balls are being stored in the arraylist
            do {
                randX = rand.nextInt(21)-10;//randomizes x speed for each ball in arraylist
            }while(randX==0);
        
            do {
                randY = rand.nextInt(21)-10;//randomizes y speed for each ball in arraylist
            }while(randY==0);
            
            r = rand.nextInt(200);//random int between 0-200, passed as red value
            g = rand.nextInt(200);//random int between 0-200, passed as green value
            b = rand.nextInt(200);//random int between 0-200, passed as blue value
            
            do {
                xPos = rand.nextInt(rightWall-leftWall)+1+leftWall;//randomizes starting x position
            }while(xPos==0);
            
            do {
                yPos = rand.nextInt(ground-ceiling)+1+ceiling;//randomizes starting y position
            }while(yPos==0);
            
            do {
                diameter = rand.nextInt(35-5)+1+5;//randomizes diameter
            }while(diameter==0);
            
            /**
             * Adds new balls to the ArrayList with all of the randomly generated variables
             * random color produced by the new Color() constructor
             */
            balls.add(new BoxBall(xPos, yPos, diameter, new Color(r, g, b), ground, ceiling, leftWall, 
                                  rightWall, theCanvas, randX, randY));
        }
        
        /**
         * While loop makes it so the balls don't stop bouncing, as condition true is never changed
         * for loop sets all balls to move
         */
        while(true) {
            for(BoxBall b : balls) {
                b.move(); //begins movement of ball for duration of the loop
            }
            theCanvas.wait(50);
            
            /**
             * draws the lines of the boundaries
             * redraws lines if "chipped away"
             */
            theCanvas.drawLine(50, ground, 550, ground);
            theCanvas.drawLine(50, ceiling, 550, ceiling);
            theCanvas.drawLine(leftWall, 50, leftWall, 550);
            theCanvas.drawLine(rightWall, 50, rightWall, 550);
        }
    }
}

