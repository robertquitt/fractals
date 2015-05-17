package fractals;
/*
 * Dragon Curve
 * Draws a fractal called "dragon curve"
 * @author Robert Quitt
 */
import java.awt.Color;

import apcslib.*;

public class DragonCurve {
	private static double rad2 = Math.sqrt(2);
	private static SketchPad paper = new SketchPad(600,600);
	private static DrawingTool pencil = new DrawingTool(paper);
	static void drawLine(double x, double y, double len, int angle) {
		pencil.up();
		pencil.move(x,y);
		pencil.setDirection(angle);
		pencil.down();
		pencil.forward(len);
	}
	static void drawTheThing(double x, double y, int level, double len, int angle, boolean odd) {
		if (level < 1) {
			drawLine(x,y,len,angle);
		} else {
			if (odd) { //Switches between making curve left or right
				drawTheThing(x,y,level-1,len/rad2,angle-45,false);
				drawTheThing(x+len*Math.cos(Math.toRadians(angle-45))/rad2,y+len*Math.sin(Math.toRadians(angle-45))/rad2,level-1,len/rad2,angle+45,true);
			} else {
				drawTheThing(x,y,level-1,len/rad2,angle+45,false); 
				drawTheThing(x+len*Math.cos(Math.toRadians(angle+45))/rad2,y+len*Math.sin(Math.toRadians(angle+45))/rad2,level-1,len/rad2,angle-45,true);
			}
		}
	}
	static void drawDragonCurve(double startX, double startY, int degree, double size, int angle) {
		drawTheThing(startX,startY,degree,size,angle,true);
	}
	public static void main(String[] args) {
		pencil.setWidth(1);
		pencil.setColor(Color.BLACK);
		drawDragonCurve(-256,128,16,512,0);
	}
}
