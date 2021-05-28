package modele;

import java.util.Iterator;

public interface IState<O> {

	public Iterator<O> getPossibleMoves();
	public String toString();

}
