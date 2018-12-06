import greenfoot.*;
import java.util.List;
/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private boolean isOnGround;
    private int walkStatus;
    private int width;
    int status = 0;
    private String direction = "right";
    int x = 960;
    int y = 11650;
    private GreenfootImage walk1w = new GreenfootImage("p1_walk1.png");
    private GreenfootImage walk2w = new GreenfootImage("p1_walk2.png");
    private GreenfootImage walk3w = new GreenfootImage("p1_walk3.png");
    private GreenfootImage walk4w = new GreenfootImage("p1_walk4.png");
    private GreenfootImage walk5w = new GreenfootImage("p1_walk5.png");
    private GreenfootImage walk6w = new GreenfootImage("p1_walk6.png");
    private GreenfootImage walk7w = new GreenfootImage("p1_walk7.png");
    private GreenfootImage walk8w = new GreenfootImage("p1_walk8.png");
    private GreenfootImage walk9w = new GreenfootImage("p1_walk9.png");
    private GreenfootImage walk10w = new GreenfootImage("p1_walk10.png");
    private GreenfootImage walk11w = new GreenfootImage("p1_walk11.png");
    private Overlay overlay;
    private ScoreCounter scorecounter;
    private CollisionEngine collisionEngine;
    private TileEngine tileEngine;
    eindscherm eindscherm = new eindscherm();
    public Hero(Overlay overlay, ScoreCounter scorecounter, CollisionEngine collisionEngine, TileEngine tileEngine) {
        super();
        this.collisionEngine = collisionEngine;
        this.tileEngine = tileEngine;
        this.overlay = overlay;
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1_front.png");
        setLocation(960, 11650);
        this.scorecounter = scorecounter;
    }

    @Override
    public void act() {
        atWorldEdge();
        handleInput();
        
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        List<Tile> tiles = collisionEngine.getCollidingTiles(this, true);

        for (Tile tile : tiles) {
            if (tile != null) {
                if (tile.type == TileType.SPIKES) {
                    overlay.removeLife();
                    setLocation(x, y);
                    return;
                }
            }
        }
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                setLocation(x, y);
                overlay.removeLife();
                break;
                
            }
        }
        for (Actor enemy : getIntersectingObjects(Enemy2.class)) {
            if (enemy != null) {
                setLocation(x, y);
                overlay.removeLife();
                break;
                
            }
        }
        for (Actor checkpoint : getIntersectingObjects(Checkpoint.class)) {
            if (checkpoint != null) {
                checkpoint.setImage("flagBlue.png");
                x = checkpoint.getX();
                y = checkpoint.getY();
                break;
            }
        }
        for (Tile tile : getIntersectingObjects(Tile.class)) {
            if(tile != null){ 
             if(tile.getImage().toString().contains("coinGold")) {
             getWorld().removeObject(tile);
             scorecounter.addScore();
    }
}
}
for (Tile tile : getIntersectingObjects(Tile.class)) {
            if(tile != null){ 
             if(tile.getImage().toString().contains("window")) {
             setLocation(66, 435);
    }
}
}
for (Tile tile : getIntersectingObjects(Tile.class)) {
            if(tile != null){ 
             if(tile.getImage().toString().contains("window2")) {
             setLocation(960, 8250);
    }
}
}
for (Tile tile : getIntersectingObjects(Tile.class)) {
            if(tile != null){ 
             if(tile.getImage().toString().contains("liquidLava")) {
             overlay.removeLife();
             setLocation(x, y);
             return;
    }
}
}
for (Actor enemy : getIntersectingObjects(AI.class)) {
            if (enemy != null) {
                getWorld().removeObject(enemy);
                getWorld().addObject(eindscherm, 500, 300);
                break;
            }
        }
}    


   
    
    public void handleInput() {
        //on ground check and handling

        width = getImage().getWidth() / 2;

        Tile tile = (Tile) getOneObjectAtOffset(0, getImage().getHeight() / 2 + 1, Tile.class);
        if (tile == null) {
            tile = (Tile) getOneObjectAtOffset(this.width - 3, getImage().getHeight() / 2 + 1, Tile.class);
        }
        if (tile == null) {
            tile = (Tile) getOneObjectAtOffset((int) posToNeg(this.width) + 3, getImage().getHeight() / 2 + 1, Tile.class);
        }

        if (tile != null && tile.isSolid) {
            isOnGround = true;
        } else {
            isOnGround = false;
        }
        if (Greenfoot.isKeyDown("space")) {

            if (isOnGround) {
                velocityY = -13;
                animationJump(getWidth(), getHeight(), 1);
            }

        }

        if (Greenfoot.isKeyDown("a")) {
            velocityX = -7;
            direction = "left";
            animationWalk(getWidth(), getHeight(), 1, false);
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 7;
            direction = "right";
            animationWalk(getWidth(), getHeight(), 1, true);
        } else {
            animationStand(getWidth(), getHeight(), 1);
        }
    }


 public void animationWalk(int width, int heigth, int player, boolean right) {

        if (status == 3) {
            if (walkStatus >= 11) {
                walkStatus = 1;
            }
            
            if (isOnGround) {
                setImage("p" + player + "_walk"
                        + walkStatus + ".png");
            }else{
                setImage("p" + player + "_jump.png");
            }
            mirror();
            walkStatus++;
            status = 0;
        } else {
            
            status++;
        }
        
        getImage().scale(width, heigth);
    }


 public void animationJump(int width, int heigth, int player) {
        setImage("p" + player + "_jump.png");
        mirror ();
        getImage().scale(width, heigth);
    }

    public void animationStand(int width, int heigth, int player) {
        if (isOnGround) {
            setImage("p" + player + "_walk1.png");
            getImage().scale(width, heigth);
            walkStatus = 1;
        }else{
            setImage("p" + player + "_jump.png");
        }
        mirror ();
        getImage().scale(width, heigth);
    }
public void mirror() {
    if (direction.equals("left")) {
        
      getImage().mirrorHorizontally();
      
    }
}

 private double posToNeg(double x) {
        return (x - (x * 2));
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }

}
