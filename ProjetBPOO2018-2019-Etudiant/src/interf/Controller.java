package interf;

import java.util.List;

import exceptions.CandyException;
import grille.Grille;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Controller des modes de jeu.
 * Classe abstraite
 */
public abstract class Controller {
	private static final double TEMPS_AFFICHAGE_KEYFRAME1 = 0.5;
	private static final double TEMPS_AFFICHAGE_KEYFRAME2 = 1;
	private static final double TEMPS_AFFICHAGE_KEYFRAME3 = 1;

	/**
	 * score : Le score dans ce mode de jeu
	 * nbEchanbes : Le nombres d'echanges effectués
	 */
	private int score, nbEchanges;

	/**
	 * Coordonnées des pixels Drag And Drop
	 */
	private int xd, yd, xf, yf;
	private int ls, cs, lt, ct;
	
	/**
	 * Les HBox pour le score, le chrono et le nombre d'echanges
	 */
	protected HBox hBScore = new HBox(), hBChrono = new HBox(), hBNbEchanges = new HBox();
	private Label lScore, lNbEchanges, lChrono;

	/**
	 * Le menu qui à lancé ce mode de jeu
	 */
	private MenuController menu;


	// Un canvas pour affiche rdu graphisme (ici, des images
	private Canvas grillePane;
	private GraphicsContext gc;
	private Scene scene;
	private BorderPane root;

	private boolean gagne;
	
	/*
	 * La Grille de ce mode de jeu
	 **/
	private Grille grille;

	protected Timeline timeline;

	/**
	 * Pour la gestion et l'affichage du chrono
	 */
	private int secondesEcoulees = 0;

	private Timeline timelineChrono;
	
	
	/**
	 * Génère un nouveau Controller avec une grille et ses options de jeu dans primaryStage
	 * 
	 * @see Controller#demarrerPartie()
	 * 
	 * @param primaryStage : Fenêtre dans laquelle il faut afficher ce Controller
	 * @param m : Menu qui a lancé ce Controller (pour récupérer principalement le fichier csv sous forme de List<String>)
	 */
	public Controller(Stage primaryStage, MenuController m) {
		try {
			menu = m;
			grille = new Grille(menu.getData());

			primaryStage.setTitle("Candy Crush");

			root = new BorderPane(grillePane);
			initGrille();
			initChrono();
			initScore();
			initNbEchanges();
			root.setBottom(new HBox(hBChrono, hBScore, hBNbEchanges));

			scene = new Scene(root);

			initTimelineJeu();
			initTimelineChrono();

			primaryStage.setScene(scene);
			primaryStage.show();

			demarrerPartie();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Démarre la partie de ce Controller
	 * @see Controller#Controller(Stage, MenuController)
	 * 
	 * @throws CandyException
	 */
	private void demarrerPartie() throws CandyException {
		dessinerPlateau();

		timeline.play();
		timelineChrono.play();

		/**
		 * Si on veut suspendre le dÃƒÂ©roulement d'une timeline --> timeline.pause() Si
		 * on veut l'arrÃƒÂªter --> timeline.stop()
		 */
	}

	/**
	 * Initialise la Grille de ce Controller
	 * Initialise gc
	 * Initialise les interactions du grillePane
	 * 
	 * @see DragDetectedEvent#DragDetectedEvent(Controller)
	 * @see DragOverEvent#DragOverEvent()
	 * @see DragDroppedEvent#DragDroppedEvent(Controller)
	 * 
	 * @throws Exception
	 */
	void initGrille() throws Exception {
		grillePane = new Canvas(640, 640);

		((BorderPane) root).setCenter(grillePane);

		gc = grillePane.getGraphicsContext2D();

		grillePane.setOnDragDetected(new DragDetectedEvent(this)); // Si on veut inactiver le DnD -->
																	// grillePane.setOnDragDetected(null)
		grillePane.setOnDragOver(new DragOverEvent());
		grillePane.setOnDragDropped(new DragDroppedEvent(this));

	}

	/**
	 * Initialise le label Score et le place dans le BorderPane
	 *
	 */
	private void initScore() {
		lScore = new Label("Score : 0 ");
		hBScore.getChildren().add(lScore);
		hBScore.setAlignment(Pos.BOTTOM_RIGHT);
	}

	/*
	 * Initialise le label nbEchanges et le place dans le BorderPane
	 */
	private void initNbEchanges() {
		lNbEchanges = new Label("Echanges : 0");
		hBNbEchanges.getChildren().add(lNbEchanges);
		hBNbEchanges.setAlignment(Pos.BOTTOM_RIGHT);
	}

	/*
	 *  Initialise le label Chrono et le place dans le BorderPane
	 */
	private void initChrono() {
		lChrono = new Label("");
		hBChrono.getChildren().add(lChrono);
	}

	/**
	 * Initialise la timelineChrono
	 */
	private void initTimelineChrono() {
		// Cette KeyFrame apparaÃƒÂ®t 1s aprÃƒÂ¨s le dÃƒÂ©but de la timeline
		KeyFrame k = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				secondesEcoulees++;
				mettreAJourTemps();
			}

			private void mettreAJourTemps() {
				int s, m;

				m = secondesEcoulees / 60;
				s = secondesEcoulees % 60;
				lChrono.setText("" + m + "m " + s + "s ");
			}
		});

		timelineChrono = new Timeline(k);
		// La timeline va boucler ÃƒÂ  l'infinie. Donc la keyframe k sera bien
		// dclenchÃƒÂ©e
		// toutes les secondes
		timelineChrono.setCycleCount(Animation.INDEFINITE);
	}

	/**
	 * Initialise la timeline du jeu avec 4 KeyFrame
	 * @see KeyFrame1#KeyFrame1(Controller)
	 * @see KeyFrame2#KeyFrame2(Controller)
	 * @see KeyFrame3#KeyFrame3(Controller)
	 * @see KeyFrame4#KeyFrame4(Controller)
	 */
	private void initTimelineJeu() {
		final KeyFrame keyframe1 = new KeyFrame(Duration.seconds(0), new KeyFrame1(this));

		final KeyFrame keyframe2 = new KeyFrame(Duration.seconds(TEMPS_AFFICHAGE_KEYFRAME1), new KeyFrame2(this));

		final KeyFrame keyframe3 = new KeyFrame(Duration.seconds(TEMPS_AFFICHAGE_KEYFRAME2), new KeyFrame3(this));
		final KeyFrame keyframe4 = new KeyFrame(Duration.seconds(TEMPS_AFFICHAGE_KEYFRAME3), new KeyFrame4(this));

		timeline = new Timeline(keyframe1, keyframe2, keyframe3, keyframe4);
		timeline.setCycleCount(Animation.INDEFINITE); // L'animation va ÃƒÂ©galement boucler ÃƒÂ  l'infinie
	}

	/**
	 *
	 */

	@SuppressWarnings("unused")
	private int getCandie() {
		return secondesEcoulees;
	}

	/**
	 * Dessine la grille dans gc
	 * @throws CandyException
	 */
	public void dessinerPlateau() throws CandyException {

		for (int l = 0; l < 10; l++) {
			for (int c = 0; c < 10; c++) {
				gc.drawImage(grille.getImage(l, c), c * 64, l * 64);
			}
		}
	}

	public GraphicsContext getGc() {
		return gc;
	}
	
	/**
	 * Met à jour si la partie est gagnée ou perdue
	 * 
	 * @return vrai si la partie est terminée
	 * @throws CandyException
	 */
	public abstract boolean isFin() throws CandyException;

	/**
	 * Désactive le Controller
	 */
	public void FinController() {
		setScore(0);
		setNbEchanges(0);
		timeline.stop();
		this.getGrillePane().setOnDragDetected(null);
	}

	/*
	 * ----+-------------------+ | GETTERS / SETTERS | +-----------------------+
	 *
	 */
	public MenuController getMenu() {
		return menu;
	}
	
	public Grille getGrille() {
		return grille;
	}

	public void setGrille(Grille g) {
		grille = g;
	}

	public int getXd() {
		return xd;
	}

	public void setXd(int xd) {
		this.xd = xd;
	}

	public int getYd() {
		return yd;
	}

	public void setYd(int yd) {
		this.yd = yd;
	}

	public int getXf() {
		return xf;
	}

	public void setXf(int xf) {
		this.xf = xf;
	}

	public int getYf() {
		return yf;
	}

	public void setYf(int yf) {
		this.yf = yf;
	}

	public Canvas getGrillePane() {
		return grillePane;
	}

	public void setGrillePane(Canvas grillePane) {
		this.grillePane = grillePane;
	}

	public Timeline getTimeline() {
		return timeline;
	}

	public int getLs() {
		return ls;
	}

	public void setLs(int ls) {
		this.ls = ls;
	}

	public int getCs() {
		return cs;
	}

	public void setCs(int cs) {
		this.cs = cs;
	}

	public int getLt() {
		return lt;
	}

	public void setLt(int lt) {
		this.lt = lt;
	}

	public int getCt() {
		return ct;
	}

	public void setCt(int ct) {
		this.ct = ct;
	}

	public int getNbEchanges() {
		return nbEchanges;
	}

	public void setNbEchanges(int nbEchanges) {
		this.nbEchanges = nbEchanges;
		lNbEchanges.setText("Echanges : " + nbEchanges + " ");
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
		lScore.setText("Score : " + score + " ");
	}

	public void setGrille(List<String> input) throws Exception {
		grille = new Grille(input);
	}

	public int getSecondesEcoulees() {
		return secondesEcoulees;
	}

	public boolean isGagne() {
		return gagne;
	}

	public void setGagne(boolean gagne) {
		this.gagne = gagne;
	}
}
