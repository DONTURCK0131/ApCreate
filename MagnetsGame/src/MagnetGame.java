import objectdraw.*;
import java.awt.*;

/*
 * DESCRIBE YOUR CLASS HERE
 * 
 * YOUR NAME / LAB SECTION
 * DATE
 * 
 */
public class MagnetGame extends WindowController {
	  private Magnet magnet1;
	  private Magnet magnet2;
	  private Location start;
	  private Magnet movingMagnet;
	  private Magnet restingMagnet;


    public void onMousePress(Location point) {
    	if(magnet1.contains(point)) {
    		movingMagnet = magnet1;
    		restingMagnet = magnet2;
    		start = point;
    	} else if(magnet2.contains(point)) {
    		movingMagnet = magnet2;
    		restingMagnet = magnet1;
    		start = point;
    	} else {
    		start = null;
    	}
    }

    public void onMouseDrag(Location point) {
    	
    	if (start != null) {
    		movingMagnet.move(point.getX()-start.getX(), point.getY() - start.getY());
    		start = point;
    	}
    	movingMagnet.interact(restingMagnet);
    }

    public void onMouseClick(Location point) {
    	if (magnet1.contains(point)) {
    		magnet1.flip();
    	} else if (magnet2.contains(point)) {
    		magnet2.flip();
    	}
    	movingMagnet.interact(restingMagnet);
    }
    
    public static void main(String[] args) {
    	new MagnetGame().startController(800,800);
    }
    
    public void begin() {
    	magnet1 = new Magnet(new Location(200, 200), canvas);
    	magnet2 = new Magnet(new Location(200, 350), canvas);
    }

}

