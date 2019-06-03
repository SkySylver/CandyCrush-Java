package interf;


import exceptions.CandyException;
import javafx.animation.Timeline;
import javafx.stage.Stage;

public class ModeMeringue extends Controller {

	private int secondesEcouleesMax;

	public ModeMeringue(Stage primaryStage, MenuController m) {
		super(primaryStage, m);
		secondesEcouleesMax = Integer.parseInt(m.getData().get(0).split(";")[2]);

		primaryStage.setTitle("Candy Crush - Plus de meringues");
	}

	@Override
	public boolean isFin() throws CandyException {
		if (getSecondesEcoulees() > secondesEcouleesMax)
			return true;
		
		for (int i = 0; i < getGrille().getTaille(); i++)
			for (int j = 0; j < getGrille().getTaille(); j++)
				if (getGrille().getCouleur(i, j).equals("Meringue"))
					return false;

		
		setScore(0);
		setNbEchanges(0);
		timeline.stop();
		this.getGrillePane().setOnDragDetected(null);
		
		
		return true;
	}

	@Override
	public void afficherFin() {
		// TODO Auto-generated method stub
	}

	public int getSecondesEcouleesMax() {
		return secondesEcouleesMax;
	}

}
