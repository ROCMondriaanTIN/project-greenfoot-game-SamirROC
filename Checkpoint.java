import greenfoot.*;
public class Checkpoint extends Mover {    
    
    public GreenfootImage wave1w = new GreenfootImage("flagBlue.png");
    public GreenfootImage wave2w = new GreenfootImage("flagBlue2.png");
    public GreenfootImage waveSad = new GreenfootImage("flagBlueHanging.png");  
    
    public Checkpoint() {
        setImage (waveSad);
}
    public void flagMove () {
    if (!getImage().equals(waveSad)){
    if (getImage().equals(wave1w)) {
        setImage (wave2w);
    }
    else 
    {
        setImage (wave1w);
    }
}
}
    public void act() {
        applyVelocity();
        flagMove();   
    }
}
  


