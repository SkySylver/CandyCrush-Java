package detecteur;

import combinaison.Combinaison;
import combinaison.QuatreHorizontauxSimples;
import exceptions.CandyException;
import grille.Grille;

//QUATRE BONBONS SIMPLES ALIGNES HORIZONTALEMENT
public class DQuatreHorizontauxSimples extends Detecteur{

	private int debutColonne;
	private int ligne;
	private int colonne;

	public DQuatreHorizontauxSimples(Detecteur d) {
		super(d);
	}

	public Combinaison combinaisonExiste(int l, int c, Grille grille) throws CandyException{
		// même principe que trois bonbons avec un bonbon en plus
		ligne = l;
		colonne = c;
		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple")) {
			
			//on se place sur le bonbon le plus à gauche qui est du même type (donc simple) et de même couleur
			while (c > 0 && grille.getCouleur(l, c - 1).equals(coul) && grille.getType(l, c - 1).equals(t)) {
				c--;
			}

			if (c < grille.getTaille()-3) {
				if (grille.getCouleur(l, c + 1).equals(coul) && grille.getCouleur(l, c + 2).equals(coul)
						&& grille.getCouleur(l, c + 3).equals(coul)) {
					if (grille.getType(l, c + 1).equals(t) && grille.getType(l, c + 2).equals(t) 
							&& grille.getType(l, c + 3).equals(t)) {
						debutColonne = c;
						return new QuatreHorizontauxSimples(debutColonne, ligne, colonne);
					}
				}
			}
		}
		
		return null;
	}
	
	public void reponse(Grille grille) throws CandyException {
		System.out.println("4 bonbons " + grille.getCouleur(ligne, debutColonne));
	}

	@Override
	public String toString() {
		return "DQuatreHorizontauxSimples [debutColonne=" + debutColonne + ", ligne=" + ligne + ", colonne=" + colonne
				+ "]";
	}

}
