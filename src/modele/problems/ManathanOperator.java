package modele.problems;

import java.awt.Point;

import modele.IOperator;

public enum ManathanOperator implements IOperator<MazeState> {
	UP,DOWN,LEFT,RIGHT;
		
	@Override
	public boolean isApplicable(MazeState state) {
		Point player = state.getPlayerCoords();
		
		int[][] board = state.getBoard();
		switch(this) {
		case UP : return (player.y-1<0 || board[player.y-1][player.x] == MazeState.WALL) ? false : true; 
		case DOWN : return (player.y+1>state.getHeight()-1 || board[player.y+1][player.x] == MazeState.WALL) ? false : true; 
		case LEFT : return (player.x-1 < 0 || board[player.y][player.x-1] == MazeState.WALL) ? false : true; 
		case RIGHT : return (player.x+1 > state.getWidth()-1 || board[player.y][player.x+1] == MazeState.WALL) ? false : true; 
		}
		return false;
	}
	
	@Override
	public MazeState getSuccessor(MazeState state) {
		int[][] newBoard = state.copyBoard();
		Point player = state.getPlayerCoords();
		newBoard[player.y][player.x] = 0;
		switch(this) {
		case UP : newBoard[player.y-1][player.x] = MazeState.PLAYER; break;
		case DOWN : newBoard[player.y+1][player.x] = MazeState.PLAYER; break;
		case LEFT : newBoard[player.y][player.x-1] = MazeState.PLAYER; break;
		case RIGHT : newBoard[player.y][player.x+1] = MazeState.PLAYER; break;
		}
		MazeState newS = new MazeState(newBoard);
		return newS;
	}
	
	@Override
	public double getCost() {
		return 1;
	}
	
	@Override
	public String toString() {
		return this.name();
	}

	@Override
	public String getName() {
		return "manathan operator";
	}
}
