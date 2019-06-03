package interf;

import exceptions.CandyException;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ModeMeringue extends Controller {

	private int secondesEcouleesMax;

	/**
	 * Mode de jeu, le joueur doit éliminer toutes les meringues présentes sur la grille
	 * 
	 * @see Controller
	 * 
	 * @param primaryStage : Fenêtre dans laquelle il faut afficher ce Controller
	 * @param m : Menu qui a lancé ce Controller (pour récupérer principalement le fichier csv sous forme de List<String>)
	 */
	public ModeMeringue(Stage primaryStage, MenuController m) {
		super(primaryStage, m);
		setSecondesEcouleesMax(Integer.parseInt(m.getData().get(0).split(";")[2]));

		primaryStage.setTitle("Candy Crush - Plus de meringues");
	}

	/**
	 * Fin du jeu si fin du temps -> gagne = false
	 * Fin du jeu si plus de meringue -> gagne = true
	 * 
	 */
	@Override
	public boolean isFin() throws CandyException {
		if (getSecondesEcoulees() > secondesEcouleesMax) {
			setGagne(false);
			FinController();
			return true;
		}

		for (int i = 0; i < getGrille().getTaille(); i++)
			for (int j = 0; j < getGrille().getTaille(); j++)
				if (getGrille().getCouleur(i, j).equals("Meringue"))
					return false;

		FinController();
		setGagne(true);
		return true;
	}

	/**
	 * @param n : Temps limite avant de perdre (en secondes et >3)
	 */
	public void setSecondesEcouleesMax(int n) {
		if (n < 3)
			throw new IllegalArgumentException("Temps limite inférieur à 3 secondes");
		secondesEcouleesMax = n;
		hBChrono.getChildren().add(new Label(" / " + secondesEcouleesMax / 60 + "m " + secondesEcouleesMax % 60 + "s "));
	}

	public int getSecondesEcouleesMax() {
		return secondesEcouleesMax;
	}

}
