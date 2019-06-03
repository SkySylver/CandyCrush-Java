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
	// Stage dans lequel on affiche ce Menu
	private Stage stage;

	// Dossier des plateaux
	private File dossier;

	private List<String> data;

	@SuppressWarnings("unused")
	private Controller jeu;
	private File[] listNiveau;
	private int lvl;

	/**
	 * 
	 * @param s:  Stage dans lequel afficher ce Menu
	 * @param src : Dossier des plateaux
	 */
	public MenuController(Stage s, String src) {
		stage = s;
		dossier = new File(src);
	}

	/**
	 * Load le Menu (fxml) et l'affiche
	 */
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
	 * Passe au prochain niveau dans la listNiveau et crée un nouveau mode de jeu
	 * S'il n'y a plus de niveau : c'est gagné
	 * Pas d'affichage pour dire que c'est gagné (il faudrait faire une nouvelle scene)
	 * 
	 * @see ModeEchange#ModeEchange(Stage, MenuController)
	 * @see ModeMeringue#ModeMeringue(Stage, MenuController)
	 * @see ModeSansObjectif#ModeSansObjectif(Stage, MenuController)
	 * @see ModeTimer#ModeTimer(Stage, MenuController)
	 * 
	 * @throws CandyException
	 */
	public void getNextNiveau() throws CandyException {
		String tab[] = null;
		if (listNiveau.length <= lvl) {
			System.out.println("Plus de niveaux : C'EST GAGNE");
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
			jeu = new ModeSansObjectif(stage, this);
			break;
		case "DEPLACEMENT_LIMITE":
			System.out.println("DEPLACEMENT_LIMITE");
			jeu = new ModeEchange(stage, this);
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

	/**
	 * Charge la listes des plateaux csv dans listNiveau
	 * 
	 * @see MenuController#getNextNiveau()
	 * @throws CandyException
	 * @throws InterruptedException
	 */
	@FXML
	private void clic() throws CandyException, InterruptedException {
		if (dossier.isDirectory()) {
			listNiveau = dossier.listFiles();
		} else
			throw new CandyException("La source des niveaux n'est pas un dossier");
		
		getNextNiveau();
	}

	/**
	 * Retourne la liste des lignes du fichier csv en cour d'utilisation
	 * @return data
	 */
	public List<String> getData() {
		return data;
	}
}
