package it.daniele.Exeption;

public class FindException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FindException(String messaggio) {
		super(messaggio);
	}

}
