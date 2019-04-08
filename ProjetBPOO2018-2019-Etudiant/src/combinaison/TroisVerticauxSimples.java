package combinaison;

import grille.Grille;
import grille.GrilleException;

public class TroisVerticauxSimples extends Combinaison {
	private int debut;

	public TroisVerticauxSimples(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws GrilleException {
		// même principe que dans TroisHorizontauxSimples

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		while (l > 0 && grille.getCouleur(l - 1, c).equals(coul))
			l--;

		if (l < 8) {
			if (grille.getCouleur(l + 1, c).equals(coul) && grille.getCouleur(l + 2, c).equals(coul)
					&& !grille.getCouleur(l + 3, c).equals(coul)) {
				if (grille.getType(l + 1, c).equals(t) && grille.getType(l + 2, c).equals(t)) {
					debut = l;
					return true;
				}
			}
		}

		return false;
	}

	public void executerCombinaison(int x, int y, Grille grille) throws Exception {
		for (int i = debut; i < debut + 3; i++) {

		}
	}
}
