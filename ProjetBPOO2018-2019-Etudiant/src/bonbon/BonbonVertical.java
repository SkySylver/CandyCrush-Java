package bonbon;

import javafx.scene.image.Image;

public class BonbonVertical extends Bonbon {

	public BonbonVertical() {
		super();
	}

	public BonbonVertical(String couleur) {
		super(couleur);
		img = new Image(this.getCouleur()+"V.png");

	}

	public String getType() {
		return "BonbonVertical";
	}
}
