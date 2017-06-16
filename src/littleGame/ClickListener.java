package littleGame;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javafx.scene.input.MouseButton;

public class ClickListener extends MouseAdapter{
	private GameBoard gameBoard;
	public ClickListener(GameBoard gb){
		gameBoard=gb;
	}
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1){
			Point p=e.getPoint();
			gameBoard.putStoneToNearestPoint(p.x, p.y);
		}
	}
}
