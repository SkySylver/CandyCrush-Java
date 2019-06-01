package interf;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public final class KeyFrame4 implements EventHandler<ActionEvent> {
	private Controller con;

	public KeyFrame4(Controller c) {
		con = c;
	}

	public void handle(ActionEvent event) {
		if (con.isFin()) {
			con.afficherFin();
		}
		con.getGc().clearRect(0, 0, 640, 640);

	}
}
