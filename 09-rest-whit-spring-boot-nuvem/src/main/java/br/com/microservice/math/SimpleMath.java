package br.com.microservice.math;


public class SimpleMath {
	
	//Soma
	public Double sum(Double firstNamber, Double secondNumber) {
		return firstNamber + secondNumber;
	}

	//Subtração
	public Double subtraction(Double firstNamber, Double secondNumber) {
		return firstNamber - secondNumber;
	}

	//Multiplicação
	public Double multiplication(Double firstNamber, Double secondNumber) {
		return firstNamber * secondNumber;
	}
	//Divisão
	public Double division(Double firstNamber, Double secondNumber) {
		return firstNamber / secondNumber;
	}

	//Média
	public Double mean(Double firstNamber, Double secondNumber) {
		return (firstNamber + secondNumber)/2;
	}

	//Raiz Quadrada
	public Double squareRoot(Double number) {
		return(Double) Math.sqrt(number);
	}
	
}


