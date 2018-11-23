import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
public class Lifes extends Actor { 
    public GreenfootImage life1f = new GreenfootImage("hud_heartFull.png");  
    int lifes = 3;
    private int life;
    private int value;
    public Lifes()
    {
        setImage(life1f);
    }
    public void act()  {
    if (lifes == 0)
    {
        Greenfoot.stop();
    }
}
    }


