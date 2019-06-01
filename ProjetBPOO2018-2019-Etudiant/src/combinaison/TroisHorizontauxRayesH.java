package combinaison;

import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS ALIGNES HORIZONTALEMENT DONT UN RAYE A L'HORIZONTALE
public class TroisHorizontauxRayesH extends Combinaison {
	public TroisHorizontauxRayesH(int l) {
		ligne = l;
	}
	
	public int executerCombinaison(Grille grille) throws CandyException {
		for(int i = 0; i<TAILLE; i++) {
			grille.exploser(ligne, i);
		}
		
		return 120;
	}

	@Override
	public String toString() {
		return "TroisHorizontauxRayesH [debutLigne=" + debutLigne + ", debutColonne=" + debutColonne + ", ligne="
				+ ligne + ", colonne=" + colonne + "]";
	}

}
