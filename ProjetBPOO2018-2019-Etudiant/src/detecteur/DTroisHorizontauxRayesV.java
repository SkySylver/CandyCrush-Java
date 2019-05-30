package detecteur;

import combinaison.Combinaison;
import combinaison.TroisHorizontauxRayesV;
import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS ALIGNES HORIZONTALEMENT DONT UN RAYE A L'HORIZONTALE
public class DTroisHorizontauxRayesV extends Detecteur {
	private int debutColonne;
	private int ligne;

	public DTroisHorizontauxRayesV(Detecteur d) {
		super(d);
	}

	public Combinaison combinaisonExiste(int l, int c, Grille grille) throws CandyException {

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple") || t.contentEquals("BonbonVertical")) {

			// on se place sur le bonbon le plus � gauche qui est de la m�me couleur
			while (c > 0 && grille.getCouleur(l, c - 1).equals(coul)) {
				c--;
			}

			if (c < 8) {
				if (grille.getCouleur(l, c + 1).equals(coul) && grille.getCouleur(l, c + 2).equals(coul)) {
					for (int i = 0; i < 3; i++) {
						if (grille.getType(l, c + i).equals("BonbonVertical")) {
							debutColonne = c+i;
							return new TroisHorizontauxRayesV(debutColonne, ligne);
						}
					}
				}
			}
		}
		return null;
	}

	public void reponse(Grille grille) throws CandyException {
		System.out.println("3 bonbons " + grille.getCouleur(ligne, debutColonne) + " dont un ray� � la verticale");
	}

	@Override
	public String toString() {
		return "TroisHorizontauxRayesV [debutColonne=" + debutColonne + ", ligne=" + ligne + ", colonnesARayer=" + "]";
	}
}
