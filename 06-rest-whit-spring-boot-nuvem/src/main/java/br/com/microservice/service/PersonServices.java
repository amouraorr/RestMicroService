package br.com.microservice.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.microservice.model.Person;


//@Sevice - essa anotação serve para o spring cuida da injeção de dependencia da classe
@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person findyById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Alexsandro");
		person.setLastName("Mourão");
		person.setAdress("São Paulo - São Paulo/ Brasil");
		person.setGender("Male");
		return person ;
		
	}

}
