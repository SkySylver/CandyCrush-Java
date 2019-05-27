package interf;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;

public final class DragDroppedEvent implements EventHandler<DragEvent> {
	private Controller con;

	public DragDroppedEvent(Controller c) {
		con = c;
	}

	/**
	 * Fin du Drag and Drop
	 */
	public void handle(DragEvent event) {

		/**
		 * CoordonnÃ©es du pixel de fin
		 */
		con.setXf((int) event.getX());
		con.setYf((int) event.getY());

		echangerSourceTarget();

		event.consume();
	}

	private void echangerSourceTarget() {
		int ls = 0, cs = 0, lt = 0, ct = 0;

		/** coordonnÃ©es de la case de dÃ©part (s comme source) */
		ls = con.getYd()/ 64;
		cs = con.getXd()/ 64;

		/** coordonnÃ©es de la case d'arrivÃ©e du DnD (t comme target) */
		lt = con.getYf() / 64;
		ct = con.getXf() / 64;

		/** On Ã©change les deux entiers, c'est tout ce que l'on fait dans la dÃ©mo */
		int temp = con.getGrille()[ls][cs];
		con.getGrille()[ls][cs] = con.getGrille()[lt][ct];
		con.getGrille()[lt][ct] = temp;
	}
}