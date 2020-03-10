package br.com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.model.Person;
import br.com.microservice.service.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	//Aqui injeção de dependencia
	@Autowired
	private PersonServices services;
	
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {	
		return services.findAll();
		
	}
	
	// para ser reconhecido como Endpoint Rest esse método
	
	// SOMA
	@RequestMapping(value = "/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id") String id) {	
		return services.findById(id);

	}
	


}
