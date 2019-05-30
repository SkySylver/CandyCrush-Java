package bonbon;

import javafx.scene.image.Image;

public class BonbonSimple extends Bonbon{

	public BonbonSimple() {
		super();
	}
	
	public BonbonSimple(String couleur) {
		super(couleur);

		img = new Image(this.getCouleur()+".png");
	}

	public String getType() {
		return "BonbonSimple";
	}
}
