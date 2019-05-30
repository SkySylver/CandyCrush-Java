package bonbon;

import javafx.scene.image.Image;

public class BonbonHorizontal extends Bonbon {

	public BonbonHorizontal() {
		super();
	}

	public BonbonHorizontal(String couleur) {
		super(couleur);

	}

	public String getType() {
		return "BonbonHorizontal";
	}

	public Image getImage() {
		return new Image(this.getCouleur() + "H.png");
	}
}
