package bonbon;

import javafx.scene.image.Image;

public class Vide extends Bonbon{
	public Vide() {
		super();
		setCouleur("Vide");
	}

	public String getType() {
		return "Vide";
	}
	
	public Image getImage() {
		return new Image(this.getCouleur() + ".png");
	}
}
