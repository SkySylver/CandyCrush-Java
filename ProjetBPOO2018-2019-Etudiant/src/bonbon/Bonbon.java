package bonbon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public abstract class Bonbon {

	private String couleur;
	ArrayList<String> lesCouleurs = new ArrayList<String>(Arrays.asList("Bleu", "Vert", "Jaune", "Violet", "Vide" , "Meringue"));

	public Bonbon() {
		Random random = new Random();

		this.setCouleur(lesCouleurs.get(random.nextInt(lesCouleurs.size())));
	}

	public Bonbon(String couleur) {
		this.setCouleur(couleur);
	}

	public String getCouleur(){
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		if (!lesCouleurs.contains(couleur))
			throw new IllegalArgumentException("Couleur incorrecte");
		else
			this.couleur = couleur;
	}

	public abstract void explose();
	public abstract String getType();
}
