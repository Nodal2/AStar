package modele;

public class Solution<S,O> {
	
	private S state;
	private O operator;
	private Solution<S,O> rest;
	
	public Solution(S state, O operator, Solution<S,O> rest) {
		this.state = state;
		this.rest = rest;
		this.operator = operator;
	}
	
	public String toString() {
		String str = "";
		Solution<S,O> sol = this;
		while(sol.rest != null) {
			str+=sol.getState().toString()+" move : "+sol.getOperator()+"\n";
			sol = sol.getRest();
		}
		return str;
	}

	public S getState() {
		return state;
	}

	public void setState(S state) {
		this.state = state;
	}

	public O getOperator() {
		return operator;
	}

	public void setOperator(O operator) {
		this.operator = operator;
	}

	public Solution<S,O> getRest() {
		return rest;
	}

	public void setRest(Solution<S,O> rest) {
		this.rest = rest;
	}

}
