package interf;

import exceptions.CandyException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * 3e KeyFrame
 */
public final class KeyFrame3 implements EventHandler<ActionEvent> {
	private Controller con;

	/**
	 * @param c : Controller qui fait appel à cet Evenement
	 */
	public KeyFrame3(Controller c) {
		con = c;
	}

	/**
	 * Complete la grille
	 */
	public void handle(ActionEvent event) {
		con.getGrille().completer();
		con.getGc().clearRect(0, 0, 640, 640);
		try {
			con.dessinerPlateau();
		} catch (CandyException e) {
		}
	}
}
