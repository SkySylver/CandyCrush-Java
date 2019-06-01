package combinaison;

import exceptions.CandyException;
import grille.Grille;

//TROIS BONBONS SIMPLES ALIGNES VERTICALEMENT
public class TroisVerticauxSimples extends Combinaison {

	public TroisVerticauxSimples(int dL, int c) {
		debutLigne = dL;
		colonne = c;
	}

	public void executerCombinaison(Grille grille) throws CandyException {
		for(int i = debutLigne; i<debutLigne+3; i++) {
			grille.exploser(i, colonne);
		}
	}

	@Override
	public String toString() {
		return "TroisVerticauxSimples [debutLigne=" + debutLigne + ", debutColonne=" + debutColonne + ", ligne=" + ligne
				+ ", colonne=" + colonne + "]";
	}
}
