package bonbon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.scene.image.Image;


/** 
 * Bonbon est la classe m�re de tout bonbon g�n�r�.
 * Tout type de bonbon h�rite de cette classe.
 * @version 1.0
 */
public abstract class Bonbon {

	/**
	 * La couleur du bonbon, toujours d�finie
	 * @see Bonbon#getCouleur()
	 * @see Bonbon#setCouleur(String)
	 */
	private String couleur;
	
	/**
	 * NBBONBONS d�finit les NBBONBONS+1 premi�res couleurs pouvant �tre g�n�r�s al�atoirement dans la liste lesCouleurs
	 * Ici, seuls les 4 premi�res couleurs sont celle g�n�r�es al�atoirement dans Bonbon()
	 *
	 * @see Bonbon#lesCouleurs
	 * @see Bonbon#Bonbon()
	 */
	private final static int NBBONBONS = 3;
	
/*
 * Cette liste correspond � celle des couleurs possibles des bonbons
 * Si le bonbon peut �tre g�n�r� par d�faut dans Bonbon:
 * 	- incr�menter NBBONBONS
 * 	- l'ajouter en d�but de liste
 * 	sinon juste le mettre en fin de liste
 * 
 */
	ArrayList<String> lesCouleurs = new ArrayList<String>(
			Arrays.asList("Bleu", "Vert", "Jaune", "Violet", "Meringue", "Vide"));

	public Bonbon() {

		Random random = new Random();

		this.setCouleur(lesCouleurs.get(random.nextInt(NBBONBONS)));
	}

	public Bonbon(String couleur) {
		this.setCouleur(couleur);
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		if (!lesCouleurs.contains(couleur))
			throw new IllegalArgumentException("Couleur incorrecte");
		else
			this.couleur = couleur;
	}

	public abstract String getType();

	public abstract Image getImage();

	public boolean isRaye() {
		if (this.getType().equals("BonbonHorizontal") || this.getType().equals("BonbonVertical"))
			return true;
		else
			return false;
	}

	public String toString() {
		return "Bonbon [couleur=" + couleur + ", lesCouleurs=" + lesCouleurs + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bonbon other = (Bonbon) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (lesCouleurs == null) {
			if (other.lesCouleurs != null)
				return false;
		} else if (!lesCouleurs.equals(other.lesCouleurs))
			return false;
		return true;
	}
}
