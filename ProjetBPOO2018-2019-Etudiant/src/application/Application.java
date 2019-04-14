package application;

import combinaison.Combinaison;
import exceptions.CandyException;
import grille.Grille;

public class Application {
	private static Combinaison mesComb = null;

	public static void main(String[] args) {

		mesComb = Combinaison.initCombinaisons();
		if (mesComb == null) {
			System.out.println("Aucune Combinaison disponible !");
			System.exit(0);
		}

		// while (true) {
		// grille test
		Grille grille = new Grille(true);

		try {
			jouer(grille);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// }
	}

	private static void jouer(Grille grille) throws Exception {

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

		// Test détection des Combinaisons
		System.out.println("\n\tDétection des Combinaisons: \n");
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

		// Test échanges
		System.out.println("\n\n\tTest des échanges :\n");
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
		System.out.print("Bonbon en (3,4) = Jaune est rayé : ");
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

		// Traitement échange (2,7) et (1,7)
		System.out.println("\n\tTraitement échange (2,7) et (1,7): \n");
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





		System.exit(0);

	}

}
