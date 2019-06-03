package bonbon;

import javafx.scene.image.Image;

/**
 * Hérite de la classe Bonbon
 * Ce bonbon est généré lorsqu'un bonbon explose
 * @see Bonbon
 */
public class Vide extends Bonbon {
	
	public Vide() {
		super();
		setCouleur("Vide");
	}

	@Override
	public String getType() {
		return "Vide";
	}
	
	@Override
	public Image getImage() {
		return new Image(this.getCouleur() + ".png");
	}
}
