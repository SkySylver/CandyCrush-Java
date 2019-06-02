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
	private File dossier;

	public MenuController(Stage s, String src) {
		stage = s;
		dossier = new File(src);
		int i = 0;
		System.out.println(i);
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
	private void clic(ActionEvent e) throws CandyException {
		String tab[] = null;
		// setGrille("C:\\Users\\emin\\Desktop\\candy\\ProjetBPOO2018-2019-Etudiant\\plateaux\\niveau1.csv");

		if (dossier.isDirectory()) {
			System.out.println("C'est un dossier");
			File[] list = dossier.listFiles();
			if (list != null) {
				for (File f : list) {
					String src = f.getAbsolutePath();
					List<String> records = new ArrayList<String>();
					try {
						BufferedReader reader = new BufferedReader(new FileReader(src));
						String line;
						while ((line = reader.readLine()) != null) {
							records.add(line);
						}
						reader.close();
					} catch (Exception e1) {
						System.err.format("Exception occurred trying to read '%s'.", src);
						e1.printStackTrace();
					}

					tab = records.get(0).split(";");
					
					
					Controller m;
					switch (tab[0]) {
					case "SANS_OBJECTIF":
						System.out.println("sans objectif");
						break;
					case "DEPLACEMENT_LIMITE":						
						m = new ModeEchange(stage, records);
						break;
					case "TEMPS_LIMITE":
						m = new ModeTimer(stage, records);
						break;
					case "ELIMINER_MERINGUE":
						m = new ModeMeringue(stage, records);
						break;
					default:
						throw new CandyException("Mode de jeu inexistant");
					}

				}
			} else {
				System.err.println(dossier + " : Erreur de lecture.");
			}
		} else
			System.out.println("Pas un dossier");
	}
}
