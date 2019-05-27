package detecteur;

import combinaison.Combinaison;
import combinaison.QuatreVerticauxSimples;
import exceptions.CandyException;
import grille.Grille;

//QUATRE BONBONS SIMPLES ALIGNES VERTICALEMENT
public class DQuatreVerticauxSimples extends Detecteur {
	

	private int debutLigne;
	private int ligne;
	private int colonne;

	public DQuatreVerticauxSimples(Detecteur d) {
		super(d);
	}

	public Combinaison combinaisonExiste(int l, int c, Grille grille) throws CandyException {
		// m�me principe que QuatreHorizontauxSimples

		ligne = l;
		colonne = c;		
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
						return new QuatreVerticauxSimples(debutLigne, ligne, colonne);
					}
				}
			}
		}

		return null;
	}

	public void reponse(Grille grille) throws CandyException {
		System.out.println("4 bonbons " + grille.getCouleur(debutLigne, colonne));
	}

	@Override
	public String toString() {
		return "QuatreVerticauxSimples [debutLigne=" + debutLigne + ", colonne=" + colonne + "]";
	}
}
