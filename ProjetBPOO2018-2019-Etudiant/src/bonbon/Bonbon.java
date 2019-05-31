package bonbon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.scene.image.Image;

/**
 * Bonbon est la classe mère de tout bonbon généré. Tout type de bonbon hérite
 * de cette classe.
 * 
 * @version 1.0
 */
public abstract class Bonbon {

	/**
	 * La couleur du bonbon, toujours définie
	 * 
	 * @see Bonbon#getCouleur()
	 * @see Bonbon#setCouleur(String)
	 */
	private String couleur;

	/**
	 * NBBONBONS définit les NBBONBONS+1 premières couleurs pouvant être générés
	 * aléatoirement dans la liste lesCouleurs Ici, seuls les 4 premières couleurs
	 * sont celle générées aléatoirement dans Bonbon()
	 *
	 * @see Bonbon#lesCouleurs
	 * @see Bonbon#Bonbon()
	 */
	private final static int NBBONBONS = 3;

	/**
	 * Cette liste correspond à celle des couleurs possibles des bonbons Si le
	 * bonbon peut être généré par défaut dans Bonbon:
	 * 	+ incrémenter NBBONBONS
	 * 	+ l'ajouter en début de liste
	 * Sinon juste le mettre en fin de liste
	 * 
	 * @see Bonbon#NBBONBONS
	 */
	ArrayList<String> lesCouleurs = new ArrayList<String>(
			Arrays.asList("Bleu", "Vert", "Jaune", "Violet", "Meringue", "Vide"));

	
	/**
	 * Génère un Bonbon
	 * 
	 * La couleur sera générée automatiquement depuis la liste lesCouleurs
	 * @see Bonbon#lesCouleurs
	 */
	public Bonbon() {

		Random random = new Random();

		this.setCouleur(lesCouleurs.get(random.nextInt(NBBONBONS)));
	}

	
	/**
	 * Génère un bonbon avec un couleur définie
	 * 
	 * @param couleur
	 * 		La couleur du bonbon
	 */
	public Bonbon(String couleur) {
		this.setCouleur(couleur);
	}

	/**
	 * Retourne la couleur de ce Bonbon
	 * 
	 * @return la couleur du bonbon
	 */
	public String getCouleur() {
		return this.couleur;
	}

	/**
	 * 
	 * @param couleur
	 *		La couleur par la quelle on veut remplacer le Bonbon
	 */
	public void setCouleur(String couleur) {
		if (!lesCouleurs.contains(couleur))
			throw new IllegalArgumentException("Couleur incorrecte");
		else
			this.couleur = couleur;
	}

	/**
	 * @return le type du Bonbon
	 */
	public abstract String getType();

	/**
	 * 
	 * @return l'image associé au Bonbon
	 */
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
