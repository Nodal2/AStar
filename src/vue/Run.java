package vue;

import modele.Solution;
import modele.problems.DiagonalOperator;
import modele.problems.MazeState;

public class Run extends Thread{
	
	private Solution<MazeState,DiagonalOperator> solution;
	private BoardView boardView;
	
	public Run(Solution<MazeState,DiagonalOperator> solution, BoardView boardView) {
		this.solution = solution;
		this.boardView = boardView;
	}
	
	@Override
	public void run() {
		while(this.solution != null) {
			this.boardView.updateSolution(solution);
			this.solution = solution.getRest();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
