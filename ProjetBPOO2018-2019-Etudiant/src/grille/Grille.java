package grille;

import bonbon.Bonbon;
import bonbon.BonbonSimple;

public class Grille {
	private final static int taille = 10;

	private Bonbon[][] g = new Bonbon[taille][taille];

	public Grille() {

		for (int i = 0; i <= taille - 1; i++) {
			for (int j = 0; j <= taille - 1; j++) {
				do {
					g[i][j] = new BonbonSimple();
				}while(Verifier(g, i, j));
			}

		}
		
	}
	
	public boolean Verifier(Bonbon[][] grille, int i, int j) {
		return false;
		
		//Verifier ligne
		//Verifier colonne
		
	}

	public void Echanger() {
		
		
	}
}
