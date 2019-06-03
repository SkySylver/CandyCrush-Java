package interf;

import exceptions.CandyException;
import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/**
 * D�but du Drag And Drop
 *
 */
public class DragDetectedEvent implements EventHandler<MouseEvent> {
	private Controller con;
	
	/**
	 * @param c : Controller qui fait appel � cet Evenement
	 */
	DragDetectedEvent(Controller c) {
		con = c;
	}

	/**
	 * D�but du DnD (Drag and Drop)
	 */
	public void handle(MouseEvent event) {
		
		Dragboard db = con.getGrillePane().startDragAndDrop(TransferMode.ANY);

		/**
		 * CoordonnÃ©es du pixel de dÃ©part
		 */
		con.setXd((int) event.getX());
		con.setYd((int) event.getY());
		

		int l = con.getYd()/ 64;
		int c = con.getXd() / 64;

		/**
		 * On dÃ©finit l'image qui va suivre la souris pendant le DnD
		 */
		try {
			db.setDragView(con.getGrille().getImage(l, c));
		} catch (CandyException e) {
			e.printStackTrace();
		}

		ClipboardContent content = new ClipboardContent();
		content.putString("");
		db.setContent(content);

		event.consume();
	}
}
