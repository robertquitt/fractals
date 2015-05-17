package fractals;

import apcslib.*;
public class KochCurve {
	private static DrawingTool pencil = new DrawingTool(new SketchPad(600,600));
	static void drawSnowflake(int level, double len) {
		pencil.up();
		pencil.move(-300, 150);
		pencil.down();
		pencil.setDirection(0);
		drawCurve(level, len);
		pencil.setDirection(240);
		drawCurve(level, len);
		pencil.setDirection(120);
		drawCurve(level, len);
	}
	static void drawCurve(int level, double len) {
		if (level < 1) {
			pencil.forward(len);
		} else {
			drawCurve(level-1,len/3);
			pencil.turnLeft(60);
			drawCurve(level-1,len/3);
			pencil.turnRight(120);
			drawCurve(level-1,len/3);
			pencil.turnLeft(60);
			drawCurve(level-1,len/3);
		}
	}
	
	
	public static void main(String[] args) {
		drawSnowflake(5,729);
	}

}
