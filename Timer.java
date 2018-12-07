import greenfoot.*;
/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    private int time = 100;
    public boolean started = false;
    public static Timer timer = new Timer();
    
    public Timer () {
    }
    
public void act() {
    if (started) {
    time--;
    getWorld().showText(""+time, 500, 35);
    if (time <= 0) {
        getWorld().removeObject(Timer.timer);
        time = 100;
        started = false;
        Greenfoot.stop();
        Greenfoot.setWorld(new MyWorld());
    }
}  
}
}