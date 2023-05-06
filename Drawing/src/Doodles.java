import java.awt.Color;

import objectdraw.*;

public class Doodles extends WindowController {
	
	private Location start;
	private Color c;
	
	public void begin() {
	}
	
	public void onMousePress(Location l) {
		start = l;
		float r = (float) Math.random();
		float g = (float) Math.random();
		float b = (float) Math.random();
		c = new Color(r, g, b);
	}
	public void onMouseDrag(Location l) {
		Line ln = new Line(start, l, canvas);
		start = l;
		ln.setColor(c);
	}
	public void onMouseRelease(Location l) {

	}

	public static void main(String[] args) {
		Doodles d = new Doodles();
		d.startController(600, 600);
	}
}
