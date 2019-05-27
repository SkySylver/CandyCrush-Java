package combinaison;

import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS ALIGNES VERTICALEMENT DONT UN RAYE A L'HORIZONTALE
public class TroisVerticauxRayesH extends Combinaison {

	private int debutLigne;
	private int colonne;

	public TroisVerticauxRayesH(int dL, int c) {
		debutLigne = dL;
		colonne = c;
	}
	
	public void executerCombinaison(Grille grille) throws CandyException {
		for (int i = debutLigne; i < debutLigne + 3; i++) {
			if (grille.getType(i, colonne).equals("BonbonSimple")) {
				// si le bonbon n'est pas à rayé, on explose juste le bonbon
				grille.exploser(i, colonne);
			} else {
				// sinon on explose toute la colonne
				for (int j = 0; j < TAILLE ; j++)
					grille.exploser(i, j);
			}
		}

	}

	@Override
	public String toString() {
		return "TroisVerticauxRayesH [debutLigne=" + debutLigne + ", colonne=" + colonne + ", lignesARayer=" + "]";
	}
}
