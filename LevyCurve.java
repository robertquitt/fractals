package fractals;
import java.awt.Color;

import apcslib.*;

public class LevyCurve {
	private static double rad2 = Math.sqrt(2);
	private static DrawingTool pencil = new DrawingTool(new SketchPad(600,600));
	static void drawLine(double x, double y, double len, double angle) {
		pencil.up();
		pencil.move(x,y);
		pencil.setDirection(angle);
		pencil.down();
		pencil.forward(len);
	}
	static void drawTheThing(double x, double y, int level, double len, double angle) {
		if (level < 1) {
			drawLine(x,y,len,angle);
		} else {
			drawTheThing(x,y,level-1,len/rad2,angle+45);
			drawTheThing(x+len*Math.cos(Math.toRadians(angle+45))/rad2,y+len*Math.sin(Math.toRadians(angle+45))/rad2,level-1,len/rad2,angle-45);
			//draw 2 things
		}
	}
	public static void main(String[] args) {
		pencil.setColor(Color.BLACK);
		drawTheThing(-400,-200,16,500,0);
	}
}
