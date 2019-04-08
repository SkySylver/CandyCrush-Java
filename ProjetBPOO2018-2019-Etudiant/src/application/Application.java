package application;

import combinaison.*;
import grille.Grille;

public class Application {
	private	static Combinaison comb = null;

	public static void main(String[] args) {
		
		comb = initCombinaisons();
		if (comb==null) {
			System.out.println("Aucune combinaison disponible !");
			System.exit(0);
		}
		
		while (true) {
			//grille test
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
	//	maComb = new TroisVerticauxSimples(maComb);
		return maComb;
	}
	
	private static void jouer(Grille grille) throws Exception {
		System.out.println("etape 1\n");
		comb.detecter(2, 4, grille);
        Thread.sleep(2000);
		System.out.println("etape 2\n");
        comb.detecter(2, 5, grille);
        Thread.sleep(2000);
		System.out.println("etape 3\n");
        comb.detecter(2, 6, grille);
        Thread.sleep(2000);
		System.out.println("etape 4\n");
        comb.detecter(2, 7, grille);
        Thread.sleep(5000000);

	}

}
