package combinaison;

import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS ALIGNES VERTICALEMENT DONT UN RAYE A LA VERTICALE
public class TroisVerticauxRayesV extends Combinaison {
	private int colonne;
	
	public TroisVerticauxRayesV(int c) {
		colonne = c;
	}

	public void executerCombinaison(Grille grille) throws CandyException {
		for(int i = 0; i<TAILLE; i++) {
			grille.exploser(i, colonne);
		}
	}

	@Override
	public String toString() {
		return "TroisVerticauxRayesV [colonne=" + colonne + "]";
	}
}
