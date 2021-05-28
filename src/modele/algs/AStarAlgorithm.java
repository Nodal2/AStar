package modele.algs;

import java.util.ArrayList;
import java.util.Iterator;

import modele.IHeuristic;
import modele.IOperator;
import modele.IState;
import modele.Node;
import modele.Problem;
import modele.Solution;

public class AStarAlgorithm<S extends IState<O>,O extends IOperator<S>> {

	private ArrayList<Node<S,O>> alreadyDeveloped;
	private ArrayList<Node<S,O>> frontier;
	private int nbVisited;
	private int nbDeveloped;
	

	public AStarAlgorithm() {
		this.alreadyDeveloped = new ArrayList<>();
		this.frontier = new ArrayList<>();
		this.nbDeveloped = 0;
		this.nbVisited = 0;
	}

	public Solution<S,O> solve(Problem<S> problem, IHeuristic<S> h) {
		System.out.println("------------AStar started------------");
		System.out.println("...");
		Node<S,O> finalNode = this.aStarAlgorithm(problem, h);
		System.out.println("------------AStar ended !------------");
		System.out.println("total developed nodes : "+this.nbDeveloped);
		System.out.println("total visited nodes : "+this.nbVisited);
		return this.solutionFromNode(finalNode);
	}

	private Node<S,O> aStarAlgorithm(Problem<S> problem, IHeuristic<S> h) {
		Node<S,O> initialNode = new Node<S,O>(problem.getInitialState(), null, null);
		this.frontier.add(initialNode);
		initialNode.setG(0);
		initialNode.setF(h.apply(initialNode.getState()));
		while(!this.frontier.isEmpty()) {
			Node<S,O> chosenNode = chooseFMin(this.frontier);
			if(problem.isTerminal(chosenNode.getState())) {
				return chosenNode;
			}
			
			else {
				this.nbDeveloped++;
				this.frontier.remove(chosenNode);
				this.alreadyDeveloped.add(chosenNode);
				Iterator<O> it = chosenNode.getState().getPossibleMoves();
				O o;
				while(it.hasNext()) {
					o = it.next();
					S state = o.getSuccessor(chosenNode.getState());
					Node<S,O> sonNode = getExistingNode(this.alreadyDeveloped, state);
					if(sonNode == null) {
						sonNode = getExistingNode(this.frontier, state);
					}
					if(sonNode == null) {
						this.nbVisited++;
						sonNode = new Node<S,O>(state, o, chosenNode);
						sonNode.setG(chosenNode.getG()+o.getCost());
						sonNode.setF(sonNode.getG()+h.apply(state));
						this.frontier.add(sonNode);
					}
					else {
						if(sonNode.getG() > chosenNode.getG() + o.getCost()) {
							this.nbVisited++;
							sonNode.setAncestor(chosenNode);
							sonNode.setOperator(o);
							sonNode.setG(chosenNode.getG()+o.getCost());
							sonNode.setF(sonNode.getG()+h.apply(state));
						}
					}
				}
			}
		}
		return null;
	}

	private Node<S,O> getExistingNode(ArrayList<Node<S,O>> nodes, S state) {
		for(Node<S,O> n : nodes) {
			if(n.getState().equals(state)) {
				return n;
			}
		}
		return null;
	}

	private Node<S,O> chooseFMin(ArrayList<Node<S,O>> nodes) {
		Node<S,O> nodeFMin = nodes.get(0);
		for(Node<S,O> n : nodes) {
			if(n.getF() < nodeFMin.getF()) {
				nodeFMin = n;
			}
		}
		return nodeFMin;
	}

	private Solution<S,O> solutionFromNode(Node<S,O> finalNode) {
		System.out.println("------------constructing solution------------");
		Solution<S,O> solution = null;
		O operator = null;
		Node<S,O> currentNode = finalNode;
		while (currentNode != null) {
			solution = new Solution<S,O>(currentNode.getState(), operator, solution);
			operator = currentNode.getOperator();
			currentNode = currentNode.getAncestor();
		}
		System.out.println("------------construction finished------------");
		return solution;
	}

}
