package combinaison;

import exceptions.CandyException;
import grille.Grille;

//QUATRE BONBONS SIMPLES ALIGNES HORIZONTALEMENT
public class QuatreHorizontauxSimples extends Combinaison{
	public QuatreHorizontauxSimples(int dC, int l, int c) {
		debutColonne = dC;
		ligne = l;
		colonne = c;
	}

	public void executerCombinaison(Grille grille) throws CandyException{	
		String coul = grille.getCouleur(ligne, colonne);
		for(int i = debutColonne; i<debutColonne +4; i++)
			grille.exploser(ligne,  i);
		grille.putBonbonHorizontal(ligne, colonne, coul);
	}

	@Override
	public String toString() {
		return "QuatreHorizontauxSimples [debutColonne=" + debutColonne + ", ligne=" + ligne + ", colonne=" + colonne
				+ "]";
	}
}
