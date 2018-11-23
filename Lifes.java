import greenfoot.*;
public class Lifes extends Actor { 
    public GreenfootImage life1f = new GreenfootImage("hud_heartFull.png");  
    int lifes = 3;
    public Lifes()
    {
        setImage(life1f);
    }
    public void act() 
    {
   if (isTouching(Enemy.class)){
    lifes--;
}
    if (lifes == 0)
    {
        Greenfoot.stop();
    }
}
    }


