package br.com.microservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static String template = "MicroService, %s!";
	
	private final AtomicLong counter = new AtomicLong();
	
	//para ser reconhecido como Endpoint Rest esse método
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value= "name", defaultValue= "Rest" ) String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
		
	}

}
