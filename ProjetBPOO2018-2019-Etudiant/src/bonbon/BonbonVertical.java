package bonbon;

import javafx.scene.image.Image;

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
