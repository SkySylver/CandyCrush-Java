package interf;

import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Mode de jeu Echanges Avec Echanges limit�s et ScoreMax a atteindre
 */
public class ModeEchange extends Controller {
	int nbEchangesMax, scoreMax;
	Label lScoreMax, lEchangeMax;

	/**
	 * G�n�re un mode de jeu avec echanges limit�s L'entete
	 * (getMenu().getData().get(0) est de la forme suivante :
	 * MODE_DE_JEU;TAILLE;SCORE_MAX;NB_ECHANGES_MAX
	 * 
	 * @param primaryStage : Stage dans lequel afficher ce mode
	 * @param m            : Menu qui fait appel � ce mode de jeu
	 */
	public ModeEchange(Stage primaryStage, MenuController m) {
		super(primaryStage, m);

		// System.out.println(getMenu().getData().get(0));
		String[] options = getMenu().getData().get(0).split(";");
		System.out.println(Integer.parseInt(options[2]));
		setScoreMax(Integer.parseInt(options[2]));
		setNbEchangesMax(Integer.parseInt(options[3]));
		primaryStage.setTitle("Candy Crush - Echanges limit�s");
	}

	/**
	 * Si score > scoremax met gagn� � vrai SI NbEchanges > nbEchangesMax met gagn�
	 * � faux Sinon la partie n'est pas finie
	 */
	@Override
	public boolean isFin() {
		// System.out.println(getNbEchanges() + " / " + getNbEchangesMax());
		// System.out.println(getScore() + " /" + getScoreMax());

		if (getScore() > getScoreMax()) {
			FinController();
			setGagne(true);
			return true;
		} else if (getNbEchanges() >= getNbEchangesMax()) {
			FinController();
			setGagne(false);
			return true;
		} else
			return false;
	}

	/**
	 * Met � jour le nombre d'echanges max et le label du nombre d'echanges
	 * 
	 * @param n : Nombres d'echanges max
	 */
	private void setNbEchangesMax(int n) {
		nbEchangesMax = n;
		lEchangeMax = new Label("/ " + n);
		this.hBNbEchanges.getChildren().add(lEchangeMax);
	}

	/**
	 * Met � jour le Score max et le label du score
	 * 
	 * @param scoreMax : Score max
	 */
	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
		lScoreMax = new Label("/ " + scoreMax + " ");
		hBScore.getChildren().add(lScoreMax);
	}
	

	private int getNbEchangesMax() {
		return nbEchangesMax;
	}

	public int getScoreMax() {
		return scoreMax;
	}

}
