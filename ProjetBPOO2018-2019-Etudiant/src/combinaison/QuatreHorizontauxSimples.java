package combinaison;

import exceptions.CandyException;
import grille.Grille;

//QUATRE BONBONS SIMPLES ALIGNES HORIZONTALEMENT
public class QuatreHorizontauxSimples extends Combinaison{
	private int debutColonne;
	private int ligne;
	private int colonne;


	public QuatreHorizontauxSimples(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws CandyException{
		// m�me principe que trois bonbons avec un bonbon en plus
		ligne = l;
		colonne = c;
		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple")) {
			
			//on se place sur le bonbon le plus � gauche qui est du m�me type (donc simple) et de m�me couleur
			while (c > 0 && grille.getCouleur(l, c - 1).equals(coul) && grille.getType(l, c - 1).equals(t)) {
				c--;
			}

			if (c < 8) {
				if (grille.getCouleur(l, c + 1).equals(coul) && grille.getCouleur(l, c + 2).equals(coul)
						&& grille.getCouleur(l, c + 3).equals(coul)) {
					if (grille.getType(l, c + 1).equals(t) && grille.getType(l, c + 2).equals(t) 
							&& grille.getType(l, c + 3).equals(t)) {
						debutColonne = c;
						return true;
					}
				}
			}
		}
		
		return false;
	}

	public void executerCombinaison(Grille grille) throws CandyException{	
		System.out.println("4 bonbons " + grille.getCouleur(ligne, debutColonne));
		String coul = grille.getCouleur(ligne, colonne);
		for(int i = debutColonne; i<debutColonne +4; i++)
			grille.vider(ligne,  i);
		grille.putBonbonHorizontal(ligne, colonne, coul);
	}

	public String toString() {
		return "QuatreHorizontauxSimples [debutColonne=" + debutColonne + ", ligne=" + ligne + "]";
	}
}
