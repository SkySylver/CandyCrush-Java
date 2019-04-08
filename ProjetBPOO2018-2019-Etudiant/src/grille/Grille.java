package grille;

import bonbon.*;
import exceptions.GrilleException;

public class Grille {
	private final static int TAILLE = 10;

	private Bonbon[][] grille = new Bonbon[10][10];

	public Grille() {
	}
	
	//grille pour le test, celle qui est d�crite dans ui > CandyCrush.java
	public Grille(boolean test) {
		
		for (int i = 0; i <= TAILLE - 1; i++) {
			for (int j = 0; j <= TAILLE - 1; j++) {
				grille[i][j] = new Mur();
			}
		}
		
		
		/**
		 * On ajoute 3 bonbons bleus alignés horizontalement et commençant en (2,4)
		 */
		grille[2][4] = new BonbonSimple("Bleu");
		grille[2][5] = new BonbonSimple("Bleu");
		grille[2][6] = new BonbonSimple("Bleu");
		
		/**
		 * On ajoute 3 bonbons violets alignés verticalement et commençant en (2,7)
		 */
		grille[2][7] = new BonbonSimple("Violet");
		grille[3][7] = new BonbonSimple("Violet");
		grille[4][7] = new BonbonSimple("Violet");
		
		/**
		 * On ajoute 3 bonbons jaunes alignés horizontalement et commençant en (3,3). Le bonbon du milieu est rayé
		 */
		grille[3][3] = new BonbonSimple("Jaune");
		grille[3][4] = new BonbonHorizontal("Jaune");
		grille[3][5] = new BonbonSimple("Jaune");
		
		
		/**
		 * On ajoute 3 bonbons verts alignés verticalement et commençant en (2,2). Le bonbon du bas est rayé
		 */
		grille[2][2] = new BonbonSimple("Vert");
		grille[3][2] = new BonbonVertical("Vert");
		grille[4][2] = new BonbonSimple("Vert");

		/**
		 * On ajoute 4 bonbons verts alignés verticalement et commençant en (3,6). Le bonbon du bas est rayé
		 */
		grille[3][6] = new BonbonSimple("Vert");
		grille[4][6] = new BonbonSimple("Vert");
		grille[5][6] = new BonbonSimple("Vert");
		grille[6][6] = new BonbonSimple("Vert"); 	
		
		/**
		 * On ajoute 4 bonbons jaunes alignés horizontalement et commençant en (7,4). Le bonbon du bas est rayé
		 */
		grille[7][4] = new BonbonSimple("Jaune");
		grille[7][5] = new BonbonSimple("Jaune");
		grille[7][6] = new BonbonSimple("Jaune");
		grille[7][7] = new BonbonSimple("Jaune"); 

		/**
		 * On ajoute 9 bonbons au milieu de la grille pour lesquels il n'y a pas de combinaisons
		 * Mais si l'on échange (4,4) et (5,4) alors une combinaison de 3 verts apparaît
		 */
		grille[4][3] = new BonbonSimple("Jaune");
		grille[4][4] = new BonbonSimple("Vert");
		grille[4][5] = new BonbonSimple("Violet");
		grille[5][3] = new BonbonSimple("Bleu");
		grille[5][4] = new BonbonSimple("Bleu");
		grille[5][5] = new BonbonSimple("Vert");		
		grille[6][3] = new BonbonSimple("Bleu");
		grille[6][4] = new BonbonSimple("Jaune");
		grille[6][5] = new BonbonSimple("Violet");
		
		/**
		 * On place une meringue en (3,8)
		 */
		grille[3][8] = new Meringue();
		
		/**
		 * Si l'on échange ces deux cases, une combinaison de 4 vilets apparaît, donc bonbon rayé
		 */
		grille[1][6] = new BonbonSimple("Violet");
		grille[1][7] = new BonbonSimple("Bleu");
		
		
		
		/** 
		 * Pour afficher la liste des images
		 */
		grille[9][0] = new Mur();
		grille[9][1] = new BonbonSimple("Bleu");
		grille[9][2] = new BonbonSimple("Violet");
		grille[9][3] = new BonbonSimple("Jaune");
		grille[9][4] = new BonbonSimple("Vert");
		grille[9][5] = new BonbonHorizontal("Bleu");
		grille[9][6] = new BonbonHorizontal("Violet");
		grille[9][7] = new BonbonHorizontal("Jaune");
		grille[9][8] = new BonbonVertical("Vert");
		grille[9][9] = new Meringue();
		
	}

	// Pourquoi ne pas faire directement g[x][y].getCouleur ??
	// parce qu'on prend une classe Grille (Grille grille) en entr�e qui elle m�me d�clare
	// une grille de Bonbon (Bonbon[][] g) en private donc on peut pas faire
	// grille.g[x][y].getCouleur(); � cause du private
	// et m�me en le mettant en public ce serait moins lisible
	public String getCouleur(int x, int y) throws GrilleException {
		if (getType(x, y).equals("Vide"))
			throw new GrilleException("Couleur vide demand�e !");
		return grille[x][y].getCouleur();
	}

	// Pourquoi ne pas faire directement g[x][y].getType ??
	public String getType(int x, int y) {

		return grille[x][y].getType();// retourne le type de bonbon
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
