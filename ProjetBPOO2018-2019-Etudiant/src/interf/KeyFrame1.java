package interf;

import combinaison.Combinaison;
import detecteur.Detecteur;
import exceptions.CandyException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Premiere KeyFrame lancée après chaque DragDetectedEvent
 */
public final class KeyFrame1 implements EventHandler<ActionEvent> {
	Controller con;
	
	/**
	 * @param c : Controller qui fait appel à cet Evenement
	 */
	public KeyFrame1(Controller c) {
		con = c;
	}

	/**
	 * Detecte les Combinaisons
	 * Ajoute des points si combinaisons existent
	 * Et redessine la grille avec les explosions
	 */
	public void handle(ActionEvent event) {
		try {
			Combinaison comb1, comb2;
			Detecteur combDet = Detecteur.initDetecteurs();

			comb1 = combDet.detecter(con.getLt(), con.getCt(), con.getGrille());
			
			
			if (comb1 != null) {
				con.setScore(comb1.executerCombinaison(con.getGrille()) + con.getScore());
			}
				
			comb2 = combDet.detecter(con.getLs(), con.getCs(), con.getGrille());
			if (comb2 != null) {
				con.setScore(comb2.executerCombinaison(con.getGrille()) + con.getScore());
			}
				con.dessinerPlateau();
		} catch (CandyException e) {
			e.printStackTrace();
		}

	}
}