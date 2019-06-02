package detecteur;

import combinaison.Combinaison;
import exceptions.CandyException;
import grille.Grille;

/**
 * Detecteur est la classe mère de tout détecteur de combinaison, forme une chaine de responsabilité.
 * 
 */
public abstract class Detecteur {
	protected int TAILLE = 10;
	private Detecteur suivante = null;

	public Detecteur(Detecteur d) {
		suivante = d;
	}
	public Detecteur getSuivante() {
		return suivante;
	}
	
	public abstract Combinaison	combinaisonExiste(int l, int c, Grille grille) throws CandyException;
	public abstract void reponse(Grille grille) throws CandyException;

	
	public Combinaison detecter(int l, int c, Grille grille) throws CandyException{
		Combinaison comb = combinaisonExiste(l, c, grille);
		if (comb!=null) {
			reponse(grille); //reponse pour le test
			//executerCombinaison(grille);
			return comb;
		}
		else if (suivante != null) {
			return suivante.detecter(l, c, grille);
		}
		else {
			return null;
		}
	}
	
	public static Detecteur initDetecteurs() {
		Detecteur combDet = null;
		combDet = new DTroisHorizontauxSimples(combDet);
		combDet = new DTroisVerticauxSimples(combDet);
		combDet = new DQuatreHorizontauxSimples(combDet);
		combDet = new DQuatreVerticauxSimples(combDet);
		combDet = new DTroisHorizontauxRayesH(combDet);
		combDet = new DTroisVerticauxRayesH(combDet);
		combDet = new DTroisHorizontauxRayesV(combDet);
		combDet = new DTroisVerticauxRayesV(combDet);

		return combDet;
	}
	
	public void setTaille(int n) {
		TAILLE = n;
	}
}
