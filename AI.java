import greenfoot.*;
public class AI  extends Mover {
    
    public GreenfootImage fly1f = new GreenfootImage("flyg1.png");
    public GreenfootImage fly2f = new GreenfootImage("flyg2.png");
    private int x = 112;
    private int y = 5175;
    private int xMin = 500;
    private int xMax = 500;
    private int speed;
    private int walkRange;
    private boolean firstAct;
    private String direction = "left";
    
    public AI()
    {
        setImage(fly1f);
        velocityY = -2;
        getImage().mirrorHorizontally();
        fly2f.mirrorHorizontally();
        walkRange = 500;
        firstAct = true;
        speed = 5;
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
        if(getY() <= 5282) {
            if (getY() > 5175){
             getImage().mirrorHorizontally();
            }
             setLocation(112, 5175);
             setImage(fly1f);
        }else{   
        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }
        if (getX() >= xMax) {
            speed *= -1;
            x = xMax;
            fly2f.mirrorHorizontally();
            fly1f.mirrorHorizontally();
        } else if (getX() <= xMin) {
            speed *= -1;
            x = xMin;
            fly2f.mirrorHorizontally();
            fly1f.mirrorHorizontally();
        }
        flyMove();
    }
}
}