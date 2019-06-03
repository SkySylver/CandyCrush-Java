package detecteur;

import combinaison.Combinaison;
import exceptions.CandyException;
import grille.Grille;

/**
 * Detecteur est la classe mère de tout détecteur de combinaison, forme une chaine de responsabilité.
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
	 * Vérifie si une combinaison existe à une certaine case de la grille
	 * @param l: ligne où la combinaison doit être détectée
	 * @param c: colonne où la combinaison doit être détectée
	 * @param grille: grille de jeu où la combinaison doit être détectée
	 * @throws CandyException
	 * @return Retourne la combinaison trouvée si elle existe, sinon renvoie null
	 */
	public abstract Combinaison	combinaisonExiste(int l, int c, Grille grille) throws CandyException;
	
	
	/**
	 * Procédure qui permet de faire les vérifications pour la soutenance intermédiaire
	 * @param grille: grille de jeu où la combinaison doit être détectée
	 * @throws CandyException
	 */
	public abstract void reponse(Grille grille) throws CandyException;

	
	/**
	 * Vérifie si une combinaison existe à une certaine case de la grille
	 * @param l: ligne où la combinaison doit être détectée
	 * @param c: colonne où la combinaison doit être détectée
	 * @param grille: grille de jeu où la combinaison doit être détectée
	 * @throws CandyException
	 * @return Retourne la combinaison trouvée si elle existe, sinon renvoie null
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
	 * Initialise la liste des détecteurs de combinaisons connues
	 * @return Retourne la liste de détecteurs de combinaisons
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
