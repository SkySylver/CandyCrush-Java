package combinaison;

import exceptions.GrilleException;
import grille.Grille;

public class TroisVerticauxSimples extends Combinaison {
	private int debutLigne;
	private int colonne;

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
					debutLigne = l;
					colonne = c;
					return true;
				}
			}
		}

		return false;
	}

	public void executerCombinaison(Grille grille) throws Exception {
		/*for (int i = debut; i < debut + 3; i++) {

		}
		*/
		int fin = debutLigne + 3;

		System.out.println("Combinaison horizontale détectée de " + debutLigne + " à " + fin + " colonne" + colonne);

	}
}
