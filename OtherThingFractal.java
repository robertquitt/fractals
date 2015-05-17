package fractals;
/* 
 * Other Thing Fractal
 * Draws a swastika snowflake-extrusion thing.
 * @author Robert Quitt
 */
import java.awt.Color;

import apcslib.*;
public class OtherThingFractal {
	private static DrawingTool pencil = new DrawingTool(new SketchPad(600,600));;
	static void drawThing(double x, double y, double len, int width,boolean reversed) {
		for (int i = 0; i <= 3; i++) {
			pencil.up();
			pencil.move(x,y);
			pencil.setDirection(90*i);
			pencil.down();
			pencil.move(len);
			pencil.setDirection(90*i + (reversed?-90:90));
			pencil.move(len);
		}
	}
	static void drawTheThing(double x, double y, int level, double len){
		drawThing(x,y,len,1,false);
		drawTheThing(x+len,y+len/2.0d,level-1,len/2.0,2,false);
		drawTheThing(x+len/2.0d,y-len,level-1,len/2.0,3,false);
		drawTheThing(x-len,y-len/2.0d,level-1,len/2.0,0,false);
		drawTheThing(x-len/2.0d,y+len,level-1,len/2.0,1,false);
	}
	static void drawTheThing(double x, double y, int level, double len, int offset,boolean reversed) {
		double i = reversed?1.0:0.5;
		double j = reversed?0.5:1.0;
		drawThing(x,y,len,1,!reversed);
		if (level >= 1) {
			if (offset!=0)
				drawTheThing(x+i*len,y+j*len,level-1,len/2.0,2,!reversed);
			if (offset!=1)
				drawTheThing(x+j*len,y-i*len,level-1,len/2.0,3,!reversed);
			if (offset!=2)
				drawTheThing(x-i*len,y-j*len,level-1,len/2.0,0,!reversed);
			if (offset!=3)
				drawTheThing(x-j*len,y+i*len,level-1,len/2.0,1,!reversed);
		}
	}
	public static void main(String[] args) {
		pencil.setWidth(1);
		pencil.setColor(Color.BLACK);
		drawTheThing(0,0,6,128);
	}
}
