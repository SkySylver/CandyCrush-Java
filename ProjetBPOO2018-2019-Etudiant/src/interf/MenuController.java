package interf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Open and read a file, and return the lines in the file as a list
	 * of Strings.
	 * (Demonstrates Java FileReader, BufferedReader, and Java5.)
	 */
	private List<String> readFile(String src)
	{
	  List<String> records = new ArrayList<String>();
	  try
	  {
	    BufferedReader reader = new BufferedReader(new FileReader(src));
	    String line;
	    while ((line = reader.readLine()) != null)
	    {
	      records.add(line);
	    }
	    reader.close();
	    return records;
	  }
	  catch (Exception e)
	  {
	    System.err.format("Exception occurred trying to read '%s'.", src);
	    e.printStackTrace();
	    return null;
	  }
	}
	
	
	@SuppressWarnings("unused")
	private void StartFichier(String src) {
		ArrayList<String> fichier = (ArrayList<String>)readFile(src);
	}
	
	@FXML
	private void clic(ActionEvent e) throws CandyException{
		Button b = (Button) e.getSource();
		@SuppressWarnings("unused")
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
