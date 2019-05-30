package interf;

import java.io.IOException;

import exceptions.CandyException;
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
	private void clic(ActionEvent e) throws CandyException{
		Button b = (Button) e.getSource();
		Controller m;
		switch (b.getId()) {

		case "Meringue":
			m = new ModeMeringue(stage);
			break;
		case "Timer":
			m = new ModeTimer(stage);
			break;
		case "Echange":
			m = new ModeEchange(stage);
			break;
		default:
			throw new CandyException("Mode de jeu inexistant");
		}

	}

}
