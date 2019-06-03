package interf;


import exceptions.CandyException;
import javafx.animation.Timeline;
import javafx.stage.Stage;

public class ModeMeringue extends Controller {

	private int secondesEcouleesMax;

	/**
	 * Mode de jeu, le joueur doit �liminer toutes les meringues pr�sentes sur la grille
	 * 
	 * @see Controller
	 * 
	 * @param primaryStage : Fen�tre dans laquelle il faut afficher ce Controller
	 * @param m : Menu qui a lanc� ce Controller (pour r�cup�rer principalement le fichier csv sous forme de List<String>)
	 */
	public ModeMeringue(Stage primaryStage, MenuController m) {
		super(primaryStage, m);
		secondesEcouleesMax = Integer.parseInt(m.getData().get(0).split(";")[2]);

		primaryStage.setTitle("Candy Crush - Plus de meringues");
	}

	/**
	 * 
	 * @return Retourne vrai si le joueur a atteint l'objectif ou si il a d�pass� le temps autoris�.
	 * 
	 * */
	public boolean isFin() throws CandyException {
		if (getSecondesEcoulees() > secondesEcouleesMax) {
			setGagne(false);
			FinController();
			return true;
		}
		
		for (int i = 0; i < getGrille().getTaille(); i++)
			for (int j = 0; j < getGrille().getTaille(); j++)
				if (getGrille().getCouleur(i, j).equals("Meringue"))
					return false;

		
		FinController();
		setGagne(true);
		return true;
	}

	public int getSecondesEcouleesMax() {
		return secondesEcouleesMax;
	}

}
