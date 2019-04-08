package combinaison;

import exceptions.GrilleException;
import grille.Grille;

public class TroisHorizontauxSimples extends Combinaison {

	private int debut;

	public TroisHorizontauxSimples(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws GrilleException {
		// on sauvegarde la couleur et le type du bonbon concerné
		// puis on décale d'un bonbon vers la gauche tant que le bonbon à gauche est de la même couleur
		
		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);
		
		while(c>0 && grille.getCouleur(l,c-1).equals(coul))
			c--;

		if(c<8) {
			if (grille.getCouleur(l, c + 1).equals(coul) && grille.getCouleur(l, c + 2).equals(coul)
					&& !grille.getCouleur(l, c + 3).equals(coul)) {
				if (grille.getType(l, c + 1).equals(t) && grille.getType(l, c + 2).equals(t)) {
					debut = c;
					return true;
				}
			}
		}	
		
		return false;
	}

	
	public void executerCombinaison(int x, int y, Grille grille) throws Exception {
		for(int i = debut; i<debut+3;i++) {
			
		}
	}
}
