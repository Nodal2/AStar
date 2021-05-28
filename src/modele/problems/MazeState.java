package modele.problems;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import modele.IState;

public class MazeState implements IState<DiagonalOperator>{
	
	public final static int PLAYER = 1;
	public final static int WALL = 2;
	public final static int GOAL = 3;
	
	private int[][] board;
	private int height;
	private int width;

	
	public MazeState(int[][] board) {
		this.board = board;
		this.width = board[0].length;
		this.height = board.length;
	}
	
	@Override
	public String toString() {
		Point player = this.getPlayerCoords();
		String str = "player coords : x="+player.x+" | y="+player.y;
		this.displayBoard();
		return str;
	}
	
	public void displayBoard() {
		String string = "";
		for(int i = 0; i< this.width+2; i++) {
			string+="-";
		}
		string+="\n";
		for(int i = 0; i< this.height; i++) {
			string+="|";
			for(int j = 0; j<this.width; j++) {
				if(this.board[i][j] == 0) {
					string+=" ";
				}
				else {
					string+=this.board[i][j];
				}
				
			}
			string+="|";
			string+="\n";
			
		}
		for(int i = 0; i< this.width+2; i++) {
			string+="-";
		}
		System.out.println(string);
	}
	
	public Point getPlayerCoords() {
		int i = 0, j = 0;
		while( i <this.height) {
			while( j <this.width) {
				if(this.board[i][j] == PLAYER) {
					return new Point(j, i);
				}
				j++;
			}
			j=0;
			i++;
		}
		return null;
	}
	
	public Point getGoalCoords() {
		int i = 0, j = 0;
		while( i <this.height) {
			while( j <this.width) {
				if(this.board[i][j] == GOAL) {
					return new Point(j, i);
				}
				j++;
			}
			j=0;
			i++;
		}
		return null;
	}
	
	public Iterator<DiagonalOperator> getPossibleMoves() {
		ArrayList<DiagonalOperator> operators = new ArrayList<>();
		for(DiagonalOperator o : DiagonalOperator.values()) {
			if(o.isApplicable(this)) {
				operators.add(o);
			}
		}
		return operators.iterator();
		
	}
	
	public int[][] copyBoard() {
		int[][] copy = new int[this.height][this.width];
		for(int i = 0; i<this.height;i++) {
			for(int j=0; j<this.width; j++) {
				copy[i][j] = this.board[i][j];
			}
		}
		return copy;
	}
	
	@Override
	public boolean equals(Object obj) {
		MazeState other = (MazeState) obj;
		Point player = this.getPlayerCoords();
		return player.equals(other.getPlayerCoords());
	}

	
	
	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
