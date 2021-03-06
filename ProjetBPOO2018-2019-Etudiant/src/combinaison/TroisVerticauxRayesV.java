package combinaison;

import exceptions.CandyException;
import grille.Grille;

/**
 *  TROIS BONBONS ALIGNES VERTICALEMENT DONT UN RAYE A LA VERTICALE
 *
 */
public class TroisVerticauxRayesV extends Combinaison {
	
	public TroisVerticauxRayesV(int c) {
		colonne = c;
	}

	/**
	 * @see Combinaison#executerCombinaison(Grille)
	 */
	public int executerCombinaison(Grille grille) throws CandyException {
		for(int i = 0; i<grille.getTaille(); i++) {
			grille.exploser(i, colonne);
		}
		return 120;
	}

	@Override
	public String toString() {
		return "TroisVerticauxRayesV [debutLigne=" + debutLigne + ", debutColonne=" + debutColonne + ", ligne=" + ligne
				+ ", colonne=" + colonne + "]";
	}
}
