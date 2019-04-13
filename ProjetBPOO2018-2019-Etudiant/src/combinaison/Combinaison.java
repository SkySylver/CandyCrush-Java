package combinaison;

import exceptions.CandyException;
import grille.Grille;

public abstract class Combinaison {
	private Combinaison suivante = null;

	public Combinaison(Combinaison comb) {
		suivante = comb;
	}
	public Combinaison getSuivante() {
		return suivante;
	}
	
	public abstract boolean	combinaisonExiste(int l, int c, Grille grille) throws CandyException;
	public abstract void executerCombinaison(Grille grille) throws CandyException;
	
	public void detecter(int l, int c, Grille grille) throws CandyException{
		if (combinaisonExiste(l, c, grille))
			executerCombinaison(grille);
		else if (suivante != null)
			suivante.detecter(l, c, grille);
		else
			System.out.println("Aucune");
	}
	
}
