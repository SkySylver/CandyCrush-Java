package interf;

import javafx.stage.Stage;

public class ModeEchange extends Controller {
	int nbEchangesMax, scoreMax;

	/**
	 * Mode de jeu, le joueur doit atteindre un score avec un nombre de coup limité
	 * 
	 * @see Controller
	 * 
	 * @param primaryStage : Fenêtre dans laquelle il faut afficher ce Controller
	 * @param m : Menu qui a lancé ce Controller (pour récupérer principalement le fichier csv sous forme de List<String>)
	 */
	public ModeEchange(Stage primaryStage, MenuController m) {
		super(primaryStage, m);
		System.out.println(getMenu().getData().get(0));
		String[] options = getMenu().getData().get(0).split(";");
		setScoreMax(Integer.parseInt(options[2]));
		setNbEchangesMax(Integer.parseInt(options[3]));
		primaryStage.setTitle("Candy Crush - Echanges limités");
	}

	/**
	 * 
	 * @return Retourne vrai si le joueur a atteint l'objectif ou si il a atteint le nombre d'échange max autorisé
	 * 
	 * */
	public boolean isFin() {
		if (getNbEchanges() >= getNbEchangesMax() || getScore() > getScoreMax()) {
			System.out.println(getNbEchanges() + " / " + getNbEchangesMax());
			System.out.println(getScore() + " /" + getScoreMax());
			FinController();
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



	public int getScoreMax() {
		return scoreMax;
	}

	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
	}

}
