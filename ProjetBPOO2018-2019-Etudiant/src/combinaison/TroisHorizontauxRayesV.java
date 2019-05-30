package combinaison;

import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS ALIGNES HORIZONTALEMENT DONT UN RAYE A L'HORIZONTALE
public class TroisHorizontauxRayesV extends Combinaison {

	public TroisHorizontauxRayesV(int dC, int l) {
		debutColonne = dC;
		ligne = l;
	}

	public void executerCombinaison(Grille grille) throws CandyException {
		for (int i = debutColonne; i < debutColonne + 3; i++) {
			if (grille.getType(ligne, i).equals("BonbonSimple")) {
				// si bonbon non rayé, on explose juste le bonbon
				grille.exploser(ligne, i);
			} else {
				// sinon on explose toute la colonne
				for (int j = 0; j < TAILLE ; j++) {
					grille.exploser(j, i);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "TroisHorizontauxRayesV [debutColonne=" + debutColonne + ", ligne=" + ligne + ", colonnesARayer=" + "]";
	}
}
