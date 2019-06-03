package interf;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ModeTimer extends Controller {

	private int secondesEcouleesMax, scoreMax;

	/**
	 * Génère un mode de jeu avec echanges limités
	 * 
	 * @param primaryStage : Stage dans lequel afficher ce mode
	 * @param m            : Menu qui fait appel à ce mode de jeu
	 */
	public ModeTimer(Stage primaryStage, MenuController m) {
		super(primaryStage, m);
		setSecondesEcouleesMax(Integer.parseInt(m.getData().get(0).split(";")[3]));
		setScoreMax(Integer.parseInt(m.getData().get(0).split(";")[2]));
		primaryStage.setTitle("Candy Crush - Temps limité");

	}

	/**
	 * Fin si score atteint -> gagne = true
	 * Fin si temps limite atteint -> gagne = false
	 * Sinon partie pas terminée
	 */
	@Override
	public boolean isFin() {
		if (getScore() > scoreMax) {
			setGagne(true);
			FinController();
			return true;
		} else if (secondesEcouleesMax < getSecondesEcoulees()) {
			setGagne(false);
			FinController();
			return true;
		}
		return false;
	}

	/**
	 * @param n : Temps limite avant de perdre (en secondes et >3)
	 */
	public void setSecondesEcouleesMax(int n) {
		if (n < 3)
			throw new IllegalArgumentException("Temps limite inférieur à 3 secondes");
		secondesEcouleesMax = n;
		hBChrono.getChildren().add(new Label(" / " + secondesEcouleesMax / 60 + "m " + secondesEcouleesMax % 60 + "s "));
	}
	
	
	/**
	 * Met à jour le Score max et le label du score
	 * 
	 * @param scoreMax : Score max
	 */
	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
		hBScore.getChildren().add(new Label("/ " + scoreMax + " "));
	}
	
	public int getSecondesEcouleesMax() {
		return secondesEcouleesMax;
	}

	public int getScoreMax() {
		return scoreMax;
	}
}
