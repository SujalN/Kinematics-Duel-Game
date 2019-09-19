import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannonball here.
 * 
 * @author (Bryan Ortiz) 
 * @version (11/2/17)
 */
public class Fireball extends SmoothMover
{
    private static final int GROUND_HEIGHT = 360 - 6;
    boolean collision = false;
    boolean mid = false;
    long prevTime = 0;
    long curTime = 0;
    /**
     * Act - do whatever the Cannonball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (collision == false){
            addToVelocity(MyWorld.GRAVITY);
            move();
            turn(15);
            checkCollision();
        }
        if (mid == true) {
            MyWorld world = (MyWorld) getWorld();
            world.removeObject(this);
        }
    }    
    
    /**
     * 
     */
    public Fireball()
    {
        this(new Vector(0, 6));
    }
    
    /**
     * 
     */
    public Fireball(Vector velocity)
    {
        super(velocity);
    }
    
    /**
     * 
     */
    @Override protected void addedToWorld(World world)
    {
        setLocation(getX(), getY());
    }
    /**
     * 
     */
    private void checkCollision()
    {
        MyWorld world = (MyWorld) getWorld();
        Actor midair = getOneIntersectingObject(Fireball.class);
        if (midair != null && mid == false)
        {
            mid = true;
            Greenfoot.playSound("fire.wav");
            world.addObject(new graze(),this.getX(), this.getY());
        }
        if (getY()>601)
        {
            Greenfoot.playSound("fire.wav");
            collision = true;
            world.addObject(new kaboom(),this.getX(), this.getY());
            world.removeObject(this);
        }
    }
}