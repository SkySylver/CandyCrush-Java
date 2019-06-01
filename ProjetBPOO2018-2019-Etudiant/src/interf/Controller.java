package interf;

import exceptions.CandyException;
import grille.Grille;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/*import ui.CandyCrush.DragDetectedEvent;
import ui.CandyCrush.DragDroppedEvent;
import ui.CandyCrush.DragOverEvent;
import ui.CandyCrush.KeyFrame1;
import ui.CandyCrush.KeyFrame2;
*/

/**
 * Controller de la fen�tre.
 * 
 */
public abstract class Controller {
	private static final double TEMPS_AFFICHAGE_KEYFRAME1 = 0.5;
	private static final double TEMPS_AFFICHAGE_KEYFRAME2 = 1;

	private static final int NOMBRE_DE_CANDIES = 10;

	private Scene scene;
	private BorderPane root;

	// Coordonn�es pixel DnD
	private int xd, yd, xf, yf;

	// Un canvas pour affiche rdu graphisme (ici, des images
	private Canvas grillePane;
	private GraphicsContext gc;

	private int ls, cs, lt, ct;

	/*
	 * 
	 **/
	private Grille grille = new Grille(false);

	/**
	 * Le tableau contenant les images des bonbons useless : On met directement
	 * l'image dans la classe du bonbon
	 */
	private Image[] candies;

	private Timeline timeline;

	/**
	 * Pour la gestion et l'affichage du chrono
	 */
	private Label lChrono;
	private int secondesEcoulees = 0;
	private Timeline timelineChrono;

	public Controller(Stage primaryStage) {
		try {
			primaryStage.setTitle("Candy Crush");

			root = new BorderPane(grillePane);
			initGrille();
			initChrono();

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

	private void initChrono() {
		HBox hbox = new HBox();
		lChrono = new Label();
		hbox.getChildren().add(lChrono);
		root.setBottom(hbox);

	}

	private void demarrerPartie() throws CandyException {
		dessinerPlateau();

		timeline.play();
		timelineChrono.play();

		/**
		 * Si on veut suspendre le dÃ©roulement d'une timeline --> timeline.pause() Si
		 * on veut l'arrÃªter --> timeline.stop()
		 */
	}

	void initGrille() {

		grillePane = new Canvas(640, 640);

		((BorderPane) root).setCenter(grillePane);

		gc = grillePane.getGraphicsContext2D();

		grillePane.setOnDragDetected(new DragDetectedEvent(this)); // Si on veut inactiver le DnD -->
																	// grillePane.setOnDragDetected(null)
		grillePane.setOnDragOver(new DragOverEvent());
		grillePane.setOnDragDropped(new DragDroppedEvent(this));

	}

	private void initTimelineChrono() {
		// Cette KeyFrame apparaÃ®t 1s aprÃ¨s le dÃ©but de la timeline
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
				lChrono.setText("" + m + "m " + s + "s");
			}
		});

		timelineChrono = new Timeline(k);
		// La timeline va boucler Ã  l'infinie. Donc la keyframe k sera bien
		// dclenchÃ©e
		// toutes les secondes
		timelineChrono.setCycleCount(Animation.INDEFINITE);
	}

	private void initTimelineJeu() {
		final KeyFrame keyframe1 = new KeyFrame(Duration.seconds(0), new KeyFrame1(this));
		// Cette KF sera affichee tout de suite et restera jusqu'� la prochaine KF

		final KeyFrame keyframe2 = new KeyFrame(Duration.seconds(TEMPS_AFFICHAGE_KEYFRAME1), new KeyFrame2(this));
		// Cette KF2 sera affichee apr�s 0.1s c-�-d la duree que l'on a defini pour la
		// KF1
		final KeyFrame keyframe3 = new KeyFrame(Duration.seconds(TEMPS_AFFICHAGE_KEYFRAME2), new KeyFrame3(this));

		timeline = new Timeline(keyframe1, keyframe2, keyframe3);
		timeline.setCycleCount(Animation.INDEFINITE); // L'animation va Ã©galement boucler Ã  l'infinie
	}

	@SuppressWarnings("unused")
	private int getCandie() {
		return secondesEcoulees;
	}

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

	@SuppressWarnings("unused")
	private void initImagesCandies() {
		candies = new Image[NOMBRE_DE_CANDIES];
		/*
		 * try { for (int i = 0; i < candies.length; i++) { candies[i] = new
		 * Image(getClass().getResourceAsStream("/Candy_" + i + ".png")); } } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
	}

	public abstract boolean isFin();

	public abstract void afficherFin();

	/*
	 * ----+-------------------+ | GETTERS / SETTERS | +-----------------------+
	 *
	 */

	public Grille getGrille() {
		return grille;
	}

	public void setGrille(Grille g) {
		grille = g;
	}

	public Image[] getCandies() {
		return candies;
	}

	public void setCandies(Image[] candies) {
		this.candies = candies;
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

}
