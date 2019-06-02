package interf;

import javafx.stage.Stage;

public class ModeEchange extends Controller{

	int nbEchangesMax;
	
	public ModeEchange(Stage primaryStage, String tab[][]) {
		
		super(primaryStage);
		primaryStage.setTitle("Candy Crush - Echanges limités");
	}

	@Override
	public boolean isFin() {
		if(getNbEchanges() >= getNbEchangesMax())
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
