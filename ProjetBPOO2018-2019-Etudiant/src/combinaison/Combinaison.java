package combinaison;

import exceptions.CandyException;
import grille.Grille;

/**
 * Combinaison est la classe mère de toute combinaison.
 * 
 */
public abstract class Combinaison {
	protected int TAILLE = 10;
	protected int debutLigne = -1;
	protected int debutColonne = -1;
	protected int ligne = -1;
	protected int colonne = -1;
	
	public Combinaison() {}
	
	public abstract int executerCombinaison(Grille grille) throws CandyException;	
	
	public void setTaille(int n) {
		TAILLE = n;
	}
}
