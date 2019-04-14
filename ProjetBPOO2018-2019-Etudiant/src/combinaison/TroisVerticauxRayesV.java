package combinaison;

import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS ALIGNES VERTICALEMENT DONT UN RAYE A LA VERTICALE
public class TroisVerticauxRayesV extends Combinaison {

	private int debutLigne;
	private int colonne;
	public TroisVerticauxRayesV(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws CandyException {

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple") || t.contentEquals("BonbonVertical")) {

			while (l > 0 && grille.getCouleur(l - 1, c).equals(coul)) {
				l--;
			}

			if (l < 8) {
				if (grille.getCouleur(l + 1, c).equals(coul) && grille.getCouleur(l + 2, c).equals(coul)) {
					if (grille.getType(l, c).equals("BonbonVertical")
							|| grille.getType(l + 1, c).equals("BonbonVertical")
							|| grille.getType(l + 2, c).equals("BonbonVertical")) {
						colonne = c;
						return true;
					}
				}
			}
		}

		return false;
	}
	public void reponse(Grille grille) throws CandyException {
		System.out.println("3 bonbons " + grille.getCouleur(debutLigne, colonne) + " dont un rayé à la verticale");
	}

	public void executerCombinaison(Grille grille) throws CandyException {
		for(int i = 0; i<TAILLE-1; i++) {
			grille.exploser(i, colonne);
		}
	}

	@Override
	public String toString() {
		return "TroisVerticauxRayesV [debutLigne=" + debutLigne + ", colonne=" + colonne + "]";
	}
}
