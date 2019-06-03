package bonbon;

import javafx.scene.image.Image;

/**
 * Hérite de la classe Bonbon
 * Ce bonbon a pour propriété d'exploser toute sa colonne
 * @see Bonbon
 */
public class BonbonVertical extends Bonbon {

	public BonbonVertical() {
		super();
	}

	public BonbonVertical(String couleur) {
		super(couleur);

	}

	public String getType() {
		return "BonbonVertical";
	}

	public Image getImage() {
		return new Image(this.getCouleur() + "V.png");
	}
}
