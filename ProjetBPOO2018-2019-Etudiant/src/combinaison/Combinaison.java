package combinaison;

import exceptions.CandyException;
import grille.Grille;

public abstract class Combinaison {
	private Combinaison suivante = null;

	public Combinaison(Combinaison comb) {
		suivante = comb;
	}
	public Combinaison getSuivante() {
		return suivante;
	}
	
	public abstract boolean	combinaisonExiste(int l, int c, Grille grille) throws CandyException;
	public abstract void	executerCombinaison(Grille grille) throws CandyException;	
	
	public boolean detecter(int l, int c, Grille grille) throws CandyException{
		if (combinaisonExiste(l, c, grille)) {
			executerCombinaison(grille);
			return true;
		}
		else if (suivante != null) {
			return suivante.detecter(l, c, grille);
		}
		else {
			System.out.println("Aucune");
			return false;
		}
	}
	
	public static Combinaison initCombinaisons() {
		Combinaison maComb = null;
		maComb = new TroisHorizontauxSimples(maComb);
		maComb = new TroisVerticauxSimples(maComb);
		maComb = new QuatreHorizontauxSimples(maComb);
		maComb = new QuatreVerticauxSimples(maComb);
		maComb = new TroisHorizontauxRayesH(maComb);
		maComb = new TroisVerticauxRayesH(maComb);
		maComb = new TroisHorizontauxRayesV(maComb);
		maComb = new TroisVerticauxRayesV(maComb);

		return maComb;
	}
	
	@Override
	public String toString() {
		return "Combinaison [suivante=" + suivante + "]";
	}
		
}
