package br.com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.data.vo.v1.PersonVO;
import br.com.microservice.service.PersonServices;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	//Aqui injeção de dependencia
		@Autowired
		private PersonServices service;
		
		@GetMapping
		public List<PersonVO> findAll() {	
			return service.findAll();
			
		}
		
		// para ser reconhecido como Endpoint Rest esse método
		
		// SOMA
		@GetMapping("/{id}")
		public PersonVO findById(@PathVariable("id") Long id) {	
			return service.findById(id);

		}
		
		//chama o service, cria o objeot e devove o jason POST
		@PostMapping
		public PersonVO create(@RequestBody PersonVO person) {	
			return service.create(person);

		}
		
		
		@PutMapping
		public PersonVO update(@RequestBody PersonVO person) {	
			return service.update(person);

		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable("id") Long id) {	
			 service.delete(id);
			 return ResponseEntity.ok().build();
		}


}
