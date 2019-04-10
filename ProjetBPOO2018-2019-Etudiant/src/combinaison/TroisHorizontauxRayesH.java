package combinaison;

import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS SIMPLES ALIGNES HORIZONTALEMENT
public class TroisHorizontauxRayesH extends Combinaison {

	private int debutColonne;
	private int ligne;

	public TroisHorizontauxRayesH(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws CandyException {
		// on sauvegarde la couleur et le type du bonbon concern�
		// puis on d�cale d'un bonbon vers la gauche tant que le bonbon � gauche est de
		// la m�me couleur et du m�me type

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple") || t.contentEquals("BonbonHorizontal")) {

			// on se place sur le bonbon le plus � gauche qui est de la m�me couleur
			while (c > 0 && grille.getCouleur(l, c - 1).equals(coul)) {
				c--;
			}

			if (c < 8) {
				if (grille.getCouleur(l, c + 1).equals(coul) && grille.getCouleur(l, c + 2).equals(coul)) {
					if (grille.getType(l, c).equals("BonbonHorizontal")
							|| grille.getType(l, c + 1).equals("BonbonHorizontal")
							|| grille.getType(l, c + 2).equals("BonbonHorizontal")) {
						debutColonne = c;// cette ligne est utile seulement pour conna�tre la couleur car
						// de toute fa�on on va rayer toute la ligne
						ligne = l;
						return true;
					}
				}
			}
		}

		return false;
	}

	public void executerCombinaison(Grille grille) throws CandyException {

		System.out.println("3 bonbons " + grille.getCouleur(ligne, debutColonne) + " dont un ray� � l'horizontal");

	}
}
