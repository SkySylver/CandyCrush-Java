package bonbon;

import javafx.scene.image.Image;

public class BonbonHorizontal extends Bonbon {

	public BonbonHorizontal() {
		super();
	}

	public BonbonHorizontal(String couleur) {
		super(couleur);
		img = new Image(this.getCouleur()+"H.png");
	}


	public String getType() {
		return "BonbonHorizontal";
	}

}
