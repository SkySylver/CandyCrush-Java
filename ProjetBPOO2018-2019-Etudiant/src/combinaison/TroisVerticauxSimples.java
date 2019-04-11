package combinaison;

import exceptions.CandyException;
import grille.Grille;

//TROIS BONBONS SIMPLES ALIGNES VERTICALEMENT
public class TroisVerticauxSimples extends Combinaison {
	private int debutLigne;
	private int colonne;

	public TroisVerticauxSimples(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws CandyException{
		// même principe que dans TroisHorizontauxSimples

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple")) {
			while (l > 0 && grille.getCouleur(l - 1, c).equals(coul) && grille.getType(l - 1, c).equals(t))
				l--;

			if (l < 8) {
				if (grille.getCouleur(l + 1, c).equals(coul) && grille.getCouleur(l + 2, c).equals(coul)) {
					if (grille.getType(l + 1, c).equals(t) && grille.getType(l + 2, c).equals(t)) {
						debutLigne = l;
						colonne = c;
						return true;
					}
				}
			}
		}

		return false;
	}

	public void executerCombinaison(Grille grille) throws CandyException {

		System.out.println("3 bonbons " + grille.getCouleur(debutLigne, colonne));
	}
}
