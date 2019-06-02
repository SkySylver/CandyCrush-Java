package interf;

import java.util.List;

import javafx.stage.Stage;

public class ModeTimer extends Controller {

	private int temps;

	public ModeTimer(Stage primaryStage, List<String> data) {
		super(primaryStage, data);
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
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
