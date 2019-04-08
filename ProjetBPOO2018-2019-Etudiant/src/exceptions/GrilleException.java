package exceptions;

import java.lang.Exception;

public class GrilleException extends Exception {

	private static final long serialVersionUID = 1L;

	public GrilleException() {
		super();
	}

	public GrilleException(String msg) {
		super(msg);
	}
}
