package it.daniele.Exeption;

public class KaboomException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public KaboomException(String messaggio) {
		super(messaggio);
	}

}
