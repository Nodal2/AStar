package vue;

import java.awt.Color;
import java.awt.Graphics;

import modele.Solution;
import modele.problems.DiagonalOperator;
import modele.problems.MazeState;

public class BoardView {
	private static final int MARGE = 10;
	private Solution<MazeState, DiagonalOperator> solution;
	private int boardWidth;
	private int boardHeight;
	private int boxWidth;
	
	public BoardView(Solution<MazeState, DiagonalOperator> solution) {
		this.solution = solution;
		if(solution.getState().getHeight() > solution.getState().getWidth()) {
			this.boardHeight = Display.HEIGHT;
			this.boardWidth = solution.getState().getWidth()*(Display.HEIGHT/solution.getState().getHeight());
		}
		else {
			this.boardWidth = Display.WIDTH;
			this.boardHeight = solution.getState().getHeight() * (Display.WIDTH/solution.getState().getWidth());
			
		}
		this.boxWidth = (int)this.boardWidth/solution.getState().getWidth();
	}
	
	public void displayBoard(Graphics g) {
		int[][] board = this.solution.getState().getBoard();
		g.fillRect(0, 0, boardWidth, boardHeight);
		for(int i = 0; i<this.solution.getState().getWidth();i++) {
			for(int j = 0; j<this.solution.getState().getHeight();j++) {
				this.displayBox(g, board[j][i], this.boxWidth*i, this.boxWidth*j);
			}
		}
		
	}
	
	public void updateSolution(Solution<MazeState,DiagonalOperator> solution) {
		this.solution = solution;
	}
	
	public void displayBox(Graphics g, int boxType, int x, int y) {
		switch(boxType) {
		case 0 : g.setColor(Color.lightGray); break;
		case 1 : g.setColor(Color.red); break;
		case 2 : g.setColor(Color.black); break;
		case 3 : g.setColor(Color.green); break;
		}
		g.fillRect(x, y, this.boxWidth, this.boxWidth);
	}
}
