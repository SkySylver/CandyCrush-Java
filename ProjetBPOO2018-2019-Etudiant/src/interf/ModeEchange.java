package interf;

import javafx.stage.Stage;

public class ModeEchange extends Controller{
	
	private int nbEchange;

	public int getNbEchange() {
		return nbEchange;
	}

	public void setNbEchange(int nbEchange) {
		this.nbEchange = nbEchange;
	}

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
