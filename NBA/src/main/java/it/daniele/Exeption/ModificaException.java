package it.daniele.Exeption;

public class ModificaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ModificaException(String messaggio) {
		super(messaggio);
	}

}
