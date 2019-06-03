package grille;

import java.util.ArrayList;
import java.util.List;

import bonbon.*;
import detecteur.Detecteur;
import exceptions.CandyException;
import javafx.scene.image.Image;

/**
 * Grille de bonbons du jeu.
 * 
 */
public class Grille {
	private int TAILLE = 10;

	private Bonbon[][] grille;

	/**
	 * Crée une Grille avec des bonbons générés aléatoirement
	 */
	public Grille() {
		for (int i = 0; i <= TAILLE - 1; i++) {
			for (int j = 0; j <= TAILLE - 1; j++) {
				grille[i][j] = new BonbonSimple();
			}
		}
	}

	/**
	 * Crée une Grille avec des bonbons qui sont décrits dans un fichier .csv
	 *		
	 * LE FICHIER .csv doit être agencé de cette manière: ModeDeJeu, entier
	 * 
	 * TAILLE, entier 
	 * entier, entier, ..., entier 
	 * entier, entier, ..., entier 
	 * ... 
	 * entier, entier, ..., entier
	 * @throws Exception
	 */
	public Grille(List<String> input) throws Exception {

System.out.println(input.get(0));
		String mode[] = input.get(0).split(";");
		TAILLE = Integer.parseInt(mode[1]);
		grille = new Bonbon[TAILLE][TAILLE];
		
		linesToGrille((ArrayList<String>) input);
	}

	/*
	 * Génère la grille à partir d'entiers
	 */
	public void linesToGrille(ArrayList<String> lines) throws CandyException {
		/*
		 * 0: Vide 1: Meringue 2: Bleu simple 3: Bleu Horizontal 4: Bleu Vertical 5:
		 * Vert simple 6: Vert Horizontal 7: Vert Vertical 8: Jaune simple 9: Jaune
		 * Horizontal 10: Jaune Vertical 11: Violet simple 12: Violet Horizontal 13:
		 * Viole Vertical
		 */

		for (int i = 0; i <= TAILLE - 1; i++) {
			System.out.println(lines.get(i));
			String[] values = lines.get(i+1).split(";");

			for (int j = 0; j <= TAILLE - 1; j++) {
				switch (Integer.parseInt(values[j])) {
				case 0:
					grille[i][j] = new Vide();
					break;
				case 1:
					grille[i][j] = new Meringue();
					break;
				case 2:
					grille[i][j] = new BonbonSimple("Bleu");
					break;
				case 3:
					grille[i][j] = new BonbonHorizontal("Bleu");
					break;
				case 4:
					grille[i][j] = new BonbonVertical("Bleu");
					break;
				case 5:
					grille[i][j] = new BonbonSimple("Vert");
					break;
				case 6:
					grille[i][j] = new BonbonHorizontal("Vert");
					break;
				case 7:
					grille[i][j] = new BonbonVertical("Vert");
					break;
				case 8:
					grille[i][j] = new BonbonSimple("Jaune");
					break;
				case 9:
					grille[i][j] = new BonbonHorizontal("Jaune");
					break;
				case 10:
					grille[i][j] = new BonbonVertical("Jaune");
					break;
				case 11:
					grille[i][j] = new BonbonSimple("Violet");
					break;
				case 12:
					grille[i][j] = new BonbonHorizontal("Violet");
					break;
				case 13:
					grille[i][j] = new BonbonVertical("Violet");
					break;
				default:
					grille[i][j] = new BonbonSimple();
					break;
				}
			}
		}
	}

	/**
	 * Grille par défaut pour les tests (dans ui > CandyCrush.java)
	 * 
	 * @param test :
	 */
	public Grille(boolean test) {
		for (int i = 0; i <= TAILLE - 1; i++) {
			for (int j = 0; j <= TAILLE - 1; j++) {
				grille[i][j] = new Vide();
			}
		}

		/**
		 * On ajoute 3 bonbons bleus alignÃ©s horizontalement et commenÃ§ant en (2,4)
		 */

		grille[2][4] = new BonbonSimple("Bleu");
		grille[2][5] = new BonbonSimple("Bleu");
		grille[2][6] = new BonbonSimple("Bleu");

		/**
		 * On ajoute 3 bonbons violets alignÃ©s verticalement et commenÃ§ant en (2,7)
		 */
		grille[2][7] = new BonbonSimple("Violet");
		grille[3][7] = new BonbonSimple("Violet");
		grille[4][7] = new BonbonSimple("Violet");

		/**
		 * On ajoute 3 bonbons jaunes alignÃ©s horizontalement et commenÃ§ant en (3,3).
		 * Le bonbon du milieu est rayÃ©
		 */
		grille[3][3] = new BonbonSimple("Jaune");
		grille[3][4] = new BonbonHorizontal("Jaune");
		grille[3][5] = new BonbonSimple("Jaune");

		/**
		 * On ajoute 3 bonbons verts alignÃ©s verticalement et commenÃ§ant en (2,2). Le
		 * bonbon du bas est rayÃ©
		 */
		grille[2][2] = new BonbonSimple("Vert");
		grille[3][2] = new BonbonSimple("Vert");
		grille[4][2] = new BonbonVertical("Vert");

		/**
		 * On ajoute 4 bonbons verts alignÃ©s verticalement et commenÃ§ant en (3,6). Le
		 * bonbon du bas est rayÃ©
		 */
		grille[3][6] = new BonbonSimple("Vert");
		grille[4][6] = new BonbonSimple("Vert");
		grille[5][6] = new BonbonSimple("Vert");
		grille[6][6] = new BonbonSimple("Vert");

		/**
		 * On ajoute 4 bonbons jaunes alignÃ©s horizontalement et commenÃ§ant en (7,4).
		 * Le bonbon du bas est rayÃ©
		 */
		grille[7][4] = new BonbonSimple("Jaune");
		grille[7][5] = new BonbonSimple("Jaune");
		grille[7][6] = new BonbonSimple("Jaune");
		grille[7][7] = new BonbonSimple("Jaune");

		/**
		 * On ajoute 9 bonbons au milieu de la grille pour lesquels il n'y a pas de
		 * combinaisons Mais si l'on Ã©change (4,4) et (5,4) alors une combinaison de 3
		 * verts apparaÃ®t
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
		 * Si l'on Ã©change ces deux cases, une combinaison de 4 vilets apparaÃ®t, donc
		 * bonbon rayÃ©
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

	/**
	 * Permet d'obtenir la couleur du Bonbon dans la Grille au coordonnées l, c
	 * 
	 * @param l : Numéro de ligne du Bonbon
	 * @param c : Numéro de colonne du Bonbon
	 * @return l'image lié à la position l, c dans Grille
	 * @throws CandyException : si les coordonnées ne sont pas dans la Grille
	 */
	public Image getImage(int l, int c) throws CandyException {
		if (l > 9 || l < 0 || c > 9 || c < 0)
			throw new CandyException("Bonbon hors de grille !");
		return grille[l][c].getImage();
	}

	/**
	 * Permet d'obtenir la couleur du Bonbon dans la Grille au coordonnées l, c
	 * 
	 * @param l : Numéro de ligne du Bonbon
	 * @param c : Numéro de colonne du Bonbon
	 * @return l'image lié à la position l, c dans Grille
	 * @throws CandyException : si les coordonnées ne sont pas dans la Grille
	 */
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

	public boolean isRaye(int x, int y) {
		return grille[x][y].isRaye();
	}

	public void exploser(int l, int c) throws CandyException {
		if (l >= TAILLE || c >= TAILLE || l < 0 || c < 0)
			throw new CandyException("Coordonnées incorrectes");
		grille[l][c] = new Vide();
	}

	// Fait tomber les bonbons de chaque colonnes + recomplete ce qu'il manque
	public void tomber() {
		int a;
		for (int i = 0; i < TAILLE; i++) { // Pour x de 0 a 9 (chaque colonne)
			for (int j = TAILLE - 1; j >= 0; j--) { // Pour chaque case dans la colonne
				a = 0;
				while (grille[j][i].getType().equals("Vide") && a < TAILLE - j) { // Tant que la case est vide
					// Descend tous les elements de la colonne de 1
					a++;
					for (int c = j; c > 0; c--)
						grille[c][i] = grille[c - 1][i];
				}
			}
		}
	}

	public void completer() {
		for (int i = 0; i < TAILLE; i++)
			for (int j = 0; j < TAILLE; j++)
				if (grille[i][j].getType().equals("Vide"))
					grille[i][j] = new BonbonSimple();
	}

	public boolean echange(int ls, int cs, int lt, int ct) throws CandyException {
		if (ls >= TAILLE || cs >= TAILLE || lt >= TAILLE || ct >= TAILLE || ls < 0 || cs < 0 || lt < 0 || ct < 0)
			throw new CandyException("Coordonnées incorrectes");
		if ((Math.abs(ls - lt) + Math.abs(cs - ct)) != 1)
			throw new CandyException("Case inaccessible");
		if (getType(ls, cs).equals("Meringue") || getType(lt, ct).equals("Meringue"))
			throw new CandyException("Echange avec Meringue");
		if (getType(ls, cs).equals("Vide") || getType(lt, ct).equals("Vide"))
			throw new CandyException("Echange avec Vide");

		// On echange les bonbons
		Bonbon temp = grille[ls][cs];
		grille[ls][cs] = grille[lt][ct];
		grille[lt][ct] = temp;

		// Si aucune combinaison n'est détectée on remet les bonbons à leurs places et
		// on jette une exception
		Detecteur d = null;
		d = Detecteur.initDetecteurs();
		if (d.detecter(ls, cs, this) == null && d.detecter(lt, ct, this) == null) {
			temp = grille[ls][cs];
			grille[ls][cs] = grille[lt][ct];
			grille[lt][ct] = temp;
			return false;
			// throw new CandyException("Aucune combinaison apres echange");
		}
		return true;
	}

	public void putBonbonHorizontal(int l, int c, String coul) throws CandyException {
		if (l >= TAILLE || c >= TAILLE || l < 0 || c < 0)
			throw new CandyException("Coordonnées incorrectes");
		grille[l][c] = new BonbonHorizontal(coul);
	}

	public void putBonbonVertical(int l, int c, String coul) throws CandyException {
		if (l >= TAILLE || c >= TAILLE || l < 0 || c < 0)
			throw new CandyException("Coordonnées incorrectes");
		grille[l][c] = new BonbonVertical(coul);
	}

	public void setTaille(int n) {
		TAILLE = n;
	}

	public int getTaille() {
		return TAILLE;
	}

}
