import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class BoxBall here.
 * 
 * @author Tyler Friedberg 
 * @version October-2016
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2011.07.31
 */
public class BoxBall
{ private static final int GRAVITY = 1;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;// y position of ground
    private final int ceilingPosition;//y position of ceiling
    private final int leftWallPosition;//x position of left wall
    private final int rightWallPosition;//x position of right wall
    private Canvas canvas;
    private int xSpeed;//I couldn't figure out how to randomize the xSpeed without weird stuff happening
    private int ySpeed;//I couldn't figure out how to randomize the ySpeed without weird stuff happening

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param ceilingPos  the position of the ceiling
     * @param leftPos  the position of the left wall
     * @param rightPos  the position of the right wall
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, int ceilingPos, int leftPos, int rightPos, Canvas drawingCanvas,
                        int horSpeed, int verSpeed)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        ceilingPosition = ceilingPos;
        leftWallPosition = leftPos;
        rightWallPosition = rightPos;
        canvas = drawingCanvas;
        xSpeed = horSpeed;
        ySpeed = verSpeed;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        //ySpeed+= GRAVITY;
        //xSpeed+= GRAVITY;
        yPosition += ySpeed;
        xPosition += xSpeed;

        //conditional statement to check if it has hit the ground, walls, or ceiling
       if(yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = (groundPosition - diameter);
            ySpeed = -ySpeed;//if the ball has hit ground reverse ySpeed
        }
        
        else if (yPosition <= (ceilingPosition) && ySpeed < 0){
            yPosition = ceilingPosition;
            ySpeed = -ySpeed;//if the ball has hit the ground, reverse ySpeed
        }
        
        else if(xPosition <= (leftWallPosition) && xSpeed < 0) {
           xPosition = leftWallPosition;
           xSpeed = -xSpeed;//if the ball has hit left wall reverse xSpeed
        }
        
        else if(xPosition >= (rightWallPosition - diameter) && xSpeed > 0) {
            xPosition = (rightWallPosition - diameter);
            xSpeed = -xSpeed;//if the ball has hit right wall reverse xSpeed
        }
        else {  //if none of those things happened, keep the x and y speed the same
            ySpeed = ySpeed;
            xSpeed = xSpeed;
            yPosition = yPosition;
            xPosition = xPosition;
        }

        // draw again at new position
        draw();
    }
    
    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
   
}
