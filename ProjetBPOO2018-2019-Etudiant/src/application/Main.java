package application;

import java.util.Scanner;

import combinaison.Combinaison;
import detecteur.Detecteur;
import exceptions.CandyException;
import grille.Grille;
import interf.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	private static Detecteur mesComb = null;

	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		MenuController Menu = new MenuController(primaryStage, System.getProperty("user.dir") + "/plateaux/");
		Menu.start();
	}

	/**
	 * Tests pour la soutenance 1
	 * @param grille : Grille de tests (ui)
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static void tests(Grille grille) throws Exception {

		// Test consultations de base
		System.out.println("\tConsultations de base: \n");
		System.out.println("Couleur du bonbon en (3,2): " + grille.getCouleur(3, 2));
		System.out.println("Type du bonbon (3,2): " + grille.getType(3, 2));
		System.out.println("Couleur du bonbon en (4,2): " + grille.getCouleur(4, 2));
		System.out.println("Type du bonbon (4,2): " + grille.getType(4, 2));
		System.out.println("Couleur du bonbon en (3,8): " + grille.getCouleur(3, 8));
		System.out.println("Type du bonbon (3,8): " + grille.getType(3, 8));
		System.out.println("Couleur du bonbon en (3,0): " + grille.getCouleur(3, 0));
		System.out.println("Type du bonbon (3,0): " + grille.getType(3, 0));
		System.out.println("Couleur du bonbon en (3,10): ");
		try {
			grille.getCouleur(3, 10);
		} catch (CandyException e) {
			e.printStackTrace();
		}
		System.out.println("Type du bonbon (3,10): ");
		try {
			grille.getType(3, 10);
		} catch (CandyException e) {
			e.printStackTrace();
		}

		// Test d�tection des Combinaisons
		System.out.println("\n\tD�tection des Combinaisons: \n");
		System.out.print("Combinaison en (3,2):");
		mesComb.detecter(3, 2, grille);
		System.out.print("Combinaison en (3,3):");
		mesComb.detecter(3, 3, grille);
		System.out.print("Combinaison en (2,4):");
		mesComb.detecter(2, 4, grille);
		System.out.print("Combinaison en (2,7):");
		mesComb.detecter(2, 7, grille);
		System.out.print("Combinaison en (6,6):");
		mesComb.detecter(6, 6, grille);
		System.out.print("Combinaison en (7,6):");
		mesComb.detecter(7, 6, grille);
		System.out.print("Combinaison en (5,4):");
		mesComb.detecter(5, 4, grille);

		// Test �changes
		System.out.println("\n\n\tTest des �changes :\n");
		System.out.println("Echange de (4,4)et (5,4): ");
		System.out.print("Apparition de: ");
		grille.echange(4, 4, 5, 4);
		System.out.print("Combinaison en (5,4): ");
		mesComb.detecter(5, 4, grille);
		/*
		 * System.out.println("Bonbon (3,4): " + grille.getCouleur(3, 4) + " " +
		 * grille.getType(3, 4)); System.out.println("Bonbon (4,4): " +
		 * grille.getCouleur(4, 4)); System.out.println("Bonbon (5,4): " +
		 * grille.getCouleur(5, 4)); System.out.println("Bonbon (6,4): " +
		 * grille.getCouleur(6, 4)); // grille.echange(4, 4, 3, 4); // grille.echange(3,
		 * 7, 3, 8); // grille.echange(2, 2, 3, 3); // grille.echange(2, 2, 2, 4);
		 */
		System.out.print("Bonbon en (3,4) = Jaune est ray� : ");
		if (grille.getCouleur(3, 4).contentEquals("Jaune") && grille.isRaye(3, 4))
			System.out.println("Oui");
		else
			System.out.println("Non");

		System.out.print("Bonbon en (4,4) = Bleu : ");
		if (grille.getCouleur(4, 4).equals("Bleu"))
			System.out.println("Oui");
		else
			System.out.println("Non");

		System.out.print("Bonbon en (5,4) = Vert : ");
		if (grille.getCouleur(5, 4).equals("Vert"))
			System.out.println("Oui");
		else
			System.out.println("Non");

		System.out.print("Bonbon en (6,4) = Jaune : ");
		if (grille.getCouleur(6, 4).equals("Jaune"))
			System.out.println("Oui");
		else
			System.out.println("Non");

		System.out.print("Echange (4,4) et (3,4)");
		try {
			grille.echange(4, 4, 3, 4);
		} catch (CandyException e) {
			e.printStackTrace();
		}

		System.out.print("Echange (3,7) et (3,8)");
		try {
			grille.echange(3, 7, 3, 8);
		} catch (CandyException e) {
			e.printStackTrace();
		}

		System.out.print("Echange (2,2) et (3,3)");
		try {
			grille.echange(2, 2, 3, 3);
		} catch (CandyException e) {
			e.printStackTrace();
		}

		System.out.print("Echange (2,2) et (2,4)");
		try {
			grille.echange(2, 2, 2, 4);
		} catch (CandyException e) {
			e.printStackTrace();
		}

		// Traitement �change (2,7) et (1,7)
		System.out.println("\n\tTraitement �change (2,7) et (1,7): \n");
		System.out.print("Apparition de: ");
		grille.echange(2, 7, 1, 7);
		System.out.print("Combinaison en (1,7):");
		mesComb.detecter(1, 7, grille);
		System.out.print("\nCombinaison en (2,7): ");
		Combinaison c = mesComb.detecter(2, 7, grille);
		c.executerCombinaison(grille);
		System.out.println("\nBonbon (2,4): " + grille.getType(2, 4));
		System.out.println("Bonbon (2,5): " + grille.getType(2, 5));
		System.out.println("Bonbon (2,6): " + grille.getType(2, 6));
		System.out.println("Bonbon (2,7): " + grille.getCouleur(2, 7) + " " + grille.getType(2, 7));

		// Test des chutes
		System.out.println("\n\t Test des chutes: \n");

		grille.tomber();
		System.out.println("Bonbon en (9,0): " + grille.getType(9, 0));
		System.out.println("Bonbon en (9,7): " + grille.getCouleur(9, 7) + grille.getType(9, 7));
		System.out.println("Bonbon en (8,7): " + grille.getCouleur(8, 7));
		System.out.println("Bonbon en (7,7): " + grille.getCouleur(7, 7));
		System.out.println("Bonbon en (6,7): " + grille.getCouleur(6, 7));
		System.out.println("Bonbon en (5,7): " + grille.getCouleur(5, 7));
		System.out.println("Bonbon en (4,7): " + grille.getCouleur(4, 7));
		System.out.println("Bonbon en (3,7): " + grille.getCouleur(3, 7));
		System.out.println("Bonbon en (2,7): " + grille.getCouleur(2, 7));
		System.out.println("Bonbon en (1,7): " + grille.getCouleur(1, 7));
		System.out.println("Bonbon en (0,7): " + grille.getCouleur(0, 7));

		grille.completer();
		System.out.println("Bonbon en (9,0): " + grille.getType(9, 0));
		System.out.println("Bonbon en (9,7): " + grille.getCouleur(9, 7) + grille.getType(9, 7));
		System.out.println("Bonbon en (8,7): " + grille.getCouleur(8, 7));
		System.out.println("Bonbon en (7,7): " + grille.getCouleur(7, 7));
		System.out.println("Bonbon en (6,7): " + grille.getCouleur(6, 7));
		System.out.println("Bonbon en (5,7): " + grille.getCouleur(5, 7));
		System.out.println("Bonbon en (4,7): " + grille.getCouleur(4, 7));
		System.out.println("Bonbon en (3,7): " + grille.getCouleur(3, 7));
		System.out.println("Bonbon en (2,7): " + grille.getCouleur(2, 7));
		System.out.println("Bonbon en (1,7): " + grille.getCouleur(1, 7));
		System.out.println("Bonbon en (0,7): " + grille.getCouleur(0, 7));

		Scanner sc = new Scanner(System.in);

		int x1, y1, x2, y2;
		int choix = -1;
		while (choix != 0) {
			try {
				switch (choix) {

				case 0:
					System.out.println("Bye bye");
					System.exit(0);
				case 1:
					x1 = sc.nextInt();
					y1 = sc.nextInt();
					System.out.println("Grille [" + x1 + "][" + y1 + "]\n   Couleur = " + grille.getCouleur(x1, y1)
							+ "\n   Type = " + grille.getType(x1, y1));
					if (grille.isRaye(x1, y1))
						System.out.println("Bonbon ray�");
				case 2:

					x1 = sc.nextInt();
					y1 = sc.nextInt();
					System.out.print("Combinaison en [" + x1 + ";" + y1 + "]:");
					mesComb.detecter(x1, y1, grille);
				case 3:
					x1 = sc.nextInt();
					y1 = sc.nextInt();
					x2 = sc.nextInt();
					y2 = sc.nextInt();
					System.out.print("Echange [" + x1 + ";" + y1 + "]et [" + x2 + ";" + y2 + "]");
					try {
						grille.echange(x1, y1, x2, y2);
					} catch (CandyException e) {
						e.printStackTrace();
					}
				case 4:
					grille.tomber();
				case 5:
					grille.completer();
				default:
					System.out.println(
							"Veuillez choisir le test : \n" + "  1 - Consulter couleur et type en coordonn�e [x,y]\n"
									+ "  2 - Detecter combinaison en coordonn�e [x,y]\n"
									+ "  3 - Echanger en coordonn�e [x1,y1] et [x2,y2]\n"
									+ "  4 - Faire tomber les bonbons\n" + "  5 - Completer la grille\n");
					choix = sc.nextInt();
				}
			} catch (CandyException e) {
				e.printStackTrace();
			}
		}

		sc.close();
		System.exit(0);

	}

}
