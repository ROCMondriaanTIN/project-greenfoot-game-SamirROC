import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Mover
{
    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;
    private GreenfootImage slimew1 = new GreenfootImage("slimeWalk1.png");
    private GreenfootImage slimew2 = new GreenfootImage("slimeWalk2.png");
    private String direction = "left";  
    private int status;
    private int walkStatus = 1;
              
     public Enemy2() {
        super();
        setImage("blockerMad.png");
        getImage().mirrorHorizontally();
        walkRange = 140;
        firstAct = true;
        speed = 2;
    }
   public void switchSlime()
   {
   if (status == 2){ 
    
       if (walkStatus > 2){
           walkStatus = 1;
        }
            setImage("slimeWalk" + walkStatus + ".png");
            walkStatus ++;

        status = 0;
   if (direction.equals("right")) {
       getImage().mirrorHorizontally();
   }
}else{
    status++;
}
  }

 
  
    public void act() {
        int x = getX();
        int y = getY();
       
        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }
        velocityX = speed;
        applyVelocity();
        if (getX() >= xMax) {
                speed *= -1;
                x = xMax;
                direction = "left";
                
            } else if (getX() <= xMin) {
                speed *= -1;
                x = xMin;
                direction = "right";

            }
            
        
   }
   public void mirror(){
       if (direction.equals("right")){
       getImage().mirrorHorizontally();
    }  
}
}    

