package fractals;
/*
 * Thing Squared
 * Draws a fractal swastika square thing
 * @author Robert Quitt
 */
import java.awt.Color;

import apcslib.*;
public class ThingSquared {
	private static DrawingTool pencil = new DrawingTool(new SketchPad(600,600));;
	static void drawThing1(double x, double y, double len, int width) {
		//pencil.setWidth(width);
		for (int i = 1; i <= 4; i++) {
			pencil.up();
			pencil.move(x,y);
			pencil.setDirection(90*i);
			pencil.down();
			pencil.move(len);
			pencil.turnRight(90);
			pencil.move(len);
		}
	}
	static void drawThing(double x, double y, double len, int width) {
		//pencil.setWidth(width);
		for (int i = 1; i <= 4; i++) {
			pencil.up();
			pencil.move(x,y);
			pencil.setDirection(90*i);
			pencil.down();
			pencil.move(len);
			pencil.turnRight(90);
			pencil.move(len);
		}
	}
	static void drawTheThing(double x, double y, int level, double len) {
		if (level >= 1) {
			drawThing(x,y,len,2);
			drawTheThing(x-len,y+len,level-1,len/2);
			drawTheThing(x+len,y+len,level-1,len/2);
			drawTheThing(x-len,y-len,level-1,len/2);
			drawTheThing(x+len,y-len,level-1,len/2);
		}
	}
	public static void main(String[] args) {
		pencil.setWidth(1);
		pencil.setColor(Color.BLACK);
		drawTheThing(0,0,7,128);
	}
}
