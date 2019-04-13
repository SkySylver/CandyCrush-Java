package application;

import combinaison.*;
import grille.Grille;

public class Application {
	private static Combinaison comb = null;

	public static void main(String[] args) {

		comb = Combinaison.initCombinaisons();
		if (comb == null) {
			System.out.println("Aucune combinaison disponible !");
			System.exit(0);
		}

		while (true) {
			// grille test
			Grille grille = new Grille(true);

			try {
				jouer(grille);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
		//System.out.println("Couleur du bonbon en (3,10): " + grille.getCouleur(3, 10));
		//System.out.println("Type du bonbon (3,10): " + grille.getType(3, 10));
		
		

		// Test détection des combinaisons
		System.out.println("\n\tDétection des combinaisons: \n");
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

		// Test échanges
		System.out.println("\n\tTest échanges: \n");
		System.out.print("Echange en (4,4) (5,4):");
		grille.echange(4, 4, 5, 4);
		System.out.print("Combinaison en (4,4):");
		comb.detecter(4, 4, grille);
		System.out.print("Combinaison en (5,4):");
		comb.detecter(5, 4, grille);
		
		//Traitement échange (2,7) et (1,7)
		System.out.println("\n\tTraitement échange (2,7) et (1,7): \n");
		System.out.println("yo");
		
		
		System.exit(0);
		
	}

}
