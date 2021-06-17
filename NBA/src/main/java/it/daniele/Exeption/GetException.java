package it.daniele.Exeption;

public class GetException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GetException(String messaggio) {
		super(messaggio);
	}

}
