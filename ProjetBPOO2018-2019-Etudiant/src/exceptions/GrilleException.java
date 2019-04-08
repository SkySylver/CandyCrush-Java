package exceptions;

import java.lang.Exception;

public class GrilleException extends Exception {

	// j'ai pas trop compris, c'est quoi ça
	private static final long serialVersionUID = 1L;

	public GrilleException() {
		super();
	}

	public GrilleException(String msg) {
		super(msg);
	}
}
