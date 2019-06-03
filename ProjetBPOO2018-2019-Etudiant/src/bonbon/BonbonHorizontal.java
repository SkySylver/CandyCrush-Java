package bonbon;

import javafx.scene.image.Image;

/**
 * H�rite de la classe Bonbon
 * Ce bonbon a pour propri�t� d'exploser toute la ligne
 * @see Bonbon
 */
public class BonbonHorizontal extends Bonbon {

	public BonbonHorizontal() {
		super();
	}

	public BonbonHorizontal(String couleur) {
		super(couleur);
	}

	@Override
	public String getType() {
		return "BonbonHorizontal";
	}

	@Override
	public Image getImage() {
		return new Image(this.getCouleur() + "H.png");
	}
}
