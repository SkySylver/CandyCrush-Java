package combinaison;

import exceptions.CandyException;
import grille.Grille;

public abstract class Combinaison {
	protected final static int TAILLE = 10;
	//String type;
	private int debutLigne;
	private int debutColonne;
	private int ligne;
	private int colonne;
	
	public Combinaison() {}
	
	public abstract void executerCombinaison(Grille grille) throws CandyException;	
}
