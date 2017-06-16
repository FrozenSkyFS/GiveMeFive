package littleGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Stone {
	private Color color;
	private static final int size=25;
	private int x;
	private int y;
	public Stone(int x,int y,Color color){
		this.x=x;
		this.y=y;
		this.color=color;
	}
	public void draw(Graphics2D g){
		g.setPaint(color);
		g.fill(new Ellipse2D.Double(x-size/2,y-size/2,size,size));
	}
	public Color getColor(){
		return color;
	}
}
