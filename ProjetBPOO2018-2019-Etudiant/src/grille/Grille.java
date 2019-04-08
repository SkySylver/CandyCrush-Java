package grille;

import bonbon.*;
import exceptions.GrilleException;

public class Grille {
	private final static int TAILLE = 10;

	private Bonbon[][] g;

	public Grille() {
		for (int i = 0; i <= TAILLE - 1; i++) {
			for (int j = 0; j <= TAILLE - 1; j++) {
				g[i][j] = new BonbonSimple();
			}
		}
	}

	// Pourquoi ne pas faire directement g[x][y].getCouleur ??
	// parce qu'on prend une classe Grille (grille) en entrée qui elle même déclare
	// une grille de Bonbon (Bonbon[][] g) en private donc on peut pas faire
	// grille.g[x][y].getCouleur(); à cause du private
	// et même en le mettant en public ce serait moins lisible
	public String getCouleur(int x, int y) throws GrilleException {
		if (getType(x, y).equals("Vide"))
			throw new GrilleException("Couleur vide demandée !");
		return g[x][y].getCouleur();
	}

	// Pourquoi ne pas faire directement g[x][y].getType ??
	public String getType(int x, int y) {

		return g[x][y].getType();// retourne le type de bonbon
	}

	// Verifie s'il y a des combinaisons de bonbons + les explose + refait tomber
	public void Actualiser() {

	}

	// Fait tomber les bonbons de chaque colonnes + Actualise
	public void Tomber() {
		for (int i = 0; i < TAILLE; i++) {

		}
	}
}
