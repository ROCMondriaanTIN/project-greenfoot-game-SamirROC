import greenfoot.*;
/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    private int time = 200;
    public boolean started = false;
    public static Timer timer = new Timer();
    
    public Timer () {
        super();
        getImage().clear();
    }
    
public void act() {
    if (started) {
    time--;
    getWorld().showText(""+time, 500, 35);
    if (time <= 0) {
        getWorld().removeObject(Timer.timer);
        time = 200;
        started = false;
        Greenfoot.stop();
        Greenfoot.setWorld(new MyWorld());
    }
}  
}
}