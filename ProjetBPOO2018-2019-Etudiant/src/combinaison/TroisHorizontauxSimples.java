package combinaison;

import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS SIMPLES ALIGNES HORIZONTALEMENT
public class TroisHorizontauxSimples extends Combinaison {

	private int debutColonne;
	private int ligne;

	public TroisHorizontauxSimples(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws CandyException {
		// on sauvegarde la couleur et le type du bonbon concerné
		// puis on décale d'un bonbon vers la gauche tant que le bonbon à gauche est de
		// la même couleur et du même type

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple")) {
			
			//on se place sur le bonbon le plus à gauche qui est du même type (donc simple) et de même couleur
			while (c > 0 && grille.getCouleur(l, c - 1).equals(coul) && grille.getType(l, c - 1).equals(t)) {
				c--;
			}

			if (c < 8) {
				if (grille.getCouleur(l, c + 1).equals(coul) && grille.getCouleur(l, c + 2).equals(coul)) {
					if (grille.getType(l, c + 1).equals(t) && grille.getType(l, c + 2).equals(t)) {
						debutColonne = c;
						ligne = l;
						return true;
					}
				}
			}
		}
		
		return false;
	}

	public void executerCombinaison(Grille grille) throws CandyException {
		
		System.out.println("3 bonbons " + grille.getCouleur(ligne, debutColonne));
		
	}
}
