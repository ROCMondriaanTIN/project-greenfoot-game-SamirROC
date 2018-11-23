import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Overlay extends Actor
{
    Lifes[] lives = new Lifes[3];
    
    public Overlay(){
        for (int i = 0 ; i < lives.length; i++){
            lives[i] = new Lifes();
        }
    }
    
    public void act() 
    {
        if (isTouching(Enemy.class)){
            getWorld().removeObject(lives[0]);
        }
        for(int i = 0 ; i < lives.length; i++) {
            getWorld().addObject (new Lifes(), 40 + 60 * i,40);
        }
    }    
}
