package modele;

public class Node<S,O> {
	private Node<S,O> ancestor;
	private O operator;
	private S state;
	private double g;
	private double f;
	
	public Node(S state, O operator, Node<S,O> ancestor) {
		this.state = state;
		this.operator = operator;
		this.ancestor = ancestor;
		this.g = 0;
		this.f = 0;
	}


	@Override
	public boolean equals(Object obj) {
		Node<S,O> other = (Node<S,O>) obj;
		return other.getState().equals(this.state);
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	public Node<S,O> getAncestor() {
		return ancestor;
	}

	public void setAncestor(Node<S,O> ancestor) {
		this.ancestor = ancestor;
	}

	public O getOperator() {
		return operator;
	}

	public void setOperator(O operator) {
		this.operator = operator;
	}

	public S getState() {
		return state;
	}
}
