package br.com.microservice.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.microservice.exception.ExceptionResponse;
import br.com.microservice.exception.ResoucerNotFoundException;

@RestControllerAdvice
@RestController
public class CustomizedResponseEntetyExceptionHandler extends ResponseEntityExceptionHandler {
	
	/* Vai tratar a mensagem
	 * 
	 * Devolver com:
	 * A Data
	 * A Mensagem da Exception
	 * A Descrição
	 * 
	 * */
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse>  handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
						new Date(),
						ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(ResoucerNotFoundException.class)
	public final ResponseEntity<ExceptionResponse>  handleBadExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
						new Date(),
						ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
