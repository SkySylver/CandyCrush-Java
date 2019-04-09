package combinaison;

import exceptions.CandyException;
import grille.Grille;

public class QuatreHorizontauxSimples extends Combinaison{
	private int debutColonne;
	private int ligne;

	public QuatreHorizontauxSimples(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws CandyException{
		// même principe que trois bonbons avec un bonbon en plus

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple")) {
			
			//on se place sur le bonbon le plus à gauche qui est du même type (donc simple) et de même couleur
			while (c > 0 && grille.getCouleur(l, c - 1).equals(coul) && grille.getType(l, c - 1).equals(t)) {
				c--;
			}

			if (c < 8) {
				if (grille.getCouleur(l, c + 1).equals(coul) && grille.getCouleur(l, c + 2).equals(coul)
						&& grille.getCouleur(l, c + 3).equals(coul)) {
					if (grille.getType(l, c + 1).equals(t) && grille.getType(l, c + 2).equals(t) 
							&& grille.getType(l, c + 3).equals(t)) {
						debutColonne = c;
						ligne = l;
						return true;
					}
				}
			}
		}
		
		return false;
	}

	public void executerCombinaison(Grille grille) throws CandyException{	
		System.out.println("4 bonbons horizontaux " + grille.getCouleur(ligne, debutColonne));
		
	}
}
