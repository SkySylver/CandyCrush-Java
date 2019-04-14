package combinaison;

import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS ALIGNES VERTICALEMENT DONT UN RAYE A L'HORIZONTALE
public class TroisVerticauxRayesH extends Combinaison {

	private int debutLigne;
	private int colonne;

	public TroisVerticauxRayesH(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws CandyException {

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple") || t.contentEquals("BonbonHorizontal")) {

			while (l > 0 && grille.getCouleur(l - 1, c).equals(coul)) {
				l--;
			}

			if (l < 8) {
				if (grille.getCouleur(l + 1, c).equals(coul) && grille.getCouleur(l + 2, c).equals(coul)) {
					for (int i = 0; i < 3; i++) {
						if (grille.getType(l + i, c).equals("BonbonHorizontal")) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public void reponse(Grille grille) throws CandyException {
		System.out.println("3 bonbons " + grille.getCouleur(debutLigne, colonne) + " dont un rayé à l'horizontale");
	}

	public void executerCombinaison(Grille grille) throws CandyException {
		for (int i = debutLigne; i < debutLigne + 3; i++) {
			if (grille.getType(i, colonne).equals("BonbonSimple")) {
				// si le bonbon n'est pas à rayé, on explose juste le bonbon
				grille.exploser(i, colonne);
			} else {
				// sinon on explose toute la colonne
				for (int j = 0; j < TAILLE - 1; j++)
					grille.exploser(i, j);
			}
		}

	}

	@Override
	public String toString() {
		return "TroisVerticauxRayesH [debutLigne=" + debutLigne + ", colonne=" + colonne + ", lignesARayer=" + "]";
	}
}
