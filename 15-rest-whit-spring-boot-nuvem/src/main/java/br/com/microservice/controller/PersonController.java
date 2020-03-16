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
import br.com.microservice.data.vo.v2.PersonVOV2;
import br.com.microservice.service.PersonServices;

@RestController
@RequestMapping("/person")
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
		
		
		//Versionamneto V2
		@PostMapping("/v2")
		public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {	
			return service.createV2(person);

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
