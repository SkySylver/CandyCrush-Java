package interf;

import javafx.stage.Stage;

public class ModeTimer extends Controller {

	private int secondesEcouleesMax, scoreMax;

	public ModeTimer(Stage primaryStage, MenuController m) {
		super(primaryStage, m);
		secondesEcouleesMax = Integer.parseInt(m.getData().get(0).split(";")[3]);
		scoreMax = Integer.parseInt(m.getData().get(0).split(";")[2]);
		primaryStage.setTitle("Candy Crush - Temps limité");

	}

	public int getSecondesEcouleesMax() {
		return secondesEcouleesMax;
	}

	public void setSecondesEcouleesMax(int temps) {
		secondesEcouleesMax = temps;
	}

	@Override
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
