package bonbon;

import javafx.scene.image.Image;

/**
 * H�rite de la classe Bonbon
 * Ce bonbon a pour propri�t� d'exploser tout seul
 * @see Bonbon
 */
public class BonbonSimple extends Bonbon {
	
	public BonbonSimple() {
		super();
	}

	public BonbonSimple(String couleur) {
		super(couleur);
	}

	@Override
	public String getType() {
		return "BonbonSimple";
	}

	@Override
	public Image getImage() {
		return new Image(this.getCouleur() + ".png");
	}
}
