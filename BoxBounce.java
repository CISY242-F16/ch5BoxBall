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
        
        //draws the lines of the boundaries
        /*theCanvas.drawLine(50, ground, 550, ground);
        theCanvas.drawLine(50, ceiling, 550, ceiling);
        theCanvas.drawLine(leftWall, 50, leftWall, 550);
        theCanvas.drawLine(rightWall, 50, rightWall, 550);*/
        
        theCanvas.setVisible(true);//makes the canvas visible
        for (int i = 0; i < 50; i++){
            do {
                randX = rand.nextInt(21)-10;
            }while(randX==0);
        
            do {
                randY = rand.nextInt(21)-10;
            }while(randY==0);
            
            r = rand.nextInt(200);
            g = rand.nextInt(200);
            b = rand.nextInt(200);
            
            do {
                xPos = rand.nextInt(rightWall-leftWall)+1+leftWall;
            }while(xPos==0);
            
            do {
                yPos = rand.nextInt(ground-ceiling)+1+ceiling;
            }while(yPos==0);
            
            do {
                diameter = rand.nextInt(35-5)+1+5;
            }while(diameter==0);
            
            balls.add(new BoxBall(xPos, yPos, diameter, new Color(r, g, b), ground, ceiling, leftWall, 
                                  rightWall, theCanvas, randX, randY));
        }
        
        /**
         * I could think of a way to use a while loop so I used a for loop which gives it a set run time that
         * can be increased or decreased by changing whatever "i" is less than
         */
        while(true) {
            for(BoxBall b : balls) {
                b.move(); //begins movement of ball for duration of the loop
            }
            theCanvas.wait(50);
            theCanvas.drawLine(50, ground, 550, ground);
            theCanvas.drawLine(50, ceiling, 550, ceiling);
            theCanvas.drawLine(leftWall, 50, leftWall, 550);
            theCanvas.drawLine(rightWall, 50, rightWall, 550);
        }
    }
}

