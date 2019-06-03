package interf;

import exceptions.CandyException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * 2e KeyFrame
 */
public final class KeyFrame2 implements EventHandler<ActionEvent> {
	private Controller con;

	/**
	 * @param c : Controller qui fait appel � cet Evenement
	 */
	public KeyFrame2(Controller c) {
		con = c;
	}

	/**
	 * On fait tomber les Bonbons
	 */
	public void handle(ActionEvent event) {

		con.getGrille().tomber();
		con.getGc().clearRect(0, 0, 640, 640);
		try {
			con.dessinerPlateau();
		} catch (CandyException e) {
			e.printStackTrace();
		}
		// Dans cette frame, on est sensÃ© voir des Ã©toiles qui matÃ©rialisent la
		// prochaine
		// disparition des bonbons (etoile = case vide)

	}
}
