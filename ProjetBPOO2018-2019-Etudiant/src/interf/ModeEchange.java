package interf;

import javafx.stage.Stage;

public class ModeEchange extends Controller {
	int nbEchangesMax, scoreMax;

	public ModeEchange(Stage primaryStage, MenuController m) {
		super(primaryStage, m);
		System.out.println(getMenu().getData().get(0));
		String[] options = getMenu().getData().get(0).split(";");
		setScoreMax(Integer.parseInt(options[2]));
		setNbEchangesMax(Integer.parseInt(options[3]));
		primaryStage.setTitle("Candy Crush - Echanges limités");
	}

	@Override
	public boolean isFin() {
		if (getNbEchanges() >= getNbEchangesMax() || getScore() > getScoreMax()) {
			System.out.println(getNbEchanges() + " / " + getNbEchangesMax());
			System.out.println(getScore() + " /" + getScoreMax());
			setScore(0);
			setNbEchanges(0);
			timeline.stop();
			this.getGrillePane().setOnDragDetected(null);
			return true;
		} else
			return false;
	}

	private void setNbEchangesMax(int n) {
		nbEchangesMax = n;
	}

	private int getNbEchangesMax() {
		return nbEchangesMax;
	}

	@Override
	public void afficherFin() {
	}

	public int getScoreMax() {
		return scoreMax;
	}

	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
	}

}
