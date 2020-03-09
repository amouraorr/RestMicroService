package br.com.microservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.exception.UnsuportedMathOperationException;
import br.com.microservice.math.SimpleMath;
import br.com.microservice.request.converters.NumberConverter;

@RestController
public class PersonController {
	
	SimpleMath math = new SimpleMath();
	
	// para ser reconhecido como Endpoint Rest esse método
	
	// SOMA
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)	throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a numeric value ");

		}
		
		
		return math.sum(NumberConverter.convertToDoble(numberOne), NumberConverter.convertToDoble(numberTwo));

	}
	



}
