package application;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import modele.Solution;
import modele.algs.AStarAlgorithm;
import modele.problems.DiagonalOperator;
import modele.problems.MazeHeuristic;
import modele.problems.MazeProblem;
import modele.problems.MazeState;
import vue.Display;

public class Main {

	public static void main(String[] args) {
		
		
		
		int[][] initBoard = {
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,2,2,2,2,2,2,2,2,0,0,0,0,0},
				{0,0,0,2,0,0,0,0,0,2,0,0,0,0,0},
				{0,2,0,2,0,0,0,0,0,2,0,0,0,0,0},
				{0,2,0,2,0,2,2,2,2,2,0,0,0,0,0},
				{2,2,0,2,0,0,0,0,0,2,0,0,0,0,0},
				{0,2,0,2,0,2,0,3,0,2,2,2,0,0,0},
				{0,0,0,2,0,2,0,2,2,2,0,0,0,0,0},
				{2,2,0,2,0,0,0,0,0,2,0,0,0,0,0},
				{2,2,0,0,2,2,2,2,0,2,0,0,0,0,0},
				{2,2,0,2,0,0,0,0,0,2,0,0,0,0,0},
				{2,2,0,0,0,0,0,0,0,2,0,0,0,0,0},
		};
		MazeState initState = new MazeState(initBoard);
		MazeProblem problem = new MazeProblem(initState, "maze problem");
		AStarAlgorithm<MazeState,  DiagonalOperator> astar = new AStarAlgorithm<>();
		Solution<MazeState, DiagonalOperator> solution = astar.solve(problem, MazeHeuristic.euclidianDistance());
		Display display = new Display(solution);
		createWindow(display);
	}
	
	public static void createWindow(Display display) {
		JFrame window = new JFrame("Maze");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new BorderLayout());
		window.add(display, BorderLayout.CENTER);
		//window.add(hud, BorderLayout.SOUTH);
		window.pack();
		window.setVisible(true);
	}

}
