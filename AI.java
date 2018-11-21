import greenfoot.*;
public class AI  extends Mover {
    
    public GreenfootImage fly1f = new GreenfootImage("flyFly1+.png");
    public GreenfootImage fly2f = new GreenfootImage("flyFly2.png");
    private int x;
    private int y;
    
    public AI()
    {
        setImage(fly1f);
    }
    
   public void act() {
        applyVelocity();  
    }
}
