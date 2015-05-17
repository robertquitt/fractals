package fractals;


import java.awt.Color;

import apcslib.*;

public class Sierpinski {
	private static double rad3 = Math.sqrt(3);
	private static DrawingTool pencil = new DrawingTool(new SketchPad(600,600));
	static void drawTriangle(double x, double y, double len) {
		pencil.up();
		pencil.move(x,y);
		pencil.down();
		pencil.setDirection(300);
		pencil.forward(len);
		pencil.setDirection(180);
		pencil.forward(len);
		pencil.setDirection(60);
		pencil.forward(len);
	}
	/**
	 * Draws a Sierpinski Triangle on the sketchpad
	 * @param x X value of center
	 * @param y Y value of center
	 * @param level The level of recursion to draw
	 * @param len The length of the triangle's sides
	 */
	static void drawTheThing(double x, double y, int level, double len) {
		if (level < 1) {
			drawTriangle(x,y,len);
		} else {
			drawTheThing(x,y,level-1,len/2);//Top triangle
			drawTheThing(x-(len/4),y-(len*rad3/4),level-1,len/2);//Left bottom
			drawTheThing(x+(len/4),y-(len*rad3/4),level-1,len/2);//right bottom
		}
	}
	public static void main(String[] args) {
		pencil.setColor(Color.BLACK);
		drawTheThing(0,350,7,800.0);
	}
}
