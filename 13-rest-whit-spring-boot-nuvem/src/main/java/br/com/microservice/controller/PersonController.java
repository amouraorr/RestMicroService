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

import br.com.microservice.data.vo.PersonVO;
import br.com.microservice.service.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	//Aqui injeção de dependencia
		@Autowired
		private PersonServices services;
		
		@GetMapping
		public List<PersonVO> findAll() {	
			return services.findAll();
			
		}
		
		// para ser reconhecido como Endpoint Rest esse método
		
		// SOMA
		@GetMapping("/{id}")
		public PersonVO findById(@PathVariable("id") Long id) {	
			return services.findById(id);

		}
		
		//chama o service, cria o objeot e devove o jason POST
		@PostMapping
		public PersonVO create(@RequestBody PersonVO person) {	
			return services.create(person);

		}
		
		
		@PutMapping
		public PersonVO update(@RequestBody PersonVO person) {	
			return services.update(person);

		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable("id") Long id) {	
			 services.delete(id);
			 return ResponseEntity.ok().build();
		}


}
