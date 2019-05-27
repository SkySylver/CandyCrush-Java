package interf;

import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class DragDetectedEvent implements EventHandler<MouseEvent> {
	private Controller con;
	
	DragDetectedEvent(Controller c) {
		con = c;
	}

	/**
	 * DÃ©but du DnD (Drag and Drop)
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
		db.setDragView(con.getCandies()[con.getGrille()[l][c]]);

		ClipboardContent content = new ClipboardContent();
		content.putString("");
		db.setContent(content);

		event.consume();
	}
}
