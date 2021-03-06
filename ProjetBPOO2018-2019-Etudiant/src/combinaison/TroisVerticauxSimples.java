package combinaison;

import exceptions.CandyException;
import grille.Grille;

/**
 * TROIS BONBONS SIMPLES ALIGNES VERTICALEMENT
 *
 */
public class TroisVerticauxSimples extends Combinaison {

	public TroisVerticauxSimples(int dL, int c) {
		debutLigne = dL;
		colonne = c;
	}

	/**
	 * @see Combinaison#executerCombinaison(Grille)
	 */
	public int executerCombinaison(Grille grille) throws CandyException {
		for(int i = debutLigne; i<debutLigne+3; i++) {
			grille.exploser(i, colonne);
		}
		return 30;
	}

	@Override
	public String toString() {
		return "TroisVerticauxSimples [debutLigne=" + debutLigne + ", debutColonne=" + debutColonne + ", ligne=" + ligne
				+ ", colonne=" + colonne + "]";
	}
}
