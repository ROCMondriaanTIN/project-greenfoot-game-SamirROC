import greenfoot.*;
import greenfoot.Color; 

   public class ScoreCounter extends Actor {
        
    int score = 0;
    public void act() 
    {
        setImage(new GreenfootImage("Score : " + score, 30, Color.RED, new Color(0,0,0,0)));
    }    
     
    public void addScore()
    {
        score++;
    }
}
    