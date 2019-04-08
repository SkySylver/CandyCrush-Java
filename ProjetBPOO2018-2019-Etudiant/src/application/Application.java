package application;

import combinaison.Combinaison;
import combinaison.TroisHorizontauxSimples;

public class Application {
	private	static Combinaison comb = null;

	public static void main(String[] args) {
		
		comb = initCombinaisons();
		if (comb==null) {
			System.out.println("Aucune combinaison disponible !");
			System.exit(0);
		}
	}
	
	private static Combinaison initCombinaisons() {
		Combinaison maComb = null;
		maComb = new TroisHorizontauxSimples(maComb);
		//maComb = new TroisVerticauxSimples(maComb);

		
		return maComb;
	}

}
