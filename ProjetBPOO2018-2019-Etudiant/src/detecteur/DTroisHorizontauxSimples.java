package detecteur;

import combinaison.Combinaison;
import combinaison.TroisHorizontauxSimples;
import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS SIMPLES ALIGNES HORIZONTALEMENT
public class DTroisHorizontauxSimples extends Detecteur {

	public DTroisHorizontauxSimples(Detecteur d) {
		super(d);
	}

	private int debutColonne;
	private int ligne;

	public Combinaison combinaisonExiste(int l, int c, Grille grille) throws CandyException {
		// on sauvegarde la couleur et le type du bonbon concerné
		// puis on décale d'un bonbon vers la gauche tant que le bonbon à gauche est de
		// la même couleur et du même type

		ligne = l;
		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple")) {

			// on se place sur le bonbon le plus à gauche qui est du même type (donc simple)
			// et de même couleur
			while (c > 0 && grille.getCouleur(l, c - 1).equals(coul) && grille.getType(l, c - 1).equals(t)) {
				c--;
			}

			if (c < 8) {
				if (grille.getCouleur(l, c + 1).equals(coul) && grille.getCouleur(l, c + 2).equals(coul)) {
					if (grille.getType(l, c + 1).equals(t) && grille.getType(l, c + 2).equals(t)) {
						debutColonne = c;
						return new TroisHorizontauxSimples(debutColonne, l);
					}
				}
			}
		}

		return null;
	}

	public void reponse(Grille grille) throws CandyException {
		System.out.println("3 bonbons " + grille.getCouleur(ligne, debutColonne));
	}
	
	@Override
	public String toString() {
		return "TroisHorizontauxSimples [debutColonne=" + debutColonne + ", ligne=" + ligne + "]";
	}
}
