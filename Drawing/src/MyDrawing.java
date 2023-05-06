import java.awt.Color;

import objectdraw.*;

public class MyDrawing extends WindowController {

	private FilledArc ship;
	private FilledRect water;
	private AngLine sail;
	private FilledArc movingShip;
	private FilledArc wave1;
	private FilledArc wave2;
	private FilledArc sinkingShip;
	
	public void begin() {
			ship = new FilledArc(100, 300, 200, 100, 0, -180, canvas);
			ship.setColor(Color.lightGray);
			water = new FilledRect(0, 400, canvas.getWidth(), 400, canvas);
			water.setColor(Color.blue);
			sail = new AngLine(200, 250, 100, 80, canvas);
			sail.setColor(Color.LIGHT_GRAY);
			movingShip = new FilledArc(200, 300, 200, 100, 0, -180, canvas);
			movingShip.setColor(Color.LIGHT_GRAY);
			movingShip.hide();
			wave1 = new FilledArc(475, 300, 100, 200, 0, 150, canvas);
			wave1.setColor(Color.blue);
			wave2 = new FilledArc(400, 300, 100, 200, 0, 150, canvas);
			wave2.setColor(Color.blue);
			wave1.hide();
			wave2.hide();
			sinkingShip = new FilledArc(200, 375, 200, 100, 0, 180, canvas);
			sinkingShip.setColor(Color.black);
			sinkingShip.hide();
		}
		public void onMousePress(Location l) {
			movingShip.hide();
			movingShip.show();
			sail.move(100, 0);
			ship.hide();
			wave1.show();
			wave2.show();
			
			
		}
		public void onMouseRelease(Location l) {
			movingShip.hide();
			wave1.move(-350, 0);
			wave2.move(-350, 0);
			water.sendBackward();
			wave1.setColor(Color.cyan);
			wave2.setColor(Color.cyan);
			sail.move(0, 150);
			sail.setColor(Color.black);
			sail.sendToFront();
			sinkingShip.show();
			sinkingShip.sendForward();
		}
	
		public static void main(String[] args) {
			MyDrawing d = new MyDrawing();
			d.startController(600, 800);
		}
		
}
