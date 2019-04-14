package combinaison;

import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS ALIGNES HORIZONTALEMENT DONT UN RAYE A L'HORIZONTALE
public class TroisHorizontauxRayesV extends Combinaison {

	private int debutColonne;
	private int ligne;

	public TroisHorizontauxRayesV(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws CandyException {

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple") || t.contentEquals("BonbonVertical")) {

			// on se place sur le bonbon le plus à gauche qui est de la même couleur
			while (c > 0 && grille.getCouleur(l, c - 1).equals(coul)) {
				c--;
			}

			if (c < 8) {
				if (grille.getCouleur(l, c + 1).equals(coul) && grille.getCouleur(l, c + 2).equals(coul)) {
					for (int i = 0; i < 3; i++) {
						if (grille.getType(l, c + i).equals("BonbonVertical")) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public void reponse(Grille grille) throws CandyException {
		System.out.println("3 bonbons " + grille.getCouleur(ligne, debutColonne) + " dont un rayé à la verticale");
	}

	public void executerCombinaison(Grille grille) throws CandyException {
		for (int i = debutColonne; i < debutColonne + 3; i++) {
			if (grille.getType(ligne, i).equals("BonbonSimple")) {
				// si bonbon non rayé, on explose juste le bonbon
				grille.exploser(ligne, i);
			} else {
				// sinon on explose toute la colonne
				for (int j = 0; j < TAILLE - 1; j++)
					grille.exploser(j, i);
			}
		}
	}

	@Override
	public String toString() {
		return "TroisHorizontauxRayesV [debutColonne=" + debutColonne + ", ligne=" + ligne + ", colonnesARayer=" + "]";
	}
}
