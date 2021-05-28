package vue;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import modele.Solution;
import modele.problems.DiagonalOperator;
import modele.problems.MazeState;

public class Display extends JPanel{

	private static final long serialVersionUID = 9119234368176810991L;
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	
	private BoardView board;
	
	public Display(Solution<MazeState, DiagonalOperator> solution) {
		this.board = new BoardView(solution);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		new Run(solution, board).start();
		new Paint(this).start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.board.displayBoard(g);
	}

}
