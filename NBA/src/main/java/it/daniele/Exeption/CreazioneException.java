package it.daniele.Exeption;

public class CreazioneException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CreazioneException(String messaggio) {
		super(messaggio);
	}

}
