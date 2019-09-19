import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class graze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class graze extends Actor
{
    /**
     * Act - do whatever the graze wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int alpha = getImage().getTransparency();
        hitreg();
        if (alpha > 10)
        {
            getImage().setTransparency(alpha - 10);
        }
        else
        {
            getWorld().removeObject(this);
        }
    }    
    public void hitreg()
    {
        MyWorld world = (MyWorld) getWorld();
        Actor target1 = getOneIntersectingObject(Player1.class);
        if (target1 != null)
        {
            Greenfoot.playSound("marioded.wav");
            world.removeObject(target1);
        }
        Actor target2 = getOneIntersectingObject(Player2.class);
        if (target2 != null)
        {
            Greenfoot.playSound("marioded.wav");
            world.removeObject(target2);
        }
    }
}