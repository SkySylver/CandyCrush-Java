package application;

import combinaison.*;
import grille.Grille;

public class Application {
	private static Combinaison comb = null;

	public static void main(String[] args) {

		comb = initCombinaisons();
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

	private static Combinaison initCombinaisons() {
		Combinaison maComb = null;
		maComb = new TroisHorizontauxSimples(maComb);
		// maComb = new TroisVerticauxSimples(maComb);
		maComb = new QuatreHorizontauxSimples(maComb);
		//maComb = new QuatreVerticauxSimples(maComb);
		maComb = new TroisHorizontauxRayesH(maComb);
		//A FAIRE//maComb = new TroisVerticauxRayesH(maComb);
		//A FAIRE//maComb = new TroisHorizontauxRayesV(maComb);
		//A FAIRE//maComb = new TroisVerticauxRayesV(maComb);

		return maComb;
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

		System.exit(0);
	}

}
