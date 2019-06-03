package detecteur;

import combinaison.Combinaison;
import combinaison.TroisHorizontauxRayesH;
import exceptions.CandyException;
import grille.Grille;

/**
 * Détecte TROIS BONBONS ALIGNES HORIZONTALEMENT DONT UN RAYE A L'HORIZONTALE
 * @see Detecteur
 */
public class DTroisHorizontauxRayesH extends Detecteur {
	private int debutColonne;
	private int ligne;

	public DTroisHorizontauxRayesH(Detecteur d) {
		super(d);
	}
	
	/**
	 * @see Detecteur#combinaisonExiste(int, int, Grille)
	 */
	public Combinaison combinaisonExiste(int l, int c, Grille grille) throws CandyException {

		ligne = l;
		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple") || t.contentEquals("BonbonHorizontal")) {

			// on se place sur le bonbon le plus à gauche qui est de la même couleur
			while (c > 0 && grille.getCouleur(l, c - 1).equals(coul)) {
				c--;
			}

			if (c < grille.getTaille()-2) {
				if (grille.getCouleur(l, c + 1).equals(coul) && grille.getCouleur(l, c + 2).equals(coul)) {
					if (grille.getType(l, c).equals("BonbonHorizontal")
							|| grille.getType(l, c + 1).equals("BonbonHorizontal")
							|| grille.getType(l, c + 2).equals("BonbonHorizontal")) {
						debutColonne = c;// cette ligne est utile seulement pour connaître la couleur car
						// de toute façon on va rayer toute la ligne
						return new TroisHorizontauxRayesH(ligne);
					}
				}
			}
		}

		return null;
	}

	public void reponse(Grille grille) throws CandyException {
		System.out.println("3 bonbons " + grille.getCouleur(ligne, debutColonne) + " dont un rayé à l'horizontal");
	}

	@Override
	public String toString() {
		return "DTroisHorizontauxRayesH [debutColonne=" + debutColonne + ", ligne=" + ligne + "]";
	}
}
