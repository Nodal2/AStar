package modele.problems;

import java.awt.Point;

import modele.IOperator;

public enum DiagonalOperator implements IOperator<MazeState> {
	UP, DOWN, LEFT, RIGHT, UL, UR, DL, DR;

	@Override
	public boolean isApplicable(MazeState state) {
		int[][] board = state.getBoard();
		Point player = state.getPlayerCoords();
		switch(this) {
		case UP : return player.y-1 < 0 || board[player.y-1][player.x] == MazeState.WALL ? false : true;
		case DOWN :return player.y+1 > state.getHeight()-1 || board[player.y+1][player.x] == MazeState.WALL ? false : true;
		case LEFT :return player.x-1 < 0 || board[player.y][player.x-1] == MazeState.WALL ? false : true;
		case RIGHT :return player.x+1 > state.getWidth()-1 || board[player.y][player.x+1] == MazeState.WALL ? false : true;
		case UL :return player.y-1 < 0 || player.x-1 < 0 || board[player.y-1][player.x-1] == MazeState.WALL ? false : true;
		case UR :return player.y-1 < 0 || player.x+1 > state.getWidth()-1 || board[player.y-1][player.x+1] == MazeState.WALL ? false : true;
		case DL :return player.y+1 > state.getHeight()-1 || player.x-1 < 0 || board[player.y+1][player.x-1] == MazeState.WALL ? false : true;
		case DR :return player.y+1 > state.getHeight()-1 || player.x+1 > state.getWidth()-1 || board[player.y+1][player.x+1] == MazeState.WALL ? false : true;	
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
		case UL : newBoard[player.y-1][player.x-1] = MazeState.PLAYER; break;
		case UR : newBoard[player.y-1][player.x+1] = MazeState.PLAYER; break;
		case DL : newBoard[player.y+1][player.x-1] = MazeState.PLAYER; break;
		case DR : newBoard[player.y+1][player.x+1] = MazeState.PLAYER; break;
		}
		return new MazeState(newBoard);
	}

	@Override
	public double getCost() {
		if(this == UP || this == DOWN || this == LEFT || this == RIGHT) {
			return 1;
		}
		return 1.41;
	}

	@Override
	public String getName() {
		return "diagonal allowed operator";
	}
	

}
