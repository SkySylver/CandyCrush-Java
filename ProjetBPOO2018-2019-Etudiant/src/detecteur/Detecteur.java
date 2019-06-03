package detecteur;

import combinaison.Combinaison;
import exceptions.CandyException;
import grille.Grille;

/**
 * Detecteur est la classe m�re de tout d�tecteur de combinaison, forme une chaine de responsabilit�.
 * 
 */
public abstract class Detecteur {
	private Detecteur suivante = null;

	public Detecteur(Detecteur d) {
		suivante = d;
	}
	
	/**
	 * @return Retourne le prochain Detecteur de combinaison
	 * 
	 */
	public Detecteur getSuivante() {
		return suivante;
	}
	
	/**
	 * V�rifie si une combinaison existe � une certaine case de la grille
	 * @param l: ligne o� la combinaison doit �tre d�tect�e
	 * @param c: colonne o� la combinaison doit �tre d�tect�e
	 * @param grille: grille de jeu o� la combinaison doit �tre d�tect�e
	 * @throws CandyException
	 * @return Retourne la combinaison trouv�e si elle existe, sinon renvoie null
	 */
	public abstract Combinaison	combinaisonExiste(int l, int c, Grille grille) throws CandyException;
	
	
	/**
	 * Proc�dure qui permet de faire les v�rifications pour la soutenance interm�diaire
	 * @param grille: grille de jeu o� la combinaison doit �tre d�tect�e
	 * @throws CandyException
	 */
	public abstract void reponse(Grille grille) throws CandyException;

	
	/**
	 * V�rifie si une combinaison existe � une certaine case de la grille
	 * @param l: ligne o� la combinaison doit �tre d�tect�e
	 * @param c: colonne o� la combinaison doit �tre d�tect�e
	 * @param grille: grille de jeu o� la combinaison doit �tre d�tect�e
	 * @throws CandyException
	 * @return Retourne la combinaison trouv�e si elle existe, sinon renvoie null
	 */
	public Combinaison detecter(int l, int c, Grille grille) throws CandyException{
		Combinaison comb = combinaisonExiste(l, c, grille);
		if (comb!=null) {
			return comb;
		}
		else if (suivante != null) {
			return suivante.detecter(l, c, grille);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Initialise la liste des d�tecteurs de combinaisons connues
	 * @return Retourne la liste de d�tecteurs de combinaisons
	 */
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
}
