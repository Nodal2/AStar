package modele.problems;

import java.awt.Point;

import modele.IHeuristic;
import modele.Utils;

public class MazeHeuristic {
	
	
	public static IHeuristic<MazeState> manathanDistance(){
		return new IHeuristic<MazeState>() {
			@Override
			public double apply(MazeState state) {
				Point player = state.getPlayerCoords();
				Point goal = state.getGoalCoords();
				if(goal == null) {
					return 0;
				}
				return Utils.abs(goal.x - player.x) + Utils.abs(goal.y - player.y);
			}
		};
		
	}
	
	public static IHeuristic<MazeState> euclidianDistance() {
		return new IHeuristic<MazeState>() {

			@Override
			public double apply(MazeState state) {
				Point player = state.getPlayerCoords();
				Point goal = state.getGoalCoords();
				if(goal == null) {
					return 0;
				}
				return Math.sqrt(Math.pow(goal.x - player.x, 2)-Math.pow(goal.y - player.y, 2));
			}
			
		};
		
	}

}
