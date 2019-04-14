package application;

import combinaison.*;
import exceptions.CandyException;
import grille.Grille;

public class Application {
	private static Combinaison comb = null;

	public static void main(String[] args) {

		comb = Combinaison.initCombinaisons();
		if (comb == null) {
			System.out.println("Aucune combinaison disponible !");
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
		// System.out.println("Couleur du bonbon en (3,10): " + grille.getCouleur(3,
		// 10));
		// System.out.println("Type du bonbon (3,10): " + grille.getType(3, 10));

		// Test d�tection des combinaisons
		System.out.println("\n\tD�tection des combinaisons: \n");
		System.out.print("Combinaison en (3,2):");
		comb.detecter(3, 2, grille);
		System.out.print("Combinaison en (3,3):");
		comb.detecter(3, 3, grille);
		System.out.print("Combinaison en (2,4):");
		comb.detecter(2, 4, grille);
		System.out.print("Combinaison en (2,7):");
		comb.detecter(2, 7, grille);
		System.out.print("Combinaison en (6,6):");
		comb.detecter(6, 6, grille);
		System.out.print("Combinaison en (7,6):");
		comb.detecter(7, 6, grille);
		System.out.print("Combinaison en (5,4):");
		comb.detecter(5, 4, grille);

		// Test �changes

		System.out.println("\n\tTest des �changes :\n");

		System.out.print("Echange en (4,4) (5,4):");
		System.out.println("\n\tTest �changes: \n");
		System.out.print("Appratition de: ");
		grille.echange(4, 4, 5, 4);
		System.out.print("Combinaison en (5,4):");
		comb.detecter(5, 4, grille);
		System.out.println("Bonbon (3,4): " + grille.getCouleur(3, 4) + " " + grille.getType(3, 4));
		System.out.println("Bonbon (4,4): " + grille.getCouleur(4, 4));
		System.out.println("Bonbon (4,4): " + grille.getCouleur(5, 4));
		System.out.println("Bonbon (4,4): " + grille.getCouleur(6, 4));
		// grille.echange(4, 4, 3, 4);
		// grille.echange(3, 7, 3, 8);
		// grille.echange(2, 2, 3, 3);
		// grille.echange(2, 2, 2, 4);
		
		System.out.print("Bonbon en (3,4) = Jaune est ray� : ");
		if (grille.getCouleur(3, 4).contentEquals("Jaune") && grille.isRaye(3, 4))
			System.out.println("Oui");
		else
			System.out.println("Non");

		System.out.println("Bonbon en (4,4) = Bleu : ");
		if (grille.getCouleur(4, 4).equals("Bleu"))
			System.out.println("Oui");
		else
			System.out.println("Non");

		System.out.println("Bonbon en (5,4) = Vert : ");
		if (grille.getCouleur(5, 4).equals("Vert"))
			System.out.println("Oui");
		else
			System.out.println("Non");

		System.out.println("Bonbon en (6,4) = Jaune : ");
		if (grille.getCouleur(6, 4).equals("Jaune"))
			System.out.println("Oui");
		else
			System.out.println("Non");

		System.out.println("Echange (4,4) et (3,4)");
		try {
			grille.echange(4, 4, 3, 4);
		} catch (CandyException e) {
			e.printStackTrace();
		}

		System.out.println("Echange (3,7) et (3,8)");
		try {
			grille.echange(3, 7, 3, 8);
		} catch (CandyException e) {
			e.printStackTrace();
		}

		System.out.println("Echange (2,2) et (3,3)");
		try {
			grille.echange(2, 2, 3, 3);
		} catch (CandyException e) {
			e.printStackTrace();
		}
		
		System.out.println("Echange (2,2) et (2,4)");
		try {
			grille.echange(2, 2, 2, 4);
		} catch (CandyException e) {
			e.printStackTrace();
		}

		
		// Traitement �change (2,7) et (1,7)
		System.out.println("\n\tTraitement �change (2,7) et (1,7): \n");
		System.out.print("Appratition de: ");
		grille.echange(2, 7, 1, 7);
		System.out.print("Combinaison en (1,7):");
		comb.detecter(1, 7, grille);
		System.out.print("\nCombinaison en (2,7):");
		comb.detecter(2, 7, grille);
		System.out.println("Bonbon (2,4): " + grille.getType(2, 4));
		System.out.println("Bonbon (2,5): " + grille.getType(2, 5));
		System.out.println("Bonbon (2,6): " + grille.getType(2, 6));
		System.out.println("Bonbon (2,7): " + grille.getCouleur(2, 7) + " " + grille.getType(2, 7));

		System.exit(0);

	}

}
