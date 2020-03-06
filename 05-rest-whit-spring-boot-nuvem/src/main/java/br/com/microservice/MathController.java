package br.com.microservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.exception.UnsuportedMathOperationException;

@RestController
public class MathController {

	// para ser reconhecido como Endpoint Rest esse método
	// SOMA
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)	throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a numeric value ");

		}
		
		//calculo da soma
		Double sum = convertToDoble(numberOne) + convertToDoble(numberTwo);
		return sum;

	}
	
	// Subtraction
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)	throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a numeric value ");

		}
		
		//calculo da Subtração
		Double sum = convertToDoble(numberOne) - convertToDoble(numberTwo);
		return sum;

	}

	// multiplication
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)	throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a numeric value ");

		}
		
		//calculo da multiplication
		Double sum = convertToDoble(numberOne) * convertToDoble(numberTwo);
		return sum;

	}
	
	// division
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)	throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a numeric value ");

		}
		
		//calculo da division
		Double sum = convertToDoble(numberOne) / convertToDoble(numberTwo);
		return sum;

	}

	// mean
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)	throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a numeric value ");

		}
		
		//calculo da média
		Double sum = convertToDoble(numberOne) + convertToDoble(numberTwo)/2;
		return sum;

	}
	
	
	// squareRoot
	@RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number)	throws Exception {

		if (!isNumeric(number)) {
			throw new UnsuportedMathOperationException("please set a numeric value ");

		}
		
		//calculo da Raiz Quadrada
		Double sum = (Double) Math.sqrt(convertToDoble(number));
		return sum;

	}
	
	
	
	private Double convertToDoble(String strNumber) {
		if (strNumber == null) return 0D;		
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number))return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;		
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		
	}

}
