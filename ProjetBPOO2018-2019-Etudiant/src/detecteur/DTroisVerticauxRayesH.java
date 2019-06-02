package detecteur;

import combinaison.Combinaison;
import combinaison.TroisVerticauxRayesH;
import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS ALIGNES VERTICALEMENT DONT UN RAYE A L'HORIZONTALE
public class DTroisVerticauxRayesH extends Detecteur {
	private int ligne;
	private int colonne;
	
	public DTroisVerticauxRayesH(Detecteur d) {
		super(d);
	}

	public Combinaison combinaisonExiste(int l, int c, Grille grille) throws CandyException {

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple") || t.contentEquals("BonbonHorizontal")) {

			while (l > 0 && grille.getCouleur(l - 1, c).equals(coul)) {
				l--;
			}
			ligne = l;
			colonne = c;

			if (l < grille.getTaille()-2) {
				if (grille.getCouleur(l + 1, c).equals(coul) && grille.getCouleur(l + 2, c).equals(coul)) {
					for (int i = 0; i < 3; i++) {
						if (grille.getType(l + i, c).equals("BonbonHorizontal")) {
							return new TroisVerticauxRayesH(l, c);
						}
					}
				}
			}
		}

		return null;
	}

	public void reponse(Grille grille) throws CandyException {
		System.out.println("3 bonbons " + grille.getCouleur(ligne, colonne) + " dont un rayé à l'horizontale");
	}
	
	@Override
	public String toString() {
		return "DTroisVerticauxRayesH [ligne=" + ligne + ", colonne=" + colonne + "]";
	}
}
