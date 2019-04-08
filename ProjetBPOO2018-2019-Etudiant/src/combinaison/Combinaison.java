package combinaison;

import grille.Grille;

public abstract class Combinaison {
	private Combinaison suivante = null;

	public Combinaison(Combinaison comb) {
		suivante = comb;
	}
	public Combinaison getSuivante() {
		return suivante;
	}
	
	public abstract boolean	combinaisonExiste(int l, int c, Grille grille) throws Exception;
	public abstract void	executerCombinaison(int l, int c, Grille grille) throws Exception;	
	
	public void detecter(int l, int c, Grille grille) throws Exception {
		if (combinaisonExiste(l, c, grille))
			executerCombinaison(l, c, grille);
		else if (suivante != null)
			suivante.detecter(l, c, grille);
		else
			throw new Exception("Il n'existe aucune combinaison ");
	}
	
}
