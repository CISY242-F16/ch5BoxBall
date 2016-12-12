import java.awt.*;
import java.awt.geom.*;

/**
 * Class Ball - class to store the color, diameter, x position, y position, horizontal, and vertical
 * speeds of a ball.  These fiels will be used in another class to graphically display the ball
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Dana Sabatino
 *
 * @version 2016.10.31
 */

public class Ball
{
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private int ySpeed;
    private int xSpeed;
    private int leftX;
    private int rightX;
    private int topY;
    private int bottomY;

    /**
     * Constructor for objects of class Ball
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param speedX the starting horizontal speed of the ball
     * @param speedY the starting vertical speed of the ball
     */
    public Ball(int xPos, int yPos, int ballDiameter, Color ballColor, int speedX, int speedY)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        xSpeed = speedX;
        ySpeed = speedY;
        leftX = xPosition - (diameter/2);
        rightX = xPosition + (diameter/2);
        topY = yPosition - (diameter/2);
        bottomY = yPosition + (diameter/2);
    } 

    /** 
     * returns Color of ball
     */
    public Color getColor()
    {
        return color;
    }
    
    /**
     * returns the diameter of ball
     */
    public int getDiameter()
    {
        return diameter;
    }
    
    /**
     * returns horizontal speed of ball
     */
    public int getXSpeed()
    {
        return xSpeed;
    }
    
    /**
     * mutator for private field xSpeed
     * 
     * @param speedX changes private field xSpeed to the value of parameter speedX
     */
    public void changeXSpeed(int speedX)
    {
        xSpeed = speedX;
    }
    
    /**
     * returns vertical speed of ball
     */
    public int getYSpeed()
    {
        return ySpeed;
    }
    
    /**
     * mutator for private field ySpeed
     * 
     * @param speedX changes private field ySpeed to the value of parameter speedY
     */
    public void changeYSpeed(int speedY)
    {
        ySpeed = speedY;
    }
    
    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * mutator for private field xPosition
     * 
     * @param xPos changes private field xPosition to the value of parameter xPos
     */
    public void changeXPos(int xPos)
    {
        xPosition = xPos;
        leftX = xPosition - (diameter/2);
        rightX = xPosition + (diameter/2);
    }
    
    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }

    /**
     * mutator for private field yPosition
     * 
     * @param yPos changes private field yPosition to the value of parameter yPos
     */
    public void changeYPos(int yPos)
    {
        yPosition = yPos;
        topY = yPosition - (diameter/2);
        bottomY = yPosition + (diameter/2);
    }
    
    /**
     * accessor for private field leftX
     */
    public int getLeftX()
    {
        return leftX;
    }
    
     /**
     * accessor for private field rightX
     */
    public int getRightX()
    {
        return rightX;
    }
    
     /**
     * accessor for private field topY
     */
    public int getTopY()
    {
        return topY;
    }
    
     /**
     * accessor for private field bottomY
     */
    public int getBottomY()
    {
        return bottomY;
    }
}

