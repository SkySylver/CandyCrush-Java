package interf;

import java.util.List;

import javafx.stage.Stage;

public class ModeEchange extends Controller {

	public ModeEchange(Stage primaryStage, List<String> data) {

		super(primaryStage, data);
		primaryStage.setTitle("Candy Crush - Echanges limités");
	}

	private int nbEchange;

	public int getNbEchange() {
		return nbEchange;
	}

	public void setNbEchange(int nbEchange) {
		this.nbEchange = nbEchange;
	}

	int nbEchangesMax;

	@Override
	public boolean isFin() {
		if (getNbEchanges() >= getNbEchangesMax())
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

	}

}
