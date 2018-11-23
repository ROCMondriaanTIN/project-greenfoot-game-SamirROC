import greenfoot.*;
public class Lifes extends Actor { 

    private int x;
    private int y;
    int lives = 3;
    public GreenfootImage life1f = new GreenfootImage("hud_heartFull.png");  
    public Lifes()
    {
        setImage(life1f);
    }
    public void act() 
    {
      getWorld().addObject(new Lifes(),40, 40);
    }
    public void countLives()
    {
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                setLocation(x, y);
                lives--;
                break;
    }
}
}
}
