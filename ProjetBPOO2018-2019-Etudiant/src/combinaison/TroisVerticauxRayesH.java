package combinaison;

import java.util.Arrays;

import exceptions.CandyException;
import grille.Grille;

// TROIS BONBONS ALIGNES VERTICALEMENT DONT UN RAYE A L'HORIZONTALE
public class TroisVerticauxRayesH extends Combinaison {

	private int debutLigne;
	private int colonne;
	private int lignesARayer[] = { -1, -1, -1 };
	private boolean rayeTrouve = false;

	public TroisVerticauxRayesH(Combinaison comb) {
		super(comb);
	}

	public boolean combinaisonExiste(int l, int c, Grille grille) throws CandyException {

		String coul = grille.getCouleur(l, c);
		String t = grille.getType(l, c);

		if (t.equals("BonbonSimple") || t.contentEquals("BonbonHorizontal")) {

			while (l > 0 && grille.getCouleur(l - 1, c).equals(coul)) {
				l--;
			}

			if (l < 8) {
				if (grille.getCouleur(l + 1, c).equals(coul) && grille.getCouleur(l + 2, c).equals(coul)) {
					for (int i = 0; i < 3; i++) {
						if (grille.getType(l+i, c).equals("BonbonHorizontal")) {
							rayeTrouve = true;
							lignesARayer[i] = l + i;
						}
					}
					if (rayeTrouve) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public void executerCombinaison(Grille grille) throws CandyException {

		System.out.println("3 bonbons " + grille.getCouleur(debutLigne, colonne) + " dont un rayé à l'horizontale");

	}

	@Override
	public String toString() {
		return "TroisVerticauxRayesH [debutLigne=" + debutLigne + ", colonne=" + colonne + ", lignesARayer="
				+ Arrays.toString(lignesARayer) + ", rayeTrouve=" + rayeTrouve + "]";
	}
}
