package combinaison;

import exceptions.CandyException;
import grille.Grille;

public abstract class Combinaison {
	protected final static int TAILLE = 10;
	protected int debutLigne = -1;
	protected int debutColonne = -1;
	protected int ligne = -1;
	protected int colonne = -1;
	
	public Combinaison() {}
	
	public abstract void executerCombinaison(Grille grille) throws CandyException;	
}
