package modele;

public abstract class Problem<S> {
	
	private S initialState;
	private String description;
	
	public Problem(S initialState, String description) {
		this.initialState = initialState;
		this.description = description;
	}
	
	public String toString() {
		String str = this.description+"\n";
		str+="initial state :\n";
		str+=this.initialState.toString();
		return str;
	}
	
	public S getInitialState() {
		return this.initialState;
	}
	
	public abstract boolean isTerminal(S state);
	

}
