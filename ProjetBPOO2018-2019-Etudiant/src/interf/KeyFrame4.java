package interf;

import exceptions.CandyException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * 4e KeyFrame
 */
public final class KeyFrame4 implements EventHandler<ActionEvent> {
	private Controller con;

	/**
	 * @param c : Controller qui fait appel à cet Evenement
	 */
	public KeyFrame4(Controller c) {
		con = c;
	}

	/**
	 * Vérifie si fin du jeu
	 * Si oui, passe au niveau suivant
	 * @see MenuController#getNextNiveau()
	 */
	public void handle(ActionEvent event) {
		try {
			if (con.isFin()) {
				System.out.println("Partie terminée");
				if (con.isGagne()) {
					con.getMenu().getNextNiveau();
				} else
					System.out.println("Partie perdue");
			}
		} catch (CandyException e) {
			e.printStackTrace();
		}
		con.getGc().clearRect(0, 0, 640, 640);
	}
}
