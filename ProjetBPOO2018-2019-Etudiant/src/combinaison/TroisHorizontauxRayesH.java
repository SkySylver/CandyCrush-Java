package combinaison;

import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS ALIGNES HORIZONTALEMENT DONT UN RAYE A L'HORIZONTALE
public class TroisHorizontauxRayesH extends Combinaison {
	
	private int debutColonne;
	private int ligne;

	public TroisHorizontauxRayesH(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws CandyException {

		ligne = l;
		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple") || t.contentEquals("BonbonHorizontal")) {

			// on se place sur le bonbon le plus à gauche qui est de la même couleur
			while (c > 0 && grille.getCouleur(l, c - 1).equals(coul)) {
				c--;
			}

			if (c < 8) {
				if (grille.getCouleur(l, c + 1).equals(coul) && grille.getCouleur(l, c + 2).equals(coul)) {
					if (grille.getType(l, c).equals("BonbonHorizontal")
							|| grille.getType(l, c + 1).equals("BonbonHorizontal")
							|| grille.getType(l, c + 2).equals("BonbonHorizontal")) {
						debutColonne = c;// cette ligne est utile seulement pour connaître la couleur car
						// de toute façon on va rayer toute la ligne
						return true;
					}
				}
			}
		}

		return false;
	}

	public void reponse(Grille grille) throws CandyException {
		System.out.println("3 bonbons " + grille.getCouleur(ligne, debutColonne) + " dont un rayé à l'horizontal");
	}
	
	public void executerCombinaison(Grille grille) throws CandyException {
		for(int i = 0; i<TAILLE; i++) {
			grille.exploser(ligne, i);
		}
	}

	@Override
	public String toString() {
		return "TroisHorizontauxRayesH [debutColonne=" + debutColonne + ", ligne=" + ligne + "]";
	}
}
