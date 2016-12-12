import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BoxBall - a graphical ArrayList of Ball objects that observes the effect of bouncing off 4 wall and each other. 
 * The ball has the ability to move. 
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Dana Sabatino
 *
 * @version 2016.10.31
 */

public class BoxBall
{
    private Random rand;
    private final int numBalls;
    private final int bottomWall;
    private final int topWall;
    private final int leftWall;
    private final int rightWall;
    private Canvas canvas;
    private ArrayList<Ball> ballList;                // initial downward speed

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param bottomPos  position of bottom wall
     * @param topPos position of top wall
     * @param leftPos position of left wall
     * @param rightPos positon of right wall
     * @param totalBalls number of balls in arrayList<Ball> ballList
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(Canvas drawingCanvas, int bottomPos, int topPos, int leftPos, int rightPos,
                        int totalBalls)
    {
       rand = new Random();
       ballList = new ArrayList<Ball>();
       bottomWall = bottomPos;
       topWall = topPos;
       leftWall = leftPos;
       rightWall = rightPos;
       canvas = drawingCanvas;
       numBalls = getNumBalls(totalBalls);
       initiateBallList();
    }

    /** 
     * returns a number of balls between 5 and 50
     * 
     * @param totalBalls    if totalBalls is not inbetween 5 and 50 than a random number
     *                      between 5 and 50 is returned, other wise totalBalls is returned
     */
    public int getNumBalls(int totalBalls)
    {
        if(totalBalls > 4 && totalBalls < 51)
        {
            return totalBalls;
        }
        else
        {
            return (5 + rand.nextInt(46));
        }
    }
   
    
    /**
     * fills arrayList of Balls with Ball objects with random x and y starting postions, color, diameter, and horizontal and vertical ball speeds.
     */
    public void initiateBallList()
    {
        int xPos = -1;
        int yPos = -1;
        int ballDiameter = -1;
        int speedX = 0;
        int speedY = 0;
        int red = 0;
        int green = 0;
        int blue = 0;
        for (int index = 0; index < numBalls; index++)
        {
            xPos = leftWall + rand.nextInt((rightWall-leftWall) + 1);
            yPos = topWall + rand.nextInt((bottomWall-topWall) + 1);
            ballDiameter = 1 + rand.nextInt(15);
            while (isOnTopOfAnother(index, xPos, yPos))
            {
                xPos = leftWall + rand.nextInt((rightWall-leftWall) + 1);
                yPos = topWall + rand.nextInt((bottomWall-topWall) + 1);
            }
            while ((xPos < leftWall) || ((xPos + ballDiameter) > rightWall))
            {
               xPos = leftWall + rand.nextInt((rightWall-leftWall) + 1);
            }
            while ((yPos < topWall) || ((yPos + ballDiameter) > bottomWall))
            {
              yPos = topWall + rand.nextInt((bottomWall-topWall) + 1);
            }
            speedX = rand.nextInt(15) - 7;
            speedY = rand.nextInt(15) - 7;
            red = rand.nextInt(256);
            green = rand.nextInt(256);
            blue = rand.nextInt(256);
            while(speedX == 0)
            {
                speedX = rand.nextInt(15) - 7;
            }
            while(speedY == 0)
            {
                speedY = rand.nextInt(15) - 7;
            }
            Color ballColor = new Color(red, green, blue);
            Ball newBall = new Ball(xPos, yPos, ballDiameter, ballColor, speedX, speedY);
            ballList.add(newBall);
        }
        drawList();
    }
    
   
    /**
     * returns whether a ball object rests in the space an alreday created ball object occupies
     * 
     * @param index  the element ballList is currently initiallizing
     * @param xPos the horizontal position of ball to see if it is available
     * @param yPos the verticle position of ball to see if it is availiable
     * 
     * @return whether the xPos and yPos are available to draw a ball in that sapce on the canvas
     */
    public boolean isOnTopOfAnother(int index, int xPos, int yPos)
    {
        for (int i = 0; i < index; i++)
        {
            if((xPos > ballList.get(i).getLeftX()) && (xPos < ballList.get(i).getRightX()) && (yPos > ballList.get(i).getTopY()) && (yPos < ballList.get(i).getBottomY()))
            {
                return true;
            }
        }
        return false;
    }
    
     /**
     * returns whether a ball object rests in the space an alreday created ball object occupies
     * 
     * @param list the arrayList of Balls to get their locations to be compared to 
     * @param index  the element ballList is currently initiallizing
     * @param xPos the horizontal position of ball to see if it is available
     * @param yPos the verticle position of ball to see if it is availiable
     * 
     * @return whether the xPos and yPos are available to draw a ball in that sapce on the canvas
     */
    public boolean isOnTopOfAnother(ArrayList<Ball> list, int index, int xPos, int yPos)
    {
        for (int i = 0; i < index; i++)
        {
            if((xPos > list.get(i).getLeftX()) && (xPos < list.get(i).getRightX()) && (yPos > list.get(i).getTopY()) && (yPos < list.get(i).getBottomY()))
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Draw this arrayLis of Ball objects at their current positions onto the canvas.
     **/
    public void drawList()
    {
        for(int index = 0; index < numBalls; index++)
        {
            canvas.setForegroundColor(ballList.get(index).getColor());
            canvas.fillCircle(ballList.get(index).getXPosition(), ballList.get(index).getYPosition(), ballList.get(index).getDiameter());
        }
    }
    
    /**
     * Erase this arrayList of Ball objects at their current positions.
     **/
    public void erase()
    {
        for(int index = 0; index < numBalls; index++)
        {
            canvas.eraseCircle(ballList.get(index).getXPosition(), ballList.get(index).getYPosition(), ballList.get(index).getDiameter());
        }

    }    

    /**
     * Move all the Ball objects in arrayList ballList according to their positions and speeds and redraws them.
     **/
    public void move()
    {
        erase();
        
        int newXPos = -1;
        int newYPos = -1;
        int newXDir = 0;
        int newYDir = 0;
        ArrayList <Ball> newBallList = new ArrayList<Ball>();
        for(int index = 0; index < numBalls; index++)
        {
            newXDir = ballList.get(index).getXSpeed();
            newYDir = ballList.get(index).getYSpeed();
            newXPos = ballList.get(index).getXPosition() + newXDir;
            newYPos = ballList.get(index).getYPosition() + newYDir;
            if(isOnTopOfAnother(newBallList, index, newXPos, newYPos))
            {
                newXDir = (-1)*newXDir;
                newXPos = newXPos + newXDir;
                newYDir = (-1)*newYDir;
                newXPos = newYPos + newYDir;
            }
            if ((newXPos < leftWall) || ((newXPos + ballList.get(index).getDiameter()) > rightWall))
            {
                newXDir = (-1)*newXDir;
                newXPos = newXPos + newXDir;
            }
            if ((newYPos < topWall) || ((newYPos + ballList.get(index).getDiameter()) > bottomWall))
            {
                newYDir = (-1)*newYDir;
                newYPos = newYPos + newYDir;
            }
            Ball newBall = new Ball(newXPos, newYPos, ballList.get(index).getDiameter(), ballList.get(index).getColor(), newXDir, newYDir);
            newBallList.add(newBall);
        }
        ballList = new ArrayList<Ball>(newBallList);
        drawList();
    }
                

  
}
