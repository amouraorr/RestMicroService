package br.com.microservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.exception.UnsuportedMathOperationException;
import br.com.microservice.math.SimpleMath;
import br.com.microservice.request.converters.NumberConverter;

@RestController
public class MathController {
	
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
	
	// Subtraction
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)	throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a numeric value ");

		}
		
		
		return math.subtraction(NumberConverter.convertToDoble(numberOne), NumberConverter.convertToDoble(numberTwo));

	}

	// multiplication
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)	throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a numeric value ");

		}
		
		
		return math.multiplication(NumberConverter.convertToDoble(numberOne), NumberConverter.convertToDoble(numberTwo));

	}
	
	// division
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)	throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a numeric value ");

		}
		
		
		return math.division(NumberConverter.convertToDoble(numberOne), NumberConverter.convertToDoble(numberTwo));

	}
	

	// mean
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)	throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a numeric value ");

		}
		
		
		return math.mean(NumberConverter.convertToDoble(numberOne), NumberConverter.convertToDoble(numberTwo));

	}
	
	
	// squareRoot
	@RequestMapping(value = "/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number)	throws Exception {

		if (!NumberConverter.isNumeric(number)) {
			throw new UnsuportedMathOperationException("please set a numeric value ");

		}
		
		
		return math.squareRoot(NumberConverter.convertToDoble(number));

	}


}
