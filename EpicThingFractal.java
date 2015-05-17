package fractals;
/*
 * Epic Thing Fractal
 * Draws a blocky swastika fractal
 * @author Robert Quitt
 */
import java.awt.Color;
import apcslib.*;
public class EpicThingFractal {
	private static int[][] points = {{-2,-2},{-2,0},{-2,1},{-2,2},{-1,-2},{-1,0},{0,-2},{0,-1},{0,0},{0,1},{0,2},{1,0},{1,2},{2,-2},{2,-1},{2,0},{2,2}};
	private static DrawingTool pencil = new DrawingTool(new SketchPad(600,600));;
	static void drawSquare1(double x, double y, double len, int width) {
		pencil.up();
		pencil.move(x-len,y-len);
		pencil.down();
		for (int i = 0; i <= 3; i++) {
			pencil.setDirection(90*i);
			pencil.move(len*2);
		}
	}
	static void drawSquare(double x, double y, double len) {
		pencil.up();
		pencil.move(x,y);
		pencil.down();
		pencil.fillRect(len*5.0d,len*5.0d);
	}
	static void drawTheThing(double x, double y, int level, double len) {
		if (level >= 1) {
			for(int[] i:points){
				drawTheThing(x+len*i[0],y+len*i[1],level-1,len/5.0d);
			}
		} else {
			drawSquare(x,y,len);
		}
	}
	public static void main(String[] args) {
		pencil.setColor(Color.BLACK);
		pencil.setWidth(1);
		drawTheThing(0,0,4,125);
	}
}
