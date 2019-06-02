package interf;

import javafx.stage.Stage;

public class ModeTimer extends Controller {

	private int secondesEcouleesMax, scoreMax;

	public ModeTimer(Stage primaryStage, MenuController m) {
		super(primaryStage, m);
		secondesEcouleesMax = Integer.parseInt(m.getData().get(0).split(";")[3]);
		scoreMax = Integer.parseInt(m.getData().get(0).split(";")[2]);

	}

	public int getTemps() {
		return secondesEcouleesMax;
	}

	public void setTemps(int temps) {
		secondesEcouleesMax = temps;
	}

	@Override
	public boolean isFin() {
		if (secondesEcouleesMax < getSecondesEcoulees()) {
			return true;
		}
		if (getScore() > scoreMax)
			return true;
		
		return false;
	}

	@Override
	public void afficherFin() {
		// TODO Auto-generated method stub

	}

	public int getScoreMax() {
		return scoreMax;
	}
}
