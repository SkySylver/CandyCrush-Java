package bonbon;

import javafx.scene.image.Image;

public class BonbonSimple extends Bonbon {
	
	/**
	 * H�rite de la classe Bonbon
	 * Ce bonbon a pour propri�t� d'exploser tout seul
	 * @see Bonbon
	 */
	public BonbonSimple() {
		super();
	}

	public BonbonSimple(String couleur) {
		super(couleur);
	}

	public String getType() {
		return "BonbonSimple";
	}

	public Image getImage() {
		return new Image(this.getCouleur() + ".png");
	}
}
