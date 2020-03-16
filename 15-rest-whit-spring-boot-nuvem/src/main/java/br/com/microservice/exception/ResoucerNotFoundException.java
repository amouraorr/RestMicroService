package br.com.microservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*Sempre vai retornar:
	Retorno de um response status badRequest
*/

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResoucerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//construtor
	public ResoucerNotFoundException (String exception){
		super(exception);
	}
	
}
