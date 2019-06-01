package combinaison;

import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS SIMPLES ALIGNES HORIZONTALEMENT
public class TroisHorizontauxSimples extends Combinaison {

	public TroisHorizontauxSimples(int dC, int l) {
		debutColonne = dC;
		ligne = l;
	}
	
	public void executerCombinaison(Grille grille) throws CandyException {
		for(int i = debutColonne; i<debutColonne+3; i++) {
			grille.exploser(ligne, i);
		}
	}

	@Override
	public String toString() {
		return "TroisHorizontauxSimples [debutLigne=" + debutLigne + ", debutColonne=" + debutColonne + ", ligne="
				+ ligne + ", colonne=" + colonne + "]";
	}
}
