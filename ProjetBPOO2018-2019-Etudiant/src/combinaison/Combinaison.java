package combinaison;

import exceptions.CandyException;
import grille.Grille;

public abstract class Combinaison {
	protected final static int TAILLE = 10;
	protected int debutLigne;
	protected int debutColonne;
	protected int ligne;
	protected int colonne;
	
	public Combinaison() {}
	
	public abstract void executerCombinaison(Grille grille) throws CandyException;	
}
