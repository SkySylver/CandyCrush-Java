package detecteur;

import combinaison.Combinaison;
import combinaison.TroisVerticauxRayesV;
import exceptions.CandyException;
import grille.Grille;


/**
 * Détecte TROIS BONBONS ALIGNES VERTICALEMENT DONT UN RAYE A LA VERTICALE
 * @see Detecteur
 */
public class DTroisVerticauxRayesV extends Detecteur {
	private int debutLigne;
	private int colonne;

	public DTroisVerticauxRayesV(Detecteur d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Detecteur#combinaisonExiste(int, int, Grille)
	 */
	public Combinaison combinaisonExiste(int l, int c, Grille grille) throws CandyException {

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple") || t.contentEquals("BonbonVertical")) {

			while (l > 0 && grille.getCouleur(l - 1, c).equals(coul)) {
				l--;
			}

			if (l < grille.getTaille()-2) {
				if (grille.getCouleur(l + 1, c).equals(coul) && grille.getCouleur(l + 2, c).equals(coul)) {
					if (grille.getType(l, c).equals("BonbonVertical")
							|| grille.getType(l + 1, c).equals("BonbonVertical")
							|| grille.getType(l + 2, c).equals("BonbonVertical")) {
						colonne = c;
						return new TroisVerticauxRayesV(colonne);
					}
				}
			}
		}

		return null;
	}
	public void reponse(Grille grille) throws CandyException {
		System.out.println("3 bonbons " + grille.getCouleur(debutLigne, colonne) + " dont un rayé à la verticale");
	}

	@Override
	public String toString() {
		return "DTroisVerticauxRayesV [debutLigne=" + debutLigne + ", colonne=" + colonne + "]";
	}
}
