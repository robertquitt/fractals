package fractals;
import java.awt.Color;

import apcslib.*;
public class DrawMengerSponge {
	private static DrawingTool pencil = new DrawingTool(new SketchPad(600,600));
	static void drawSquare(double x, double y, double size) {
		pencil.up();
		pencil.move(x, y);
		pencil.down();
		pencil.fillRect(size, size);
	}
	static void drawTheThing(double x, double y, int level, double size) {
		if (level >= 1) {
			drawSquare(x,y,size);
			drawTheThing(x-size,y+size,level-1,size/3);//Top Left square
			drawTheThing(x,y+size,level-1,size/3);//Top  square
			drawTheThing(x+size,y+size,level-1,size/3);//Top Right square
			drawTheThing(x+size,y,level-1,size/3);//Right square
			drawTheThing(x+size,y-size,level-1,size/3);//Bottom Right square
			drawTheThing(x,y-size,level-1,size/3);//Bottom square
			drawTheThing(x-size,y-size,level-1,size/3);//Bottom Left square
			drawTheThing(x-size,y,level-1,size/3);//Left square
		}
	}
	public static void main(String[] args) {
		pencil.setColor(Color.BLACK);
		drawTheThing(0,0,4,128);
	}

}
