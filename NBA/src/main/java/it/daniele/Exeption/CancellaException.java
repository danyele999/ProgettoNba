package it.daniele.Exeption;

public class CancellaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CancellaException(String messaggio) {
		super(messaggio);
	}

}
