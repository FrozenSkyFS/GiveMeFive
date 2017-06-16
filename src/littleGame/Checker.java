package littleGame;

import java.awt.Color;

public class Checker {
	private GameBoard gb;
	public Checker(GameBoard gb){
		this.gb=gb;
	}
	public boolean check(int x,int y,Color color){
		Stone[][] board=gb.getBoard();
		int count=1;
		int size=gb.LINES;
		boolean isWin=false;
		{
			int countleft=0;
			int countRight=0;
			for(int i=x-1;i>=0;i--){
				if(board[y][i]!=null&&board[y][i].getColor()==color){
					countleft++;
				}else{
					break;
				}
			}
			for(int i=x+1;i<size;i++){
				if(board[y][i]!=null&&board[y][i].getColor()==color){
					countRight++;
				}else{
					break;
				}
			}
			if(countleft+countRight>=4){
				isWin=true;
			}
		}
		{
			int countUp=0;
			int countDown=0;
			for(int i=y-1;i>=0;i--){
				if(board[i][x]!=null&&board[i][x].getColor()==color){
					countUp++;
				}else{
					break;
				}
			}
			for(int i=y+1;i<size;i++){
				if(board[i][x]!=null&&board[i][x].getColor()==color){
					countDown++;
				}else{
					break;
				}
			}
			if(countDown+countUp>=4){
				isWin=true;
			}
		}
		{
			int countUp=0;
			int countDown=0;
			for(int i=y-1,j=x-1;i>=0&&j>=0;i--,j--){
				if(board[i][j]!=null&&board[i][j].getColor()==color){
					countUp++;
				}else{
					break;
				}
			}
			for(int i=y+1,j=x+1;i<size&&j<size;i++,j++){
				if(board[i][j]!=null&&board[i][j].getColor()==color){
					countDown++;
				}else{
					break;
				}
			}
			if(countDown+countUp>=4){
				isWin=true;
			}
		}
		{
			int countUp=0;
			int countDown=0;
			for(int i=y+1,j=x-1;i<size&&j>=0;i++,j--){
				if(board[i][j]!=null&&board[i][j].getColor()==color){
					countUp++;
				}else{
					break;
				}
			}
			for(int i=y-1,j=x+1;i>=0&&j<size;i--,j++){
				if(board[i][j]!=null&&board[i][j].getColor()==color){
					countDown++;
				}else{
					break;
				}
			}
			if(countDown+countUp>=4){
				isWin=true;
			}
		}
		if(isWin){
			System.out.println(color+" is Win!!!");
			return true;
		}
		return false;
	}
}
