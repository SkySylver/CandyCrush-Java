package interf;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public final class DragOverEvent implements EventHandler<DragEvent> {

	public DragOverEvent() {
	}

	public void handle(DragEvent event) {

		event.acceptTransferModes(TransferMode.ANY);
		event.consume();
	}
}