package exceptions;

/**
 * Classe Exception pour les erreurs du jeu Candy Crush
 * H�rite d'Exception
 */
public class CandyException extends Exception {

	private static final long serialVersionUID = 1L;

	public CandyException(String msg) {
		super(msg);
	}
}
