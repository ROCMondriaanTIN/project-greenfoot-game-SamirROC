
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Enemy2 extends Mover {

    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed; 
    private int status;
    private int walkStatus = 1;
              
     public Enemy2() {
        super();
        setImage("blockerMad.png");
        getImage().mirrorHorizontally();
        walkRange = 140;
        firstAct = true;
        speed = 2;
    }
   
    public void act() {
        int x = getX();
        int y = getY();
       
        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }
        velocityX = speed;
        applyVelocity();
        if (getX() >= xMax) {
                speed *= -1;
                x = xMax;
                
            } else if (getX() <= xMin) {
                speed *= -1;
                x = xMin;

            }
            
   }
}
