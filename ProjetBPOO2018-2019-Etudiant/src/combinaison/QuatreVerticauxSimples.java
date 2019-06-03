package combinaison;

import exceptions.CandyException;
import grille.Grille;

/**
 * QUATRE BONBONS SIMPLES ALIGNES VERTICALEMENT
 *
 */
public class QuatreVerticauxSimples extends Combinaison {
	public QuatreVerticauxSimples(int dL, int l, int c) {
		debutLigne = dL;
		ligne = l;
		colonne = c;
	}

	/**
	 * @see Combinaison#executerCombinaison(Grille)
	 */
	public int executerCombinaison(Grille grille) throws CandyException {
		String coul = grille.getCouleur(ligne, colonne);
		for (int i = debutLigne; i < debutLigne + 4; i++)
			grille.exploser(i, colonne);
		grille.putBonbonVertical(ligne, colonne, coul);
		
		return 60;
	}

	@Override
	public String toString() {
		return "QuatreVerticauxSimples [debutLigne=" + debutLigne + ", debutColonne=" + debutColonne + ", ligne="
				+ ligne + ", colonne=" + colonne + "]";
	}

}
