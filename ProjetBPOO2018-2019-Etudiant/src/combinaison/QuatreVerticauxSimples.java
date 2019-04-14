package combinaison;

import exceptions.CandyException;
import grille.Grille;

//QUATRE BONBONS SIMPLES ALIGNES VERTICALEMENT
public class QuatreVerticauxSimples extends Combinaison {
	private int debutLigne;
	private int colonne;

	public QuatreVerticauxSimples(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws CandyException {
		// même principe que QuatreHorizontauxSimples

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple")) {

			while (l > 0 && grille.getCouleur(l - 1, c).equals(coul) && grille.getType(l - 1, c).equals(t)) {
				l--;
			}

			if (l < 8) {
				if (grille.getCouleur(l + 1, c).equals(coul) && grille.getCouleur(l + 2, c).equals(coul)
						&& grille.getCouleur(l + 3, c).equals(coul)) {
					if (grille.getType(l + 1, c).equals(t) && grille.getType(l + 2, c).equals(t)
							&& grille.getType(l + 3, c).equals(t)) {
						debutLigne = l;
						colonne = c;
						return true;
					}
				}
			}
		}

		return false;
	}

	public void reponse(Grille grille) throws CandyException {
		System.out.println("4 bonbons " + grille.getCouleur(debutLigne, colonne));
	}
	
	public void executerCombinaison(Grille grille) throws CandyException {

	}

	@Override
	public String toString() {
		return "QuatreVerticauxSimples [debutLigne=" + debutLigne + ", colonne=" + colonne + "]";
	}
}
