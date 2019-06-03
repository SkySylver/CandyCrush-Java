package combinaison;

import exceptions.CandyException;
import grille.Grille;

/**
 *  TROIS BONBONS ALIGNES VERTICALEMENT DONT UN RAYE A L'HORIZONTALE
 *
 */
public class TroisVerticauxRayesH extends Combinaison {

	public TroisVerticauxRayesH(int dL, int c) {
		debutLigne = dL;
		colonne = c;
	}
	
	/**
	 * @see Combinaison#executerCombinaison(Grille)
	 */
	public int executerCombinaison(Grille grille) throws CandyException {
		for (int i = debutLigne; i < debutLigne + 3; i++) {
			if (grille.getType(i, colonne).equals("BonbonSimple")) {
				// si le bonbon n'est pas à rayé, on explose juste le bonbon
				grille.exploser(i, colonne);
			} else {
				// sinon on explose toute la colonne
				for (int j = 0; j < grille.getTaille() ; j++)
					grille.exploser(i, j);
			}
		}
		return 120;
	}

	@Override
	public String toString() {
		return "TroisVerticauxRayesH [debutLigne=" + debutLigne + ", debutColonne=" + debutColonne + ", ligne=" + ligne
				+ ", colonne=" + colonne + "]";
	}

}
