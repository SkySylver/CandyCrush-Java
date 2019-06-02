package combinaison;

import exceptions.CandyException;
import grille.Grille;

/**
 * Combinaison est la classe mère de toute combinaison.
 * 
 */
public abstract class Combinaison {
	protected int debutLigne = -1;
	protected int debutColonne = -1;
	protected int ligne = -1;

	protected int colonne = -1;
	
	public Combinaison() {}
	
	public abstract int executerCombinaison(Grille grille) throws CandyException;	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combinaison other = (Combinaison) obj;
		if (colonne != other.colonne)
			return false;
		if (debutColonne != other.debutColonne)
			return false;
		if (debutLigne != other.debutLigne)
			return false;
		if (ligne != other.ligne)
			return false;
		return true;
	}
}
