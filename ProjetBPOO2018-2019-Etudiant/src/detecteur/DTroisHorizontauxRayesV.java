package detecteur;

import combinaison.Combinaison;
import combinaison.TroisHorizontauxRayesV;
import exceptions.CandyException;
import grille.Grille;

/**
 * Détecte TROIS BONBONS ALIGNES HORIZONTALEMENT DONT UN RAYE A L'HORIZONTALE
 * @see Detecteur
 */
public class DTroisHorizontauxRayesV extends Detecteur {
	private int colonne; //juste pour reponse
	private int ligne;

	public DTroisHorizontauxRayesV(Detecteur d) {
		super(d);
	}

	/**
	 * @see Detecteur#combinaisonExiste(int, int, Grille)
	 */
	public Combinaison combinaisonExiste(int l, int c, Grille grille) throws CandyException {

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple") || t.contentEquals("BonbonVertical")) {

			// on se place sur le bonbon le plus à gauche qui est de la même couleur
			while (c > 0 && grille.getCouleur(l, c - 1).equals(coul)) {
				c--;
			}
			ligne = l;
			colonne = c;
			if (c < grille.getTaille()-2) {
				if (grille.getCouleur(l, c + 1).equals(coul) && grille.getCouleur(l, c + 2).equals(coul)) {
					for (int i = 0; i < 3; i++) {
						if (grille.getType(l, c + i).equals("BonbonVertical")) {
							return new TroisHorizontauxRayesV(c, l);
						}
					}
				}
			}
		}
		return null;
	}

	public void reponse(Grille grille) throws CandyException {
		System.out.println("3 bonbons " + grille.getCouleur(ligne, colonne) + " dont un rayé à la verticale");
	}

	@Override
	public String toString() {
		return "DTroisHorizontauxRayesV [colonne=" + colonne + ", ligne=" + ligne + "]";
	}
}
