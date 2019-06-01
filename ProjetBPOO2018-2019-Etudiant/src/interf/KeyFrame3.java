package interf;

import exceptions.CandyException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public final class KeyFrame3 implements EventHandler<ActionEvent> {
	private Controller con;

	public KeyFrame3(Controller c) {
		con = c;
	}

	public void handle(ActionEvent event) {
		

		con.getGrille().completer();
		con.getGc().clearRect(0, 0, 640, 640);
		try {
			con.dessinerPlateau();
		} catch (CandyException e) {

		}
		// Dans cette frame, on est sensÃ© voir des Ã©toiles qui matÃ©rialisent la
		// prochaine
		// disparition des bonbons (etoile = case vide)

	}
}
