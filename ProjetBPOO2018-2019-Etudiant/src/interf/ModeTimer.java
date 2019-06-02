package interf;

import javafx.stage.Stage;

public class ModeTimer extends Controller{
	
	private int temps;

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public ModeTimer(Stage primaryStage) {
		super(primaryStage);
	}

	@Override
	public boolean isFin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afficherFin() {
		// TODO Auto-generated method stub
		
	}

}
