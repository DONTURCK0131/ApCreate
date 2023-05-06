import objectdraw.*;

import java.awt.Color;
import java.awt.color.*;

import java.util.Random;


/* on mouse press:
 * strong initial location of the press as an instance variable (s)
 * on mouse drag(location l):
 * laundry.move(l.getX() - s.getX(), ...)
 * s = l
 * on mouse release: 
 * logic to see if the box overlaps the correct one
 * whitesbin.overlaps(r)
 * update counters and text 
 * move back to starting position
 */
public class LaundrySorter extends WindowController {
	private FramedRect colors;
	private FramedRect darks;
	private FramedRect whites;
	private Text labelForColors;
	private Text labelForDarks;
	private Text labelForWhites;
	private FilledRect laundry;
	private FramedRect laundry2;
	private Location click;
	private Random rand;
	private Text correct;
	private Text incorrect;
	private int n;
	private int t;
	private int r;
	private int g;
	private int b;
	private Location start;
	private boolean cont;
	
	public void onMousePress(Location l) {
		start = l;
		if(laundry.contains(start)) {
			cont = true;
		}
	}
	
	public void onMouseDrag(Location m) {
		if(cont == true) {
			laundry.move(m.getX()-start.getX(), m.getY()-start.getY());
		start = m;
		}
	}
	
	public void onMouseRelease(Location m) {
		cont = false;
		if ((whites.overlaps(laundry)) && (isWhite(r, g, b) == true)) {
			correct.setText("Correct: " + ++n);
			laundryReset();
		} else if((colors.overlaps(laundry)) && (isColor(r, g, b) == true)) {
			correct.setText("Correct: " + ++n);
			laundryReset();
		} else if ((darks.overlaps(laundry)) && (isDark(r, g, b) == true)) {
			correct.setText("Correct: " + ++n);
			laundryReset();
		} else if(!colors.overlaps(laundry) && !darks.overlaps(laundry) && !(whites.overlaps(laundry))) {
			laundry.moveTo(275, 100);
		} else {
			incorrect.setText("Incorrect: " + ++t);
			laundryReset();
		}
	}
	
	/* public void onMouseClick(Location click) {
		if ((whites.contains(click)) && (laundry.getColor().equals(Color.white))) {
			correct.setText("Correct: " + ++n);
		} else if ((darks.contains(click)) && (laundry.getColor().equals(Color.black))) {
			correct.setText("Correct: " + ++n);
		} else if ((colors.contains(click)) && (laundry.getColor().equals(Color.red))) {
			correct.setText("Correct: " + ++n);
		} else {
			incorrect.setText("Incorrect: " + ++t);
		}
		laundry.setColor(randomColor());
	} */
	
	public Color randomColor() {
		r = (int) (Math.random()*255);
		g = (int) (Math.random()*255);
		b = (int) (Math.random()*255);
		return new Color(r, g, b);
				
	}
	public boolean isWhite(int r, int g, int b) {
		if(r >= 220 && g >= 220 && b >= 220) {
			return true;
		} else {
			return false;
		}
	
	} public boolean isDark(int r, int g, int b) {
		if(r<=125 && g<=125 && b<=125) {
			return true;
		} else {
			return false;
		}
	} public boolean isColor(int r, int g, int b) {
		if(isWhite(r, g, b) == false && isDark(r, g, b) == false) {
			return true;
		} else {
			return false;
		}
	} public void laundryReset() {
		laundry.setColor(randomColor());
		laundry.moveTo(275, 100);
	}
	
	public void begin() {
		whites = new FramedRect(25, 300, 100, 100, canvas);
		darks = new FramedRect(250, 300, 100, 100, canvas);
		colors = new FramedRect(475, 300, 100, 100, canvas);
		labelForWhites = new Text("Whites", 65, 350, canvas);
		labelForDarks = new Text("Darks", 285, 350, canvas);
		labelForColors = new Text("Colors", 515, 350, canvas);
		laundry = new FilledRect(275, 100, 100, 100, canvas);
		rand = new Random();
		correct = new Text("Correct: " + n, canvas.getWidth()/2, 450, canvas);
		incorrect = new Text("Incorrect: " + t, canvas.getWidth()/2, 475, canvas);
	}
		
	
	public static void main(String[] args) {
		LaundrySorter d = new LaundrySorter();
		d.startController(600, 600);
	}
}
