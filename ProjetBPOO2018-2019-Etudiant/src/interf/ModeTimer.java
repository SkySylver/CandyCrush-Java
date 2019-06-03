package interf;

import javafx.stage.Stage;

public class ModeTimer extends Controller {

	private int secondesEcouleesMax, scoreMax;

	/**
	 * Mode de jeu, le joueur doit atteindre un score en un temps limit�
	 * 
	 * @see Controller
	 * 
	 * @param primaryStage : Fen�tre dans laquelle il faut afficher ce Controller
	 * @param m : Menu qui a lanc� ce Controller (pour r�cup�rer principalement le fichier csv sous forme de List<String>)
	 */
	public ModeTimer(Stage primaryStage, MenuController m) {
		super(primaryStage, m);
		secondesEcouleesMax = Integer.parseInt(m.getData().get(0).split(";")[3]);
		scoreMax = Integer.parseInt(m.getData().get(0).split(";")[2]);
		primaryStage.setTitle("Candy Crush - Temps limit�");

	}

	public int getSecondesEcouleesMax() {
		return secondesEcouleesMax;
	}

	public void setSecondesEcouleesMax(int temps) {
		secondesEcouleesMax = temps;
	}

	/**
	 * 
	 * @return Retourne vrai si le joueur a atteint l'objectif ou si il a d�pass� le temps autoris�.
	 * 
	 * */
	public boolean isFin() {
		if (getScore() > scoreMax) {
			setGagne(true);
			FinController();
			return true;
		} else if (secondesEcouleesMax < getSecondesEcoulees()) {
			setGagne(false);
			FinController();
			return true;
		}
		return false;
	}

	public int getScoreMax() {
		return scoreMax;
	}
}
