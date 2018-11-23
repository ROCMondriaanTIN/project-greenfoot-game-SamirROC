import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Overlay extends Actor
{
    Lifes[] lives = new Lifes[3];
    public int lifeCounter = 3;
    
    public Overlay(World world){
        for (int i = 0 ; i < lives.length; i++){
            lives[i] = new Lifes();
            world.addObject(lives[i], 40 + 60 * i,40);
        }
    }
    
    public void removeLife() {
        lifeCounter--;
        if( lifeCounter == 0 )
             {
             Greenfoot.setWorld(new MyWorld());
             }
        getWorld().removeObject(lives[lifeCounter]);
}
}
