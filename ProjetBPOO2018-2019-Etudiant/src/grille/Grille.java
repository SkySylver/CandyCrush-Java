package grille;

import bonbon.*;
import exceptions.GrilleException;

public class Grille {
	private final static int taille = 10;

	private Bonbon[][] g;

	public Grille() {

		for (int i = 0; i <= taille - 1; i++) {
			for (int j = 0; j <= taille - 1; j++) {
				g[i][j] = new BonbonSimple();
			}
		}
	}
	
	public void Actualiser() {
		
		
	}
	
	public void Tomber() {
		
		
	}
	
	public String getCouleur(int x, int y) throws GrilleException{
		if(getType(x, y).equals("Vide"))
			throw new GrilleException("Couleur vide demandée !");
		return g[x][y].getCouleur();
	}
	
	public String getType(int x, int y) {
		
		return g[x][y].getType();// retourne le type de bonbon
	}

}
