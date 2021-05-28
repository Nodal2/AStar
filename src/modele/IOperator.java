package modele;

public interface IOperator<S> {	
	public boolean isApplicable(S state);
	public S getSuccessor(S state);
	public double getCost();
	public String getName();
}
