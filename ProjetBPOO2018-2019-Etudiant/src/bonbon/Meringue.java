package bonbon;

import javafx.scene.image.Image;

/**
 * H�rite de la classe Bonbon
 * Ce bonbon a pour propri�t� de ne pas pouvoir �tre echang�
 * @see Bonbon
 */
public class Meringue extends Bonbon {

	public Meringue() {
		super();
		setCouleur("Meringue");
	}

	@Override
	public String getType() {
		return "Meringue";
	}

	@Override
	public Image getImage() {
		return new Image(this.getCouleur() + ".png");
	}
}
