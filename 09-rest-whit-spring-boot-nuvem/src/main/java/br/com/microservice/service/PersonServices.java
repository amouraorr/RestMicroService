package br.com.microservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.microservice.model.Person;


//@Sevice - essa anotação serve para o spring cuida da injeção de dependencia da classe
@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Alexsandro");
		person.setLastName("Mourão");
		person.setAdress("São Paulo - São Paulo/ Brasil");
		person.setGender("Male");
		return person;
		
	}
	public List<Person> findAll() {		
		List<Person> persons = new ArrayList<Person>();
		
		for (int i = 0; i < 8 ; i++) {
			Person person = mockPerson(i);
			persons.add(person);
			
		}
		return persons;
		
	}
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name" + i);
		person.setLastName("Last Name" + i);
		person.setAdress("Some ddres in Brasil");
		person.setGender("Male");
		return person;
	}
}
