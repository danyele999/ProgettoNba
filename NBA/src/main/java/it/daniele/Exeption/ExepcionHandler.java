package it.daniele.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExepcionHandler extends ResponseEntityExceptionHandler {

	private ResponseEntity<Object> costruisciRisposta(ApiError errore) {
		return new ResponseEntity<Object>(errore, errore.getStatus());
	}

	@ExceptionHandler(CreazioneException.class)
	protected ResponseEntity<Object> handlerCrea(CreazioneException ex) {
		ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		return costruisciRisposta(apiError);

	}

	@ExceptionHandler(ModificaException.class)
	protected ResponseEntity<Object> handlerModifica(ModificaException ex) {
		ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		return costruisciRisposta(apiError);

	}

	@ExceptionHandler(CancellaException.class)
	protected ResponseEntity<Object> handlerCancella(CancellaException ex) {
		ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		return costruisciRisposta(apiError);

	}

	@ExceptionHandler(FindException.class)
	protected ResponseEntity<Object> handlerFind(FindException ex) {
		ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		return costruisciRisposta(apiError);

	}

	@ExceptionHandler(GetException.class)
	protected ResponseEntity<Object> handlerGet(GetException ex) {
		ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		return costruisciRisposta(apiError);

	}

	@ExceptionHandler(KaboomException.class)
	protected ResponseEntity<Object> handlerKaboom(KaboomException ex) {
		ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		return costruisciRisposta(apiError);

	}

}
