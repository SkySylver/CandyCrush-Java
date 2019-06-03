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
		if (secondesEcouleesMax < getSecondesEcoulees() || getScore() > scoreMax) {
			setScore(0);
			setNbEchanges(0);
			timeline.stop();
			this.getGrillePane().setOnDragDetected(null);
			return true;
		}

		return false;
	}

	@Override
	public void afficherFin() {

	}

	public int getScoreMax() {
		return scoreMax;
	}
}
