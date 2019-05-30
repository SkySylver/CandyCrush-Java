package bonbon;

import javafx.scene.image.Image;

public class Meringue extends Bonbon{	
	public Meringue() {
		super();
		setCouleur("Meringue");
	}

	public String getType() {
		return "Meringue";
	}
	
	public Image getImage() {
		return new Image(this.getCouleur() + ".png");
	}
}
