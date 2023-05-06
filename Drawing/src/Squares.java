import objectdraw.*;

import java.awt.Color;
import java.util.Arrays;
import java.util.Scanner;

public class Squares extends WindowController {
	
	private int num;
	private FilledRect[] rects;
	
	public void begin() {
		rects = new FilledRect[num];
		for(int i=0; i<rects.length; i++) {
			rects[i] = new FilledRect(50*i, 25*i, 70, 70, canvas);
		}
	}
	
	public void onMouseClick(Location l) {
		for(int i=0; i<rects.length; i++) {
			if(rects[i].contains(l)) {
				rects[i].setColor(Color.red);
			}
		}
	}
	
	public void setNum(int n) {
		num = n;
	}
	
	public static void main(String[] args) {
		/*int i = 5;
		int[] a = new int[6];
		a[0] = 4;
		a[1] = 3;
		a[2] = 9;
		System.out.println(Arrays.toString(a));
		String[] as = {"foo", "bar", "baz"};
		System.out.println(Arrays.toString(as));
		as[1] = "qux";
		for(int j = 0; j<as.length; j++)
			System.out.println(as[j]);
		*/
		Scanner s = new Scanner(System.in);
		System.out.print("How many boxes?");
		int numBoxes = s.nextInt();
		Squares sq = new Squares();
		sq.setNum(numBoxes);
		sq.startController(500, 500);
	}
}
