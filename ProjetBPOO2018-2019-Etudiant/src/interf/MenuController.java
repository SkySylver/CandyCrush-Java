package interf;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
	private Stage stage;

	public MenuController(Stage s) {
		stage = s;
	}

	public void start() {
		FXMLLoader l = new FXMLLoader(getClass().getResource("Menu.fxml"));
		l.setController(this);
		Scene sc;
		try {
			sc = new Scene(l.load());
			stage.setScene(sc);
			stage.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	private void clic(ActionEvent e) {
		Button b = (Button) e.getSource();
		switch (b.getId()) {
		case "&":
		case "é":
		case "'":

		}

	}

}
