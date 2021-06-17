package it.daniele.Exeption;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {
	
	private String message;
	private HttpStatus status;
	private final String developer_reference = "Daniele-di-Epicode.it";
	
	
	@SuppressWarnings("unused")
	public ApiError(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
		String res = developer_reference;
		
	}

}
