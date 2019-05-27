package interf;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public final class KeyFrame1 implements EventHandler<ActionEvent> {
	Controller con;
	public KeyFrame1(Controller c) {
		con = c;
	}
	
	public void handle(ActionEvent event) {

		// Dans cette frame, pour la dÃ©mo, on redessine la grille et c'est tout
		// Pour le projet, il y a sans doute des choses Ã  faire pour compter les points, faire apparaÃ®tre des bonbons spÃ©ciaux
		// ou autre chose encore...
		con.dessinerPlateau();
		
	}
}