import greenfoot.*;
public class AI  extends Mover {
    
    public GreenfootImage fly1f = new GreenfootImage("fly1g.png");
    public GreenfootImage fly2f = new GreenfootImage("flyg2.png");
    private int x;
    private int y;
    private int xMin = 500;
    private int xMax = 500;
    private double speed;
    private int walkRange;
    private boolean firstAct;
    
    public AI()
    {
        setImage(fly1f);
        velocityY = -1;
        walkRange = 800;
        firstAct = true;
        speed = 1.5;
    }
    
    public void flyMove() {
   if (getImage().equals(fly1f)) 
     {  
       setImage (fly2f);  
     }
     else 
     {  
       setImage (fly1f);   
     }
}
    
   public void act() {
        velocityX = speed;
        applyVelocity();
        int x = getX();
        int y = getY();

        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }
        if (getX() >= xMax) {
            speed *= -1;
            x = xMax;
        } else if (getX() <= xMin) {
            speed *= -1;
            x = xMin;
        }
        flyMove();
    }
}


