package littleGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.*;

import javax.swing.JComponent;


class GameBoard extends JComponent{
	private static final int MARGIN=25;
	private static final int SPACE=30;
	public static final int LINES=15;
	private static final int HEIGHT=MARGIN*2+SPACE*LINES;
	private static final int WIDTH=HEIGHT;
	private static final Stone[][] stones=new Stone[15][15];
	private static boolean isWhite=true;
	private static Checker checker;
	public GameBoard(){
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		addMouseListener(new ClickListener(this));
		checker=new Checker(this);
	}
	public void paintComponent(Graphics g){
		Graphics2D g2=(Graphics2D)g;
		//draw lines
		for(int i=0;i<LINES+1;i++){
			Line2D col=new Line2D.Double(MARGIN+i*SPACE,MARGIN,MARGIN+i*SPACE,MARGIN+LINES*SPACE);
			Line2D row=new Line2D.Double(MARGIN,MARGIN+i*SPACE,MARGIN+LINES*SPACE,MARGIN+i*SPACE);
			g2.draw(col);
			g2.draw(row);
		}
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				if(stones[i][j]!=null)
					stones[i][j].draw(g2);
			}
		}
	}
	public void putStoneToNearestPoint(int xp,int yp){
		int x=Math.round((xp-MARGIN)/(float)SPACE);
		int y=Math.round((yp-MARGIN)/(float)SPACE);
		if(x>LINES||x<0||y>LINES||y<0)return;
		if(stones[y][x]==null){
			putStone(x,y,isWhite?Color.white:Color.black);
		}
	}
	public void putStone(int x,int y,Color color){
		stones[y][x]=new Stone(x*SPACE+MARGIN,y*SPACE+MARGIN,color);
		repaint();
		checker.check(x,y,color);
		isWhite=!isWhite;
	}
	public Dimension getPreferredSize(){
		return new Dimension(HEIGHT,WIDTH);
	}
	public Stone[][] getBoard(){
		return stones;
	}
}