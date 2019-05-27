package detecteur;

import combinaison.Combinaison;
import combinaison.TroisVerticauxRayesH;
import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS ALIGNES VERTICALEMENT DONT UN RAYE A L'HORIZONTALE
public class DTroisVerticauxRayesH extends Detecteur {
	private int debutLigne;
	private int colonne;
	
	public DTroisVerticauxRayesH(Detecteur d) {
		super(d);
	}

	public Combinaison combinaisonExiste(int l, int c, Grille grille) throws CandyException {

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple") || t.contentEquals("BonbonHorizontal")) {

			while (l > 0 && grille.getCouleur(l - 1, c).equals(coul)) {
				l--;
			}

			if (l < 8) {
				if (grille.getCouleur(l + 1, c).equals(coul) && grille.getCouleur(l + 2, c).equals(coul)) {
					for (int i = 0; i < 3; i++) {
						if (grille.getType(l + i, c).equals("BonbonHorizontal")) {
							debutLigne = l + i;
							return new TroisVerticauxRayesH(debutLigne, colonne);
						}
					}
				}
			}
		}

		return null;
	}

	public void reponse(Grille grille) throws CandyException {
		System.out.println("3 bonbons " + grille.getCouleur(debutLigne, colonne) + " dont un ray� � l'horizontale");
	}
	
	@Override
	public String toString() {
		return "TroisVerticauxRayesH [debutLigne=" + debutLigne + ", colonne=" + colonne + ", lignesARayer=" + "]";
	}
}
