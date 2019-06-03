package interf;

import exceptions.CandyException;
import javafx.stage.Stage;

public class ModeSansObjectif extends Controller {

	/**
	 * Génère un mode de jeu avec echanges limités
	 * @param primaryStage : Stage dans lequel afficher ce mode
	 * @param m : Menu qui fait appel à ce mode de jeu
	 */
	public ModeSansObjectif(Stage primaryStage, MenuController m) {
		super(primaryStage, m);
		primaryStage.setTitle("Candy Crush - Sans Objectif");
	}

	/**
	 * Pas de condition de fin
	 * @return toujours false
	 */
	@Override
	public boolean isFin() throws CandyException {
		return false;
	}
}
