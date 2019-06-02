package interf;

import java.util.List;

import javafx.stage.Stage;

public class ModeEchange extends Controller {
	int nbEchangesMax, scoreMax;

	public ModeEchange(Stage primaryStage, MenuController m) {
		super(primaryStage, m);

		String[] options = getMenu().getData().get(0).split(";");
		setScoreMax(Integer.parseInt(options[2]));
		setNbEchangesMax(Integer.parseInt(options[3]));
		primaryStage.setTitle("Candy Crush - Echanges limités");
	}

	@Override
	public boolean isFin() {
		if (getNbEchanges() >= getNbEchangesMax() || getScore() > getScoreMax())
			return true;
		else
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
			getMenu().ViderJeu();
	}

	public int getScoreMax() {
		return scoreMax;
	}

	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
	}

}
