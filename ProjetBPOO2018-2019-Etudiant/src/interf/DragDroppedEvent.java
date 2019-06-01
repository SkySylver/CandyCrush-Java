package interf;

import exceptions.CandyException;
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

		try {
			echangerSourceTarget();
		} catch (CandyException e) {
			e.printStackTrace();
		}

		event.consume();
	}

	private void echangerSourceTarget() throws CandyException {
		// int ls = 0, cs = 0, lt = 0, ct = 0;

		/** coordonnÃ©es de la case de dÃ©part (s comme source) */
		con.setLs(con.getYd() / 64);
		con.setCs(con.getXd() / 64);
		con.setLt(con.getYf() / 64);
		con.setCt(con.getXf() / 64);

		if (con.getGrille().echange(con.getLs(), con.getCs(), con.getLt(), con.getCt())) {
			con.setNbEchanges(con.getNbEchanges()+1);
			con.getTimeline().play();
		}
	}
}