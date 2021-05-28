package modele.problems;

import modele.Problem;

public class MazeProblem extends Problem<MazeState>{
	
	public MazeProblem(MazeState initialState, String description) {
		super(initialState, description);
	}

	@Override
	public boolean isTerminal(MazeState state) {
		return state.getGoalCoords() == null ? true : false;
	}
}
