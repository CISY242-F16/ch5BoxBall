import java.awt.Color;
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
    private int xSpeed = 50;
    private int ySpeed = 50;
    /**
     * Constructor for objects of class BoxBounce
     */
    public BoxBounce()
    {
        theCanvas = new Canvas("Box Demo", 600, 600);   
    }
    
    public void bounce() {
        //establishes the boundaries that the ball can move inside
        int ground = 550;
        int ceiling = 50;
        int leftWall = 50;
        int rightWall = 550;
        
        //draws the lines of the boundaries
        theCanvas.drawLine(50, ground, 550, ground);
        theCanvas.drawLine(50, ceiling, 550, ceiling);
        theCanvas.drawLine(leftWall, 50, leftWall, 550);
        theCanvas.drawLine(rightWall, 50, rightWall, 550);
        
        theCanvas.setVisible(true);//makes the canvas visible
        
        //creates a new box ball
        BoxBall ball = new BoxBall (50, 50, 15, Color.BLUE, ground, ceiling, leftWall, rightWall, theCanvas);
        ball.draw();
        
        //creates a new box ball
        BoxBall ball2 = new BoxBall (90, 70, 23, Color.RED, ground, ceiling, leftWall, rightWall, theCanvas);
        ball2.draw();
        
        /**
         * I could think of a way to use a while loop so I used a for loop which gives it a set run time that
         * can be increased or decreased by changing whatever "i" is less than
         */for(int i = 0; i < 100; i++) {
            theCanvas.wait(50);
            ball.move(); //begins movement of ball for duration of the loop
            ball2.move();//begins movement of ball2 for duration of the loop
        }
            
            
        }
    }

