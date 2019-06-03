package bonbon;

import javafx.scene.image.Image;

/**
 * Hérite de la classe Bonbon
 * Ce bonbon a pour propriété de ne pas pouvoir être echangé
 * @see Bonbon
 */
public class Meringue extends Bonbon {

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
