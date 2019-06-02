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

	public ModeEchange(Stage primaryStage) {
		super(primaryStage);
	}

	@Override
	public boolean isFin() {
		
		return false;
	}

	@Override
	public void afficherFin() {
		
	}
	
}
