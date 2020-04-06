package br.com.microservice.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo; 
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn; 

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
		
		@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml" })
		public List<PersonVO> findAll() {	
			return service.findAll();
			
		}
		
		// para ser reconhecido como Endpoint Rest esse método
		
		// SOMA
		@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml" })
		public PersonVO findById(@PathVariable("id") Long id) {	
			PersonVO personVO = service.findById(id);
			personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
			return personVO;

		}
		
		//chama o service, cria o objeot e devove o jason POST
		@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml" },
				consumes =  {"application/json", "application/xml", "application/x-yaml" })
		public PersonVO create(@RequestBody PersonVO person) {	
			return service.create(person);

		}
		
		
		@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml" },
				consumes =  {"application/json", "application/xml", "application/x-yaml" })
		public PersonVO update(@RequestBody PersonVO person) {	
			return service.update(person);

		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable("id") Long id) {	
			 service.delete(id);
			 return ResponseEntity.ok().build();
		}


}
