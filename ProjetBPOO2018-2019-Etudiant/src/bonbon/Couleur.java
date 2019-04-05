package bonbon;

import java.util.ArrayList;

public class Couleurs {

	ArrayList<String> lesCouleurs = new ArrayList<String>();

	ON PEUT AUSSI FAIRE CA:
	String couleurs[] = { "Bleu", "Jaune", "Vert", "Violet" };

	public Couleurs() {
		this.lesCouleurs.add("Bleu");
		this.lesCouleurs.add("Vert");
		this.lesCouleurs.add("Jaune");
		this.lesCouleurs.add("Violet");
	}

	public void add(String str) {
		if (str == null || str.trim().equals(""))
			throw new IllegalArgumentException("Nouvelle couleur invalide !");
		else
			lesCouleurs.add(str);
	}

	public boolean contains(String str) {
		if (lesCouleurs.contains(str))
			return true;
		else
			return false;
	}

}
