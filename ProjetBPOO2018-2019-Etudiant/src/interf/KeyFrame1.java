package interf;

import combinaison.Combinaison;
import detecteur.Detecteur;
import exceptions.CandyException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public final class KeyFrame1 implements EventHandler<ActionEvent> {
	Controller con;

	public KeyFrame1(Controller c) {
		con = c;
	}

	public void handle(ActionEvent event) {

		// Dans cette frame, pour la dÃ©mo, on redessine la grille et c'est tout
		// Pour le projet, il y a sans doute des choses Ã  faire pour compter les
		// points, faire apparaÃ®tre des bonbons spÃ©ciaux
		// ou autre chose encore...
		try {
			Combinaison comb1, comb2;
			Detecteur combDet = Detecteur.initDetecteurs();

			comb1 = combDet.detecter(con.getLt(), con.getCt(), con.getGrille());
			if (comb1 != null)
			//	score += comb1.executerCombinaison(con.getGrille());
			comb2 = combDet.detecter(con.getLs(), con.getCs(), con.getGrille());
			if (comb2 != null)
			//	score += comb2.executerCombinaison(con.getGrille());
			con.dessinerPlateau();
		} catch (CandyException e) {
			e.printStackTrace();
		}

	}
}