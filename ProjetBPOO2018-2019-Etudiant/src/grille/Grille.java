package grille;

import bonbon.*;
import combinaison.Combinaison;
import exceptions.CandyException;
import combinaison.*
;
public class Grille {
	private final static int TAILLE = 10;

	private Bonbon[][] grille = new Bonbon[TAILLE][TAILLE];

	public Grille() {
	}

	// grille pour le test, celle qui est d�crite dans ui > CandyCrush.java
	public Grille(boolean test) {

		for (int i = 0; i <= TAILLE - 1; i++) {
			for (int j = 0; j <= TAILLE - 1; j++) {
				grille[i][j] = new Vide();
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
		 * On ajoute 3 bonbons jaunes alignés horizontalement et commençant en (3,3).
		 * Le bonbon du milieu est rayé
		 */
		grille[3][3] = new BonbonSimple("Jaune");
		grille[3][4] = new BonbonHorizontal("Jaune");
		grille[3][5] = new BonbonSimple("Jaune");

		/**
		 * On ajoute 3 bonbons verts alignés verticalement et commençant en (2,2). Le
		 * bonbon du bas est rayé
		 */
		grille[2][2] = new BonbonSimple("Vert");
		grille[3][2] = new BonbonSimple("Vert");
		grille[4][2] = new BonbonVertical("Vert");

		/**
		 * On ajoute 4 bonbons verts alignés verticalement et commençant en (3,6). Le
		 * bonbon du bas est rayé
		 */
		grille[3][6] = new BonbonSimple("Vert");
		grille[4][6] = new BonbonSimple("Vert");
		grille[5][6] = new BonbonSimple("Vert");
		grille[6][6] = new BonbonSimple("Vert");

		/**
		 * On ajoute 4 bonbons jaunes alignés horizontalement et commençant en (7,4).
		 * Le bonbon du bas est rayé
		 */
		grille[7][4] = new BonbonSimple("Jaune");
		grille[7][5] = new BonbonSimple("Jaune");
		grille[7][6] = new BonbonSimple("Jaune");
		grille[7][7] = new BonbonSimple("Jaune");

		/**
		 * On ajoute 9 bonbons au milieu de la grille pour lesquels il n'y a pas de
		 * combinaisons Mais si l'on échange (4,4) et (5,4) alors une combinaison de 3
		 * verts apparaît
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
		 * Si l'on échange ces deux cases, une combinaison de 4 vilets apparaît, donc
		 * bonbon rayé
		 */
		grille[1][6] = new BonbonSimple("Violet");
		grille[1][7] = new BonbonSimple("Bleu");

		/**
		 * Pour afficher la liste des images
		 */
		grille[9][0] = new Vide();
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

	public String getCouleur(int l, int c) throws CandyException {
		if (l > 9 || l < 0 || c > 9 || c < 0)
			throw new CandyException("Bonbon hors de grille !");
		return grille[l][c].getCouleur();
	}

	public String getType(int l, int c) throws CandyException {
		if (l > 9 || l < 0 || c > 9 || c < 0)
			throw new CandyException("Bonbon hors de grille !");
		return grille[l][c].getType();// retourne le type de bonbon
	}

	// Verifie s'il y a des combinaisons de bonbons + les explose + refait tomber
	public void actualiser() {

	}

<<<<<<< HEAD

	public void Exploser(int x, int y) {
=======
	public void exploser(int x, int y) {
>>>>>>> branch 'master' of https://gitlab.com/nsUsta/candy.git
		switch (grille[x][y].getType()) {
		case "BonbonSimple":
			grille[x][y] = new Vide();
			break;

		case "BonbonHorizontal":
			for (int i = 0; i < TAILLE; i++) {
				grille[i][y] = new Vide();
			}
			break;
		case "BonbonVertical":
			for (int i = 0; i < TAILLE; i++) {
				grille[x][i] = new Vide();
			}
			break;
		}
	}

	// Fait tomber les bonbons de chaque colonnes + Actualise
	public void tomber() {
		for (int i = 0; i < TAILLE; i++) {

		}
	}

	// remplacer 9 par MAX et 0 par MIN
	public void echange(int ls, int cs, int lt, int ct) throws CandyException {
		if (ls > 9 || cs > 9 || lt > 9 || ct > 9 || ls < 0 || cs < 0 || lt < 0 || ct < 0)
			throw new CandyException("Coordonn�es incorrectes");
		if (getType(ls, cs).equals("Meringue") || getType(lt, ct).equals("Meringue"))
			throw new CandyException("Echange avec Meringue");
		if (getType(ls, cs).equals("Vide") || getType(lt, ct).equals("Vide"))
			throw new CandyException("Echange avec Vide");

		// On echange les bonbons
		Bonbon temp = grille[ls][cs];
		grille[ls][cs] = grille[lt][ct];
		grille[lt][ct] = temp;

		// Si aucune combinaison n'est d�tect�e on remet les bonbons � leurs places et
		// on jette une exception
		Combinaison comb = null;
		comb = Combinaison.initCombinaisons();
		if (!comb.detecter(ls, cs, this) && !comb.detecter(lt, ct, this)) {
			temp = grille[ls][cs];
			grille[ls][cs] = grille[lt][ct];
			grille[lt][ct] = temp;
			throw new CandyException("Aucune combinaison apres echange");
		}
	}
}
