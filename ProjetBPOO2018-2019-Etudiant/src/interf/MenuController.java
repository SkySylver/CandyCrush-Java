package interf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptions.CandyException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {
	private Stage stage;
	private File dossier;
	private List<String> data;

	private Controller jeu;
	private File[] listNiveau;
	private int lvl;

	public MenuController(Stage s, String src) {
		stage = s;
		dossier = new File(src);
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

	public void getNextNiveau() throws CandyException {
		String tab[] = null;
		if (listNiveau.length < lvl) {
			System.out.println("Plus de niveaux");
			return;
		}
		System.out.println("Level : " + lvl);
		String src = listNiveau[lvl].getAbsolutePath();
		lvl++;
		data = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(src));
			String line;
			while ((line = reader.readLine()) != null) {
				data.add(line);
			}
			reader.close();
		} catch (Exception e1) {
			System.err.format("Exception occurred trying to read '%s'.", src);
			e1.printStackTrace();
		}

		tab = data.get(0).split(";");
		System.out.println("Passé");
		System.out.println(data.get(0));
		switch (tab[0]) {
		case "SANS_OBJECTIF":
			System.out.println("sans objectif");
			break;
		case "DEPLACEMENT_LIMITE":
			System.out.println("DEPLACEMENT_LIMITE");
			jeu = new ModeEchange(stage, this);
			System.out.println("skip");
			break;
		case "TEMPS_LIMITE":
			System.out.println("TEMPS_LIMITE");
			jeu = new ModeTimer(stage, this);
			break;
		case "ELIMINER_MERINGUE":
			System.out.println("meringue");
			jeu = new ModeMeringue(stage, this);
			break;
		default:
			throw new CandyException("Mode de jeu inexistant");
		}
	}

	@FXML
	private void clic(ActionEvent e) throws CandyException, InterruptedException {

		if (dossier.isDirectory()) {
			listNiveau = dossier.listFiles();
		} else
			System.out.println("Pas un dossier");

		getNextNiveau();
	}

	public void ViderJeu() {
		jeu = null;

	}

	public List<String> getData() {
		return data;
	}
}
