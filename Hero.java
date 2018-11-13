import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private GreenfootImage walk1w = new GreenfootImage("p1_walk01.png");
    private GreenfootImage walk2w = new GreenfootImage("p1_walk02.png");
    private GreenfootImage walk3w = new GreenfootImage("p1_walk03.png");
    private GreenfootImage walk4w = new GreenfootImage("p1_walk04.png");
    private GreenfootImage walk5w = new GreenfootImage("p1_walk05.png");
    private GreenfootImage walk6w = new GreenfootImage("p1_walk06.png");
    private GreenfootImage walk7w = new GreenfootImage("p1_walk07.png");
    private GreenfootImage walk8w = new GreenfootImage("p1_walk08.png");
    private GreenfootImage walk9w = new GreenfootImage("p1_walk09.png");
    private GreenfootImage walk10w = new GreenfootImage("p1_walk10.png");
    private GreenfootImage walk11w = new GreenfootImage("p1_walk11.png");

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1_front.png");
    
    }

    @Override
    public void act() {
        handleInput();
        
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }
    }

    public void handleInput() {
       
        
     
        if (Greenfoot.isKeyDown("w")) {
           if(isTouching(Tile.class))
            {
            velocityY = -15;
            setImage("p1_jump.png");
        }
         
        }

        if (Greenfoot.isKeyDown("a")) {
            velocityX = -5;
            
            if(getImage() == walk1w){
                setImage(walk2w);
            }
            else if (getImage() == walk2w){
                setImage(walk3w);
            }
            else if (getImage() == walk3w){
                setImage(walk4w);
            }
            else if (getImage() == walk4w){
                setImage(walk5w);
            }
            else if (getImage() == walk5w){
                setImage(walk6w);
            }
            else if (getImage() == walk6w){
                setImage(walk7w);
            }
            else if (getImage() == walk7w){
                setImage(walk8w);
            }
            else if (getImage() == walk8w){
                setImage(walk9w);
            }
            else if (getImage() == walk9w){
                setImage(walk10w);
            }
            else if (getImage() == walk10w){
                setImage(walk11w);
            }
            else {
                setImage(walk1w);
            }
          
           
            
            
           

        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
            if(getImage() == walk1w){
                setImage(walk2w);
            }
            else if (getImage() == walk2w){
                setImage(walk3w);
            }
            else if (getImage() == walk3w){
                setImage(walk4w);
            }
            else if (getImage() == walk4w){
                setImage(walk5w);
            }
            else if (getImage() == walk5w){
                setImage(walk6w);
            }
            else if (getImage() == walk6w){
                setImage(walk7w);
            }
            else if (getImage() == walk7w){
                setImage(walk8w);
            }
            else if (getImage() == walk8w){
                setImage(walk9w);
            }
            else if (getImage() == walk9w){
                setImage(walk10w);
            }
            else if (getImage() == walk10w){
                setImage(walk11w);
            }
            else {
                setImage(walk1w);
            }
            

      }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
