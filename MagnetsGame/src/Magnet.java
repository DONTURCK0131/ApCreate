
import objectdraw.*;
import java.awt.*;

/*
 * Definition of class of objects used to represent bar magnets.
 * DESCRIBE YOUR CLASS HERE
 * 
 * YOUR NAME / LAB SECTION
 * DATE
 * 
 * Complete the implementation of these methods and add 
 * the others described in the lab handout.
 */
public class Magnet {
	
	private Pole northPole;
	private Pole southPole;

    //  dimensions of magnets	
    private static final double MAGNET_WIDTH = 150;
    private static final double MAGNET_HEIGHT = 50;


    //  Box representing perimeter of magnet
    private FramedRect box;

    //  Create a new magnet at location upperLeft
    public Magnet(Location upperLeft, DrawingCanvas canvas) {
    	box = new FramedRect(upperLeft.getX(), upperLeft.getY(), MAGNET_WIDTH, MAGNET_HEIGHT, canvas);
    	northPole = new Pole(this, upperLeft.getX() + 20, upperLeft.getY() + MAGNET_HEIGHT/2, "N", canvas);
    	southPole = new Pole(this, upperLeft.getX() + 130, upperLeft.getY() + MAGNET_HEIGHT/2, "S", canvas);
    }

    // returns the upper-left coordinates of the magnet
    public Location getLocation() {
        return box.getLocation();
    }

    public void move(double xoff, double yoff) {
    	box.move(xoff, yoff);
    	northPole.move(xoff, yoff);
    	southPole.move(xoff, yoff);
    }

    public void moveTo(Location point) {
    	double dx = point.getX() - box.getX();
    	double dy = point.getY() - box.getY();
    	move(dx, dy);
    }
    
    public void flip() {
    	double northX = northPole.getX();
    	double northY = northPole.getY();
    	double southX = southPole.getX();
    	double southY = southPole.getY();
    	northPole.move(southX - northX, southY - northY);
    	southPole.move(northX - southX,northY - southY);
    }
    
    public Pole getNorth() {
    	return northPole;
    }
    
    public Pole getSouth() {
    	return southPole; 
    }
    
    public void interact(Magnet otherMagnet) {
    	this.getNorth().attract(otherMagnet.getSouth());
    	this.getSouth().attract(otherMagnet.getNorth());
    	this.getNorth().repel(otherMagnet.getNorth());
    	this.getSouth().repel(otherMagnet.getSouth());
    }

    /*
     * This should return true if the given point is within the magnet.
     * The current implementation does not do this!!!  You must change
     * the body of this method so that it has the proper functionality!!!
     */
    public boolean contains(Location point) {
        return box.contains(point);
    }

    // returns the width of the magnet
    public double getWidth() {
        return MAGNET_WIDTH;
    }

    // returns the height of the magnet
    public double getHeight() {
        return MAGNET_HEIGHT;
    }

}
