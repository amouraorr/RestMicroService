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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(value = "Person Alex", description = "Description for Alex", tags = {"Alex-Endpoint", "Test-Endpoit"})//outra opção
@Api(tags = "PersonEndpoint")
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	//Aqui injeção de dependencia
		@Autowired
		private PersonServices service;
		
		
		@ApiOperation (value = "Find All Alex Person")
		@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml" })
		public List<PersonVO> findAll() {	
			List<PersonVO> persons = service.findAll();
			persons
				.stream()
				.forEach(p -> p.add(
						linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()
						)
					);
			return persons;
			
		}
		
		// para ser reconhecido como Endpoint Rest esse método
		
		// SOMA
		@ApiOperation (value = "Find All Alex Person get")
		@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml" })
		public PersonVO findById(@PathVariable("id") Long id) {	
			PersonVO personVO = service.findById(id);
			personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
			return personVO;

		}
		
		//chama o service, cria o objeot e devove o jason POST
		@ApiOperation (value = "Find All Alex Person Post")
		@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml" },
				consumes =  {"application/json", "application/xml", "application/x-yaml" })
		public PersonVO create(@RequestBody PersonVO person) {	
			PersonVO personVO = service.create(person);
			personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
			return personVO;

		}
		
		@ApiOperation (value = "Find All Alex Person Put")
		@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml" },
				consumes =  {"application/json", "application/xml", "application/x-yaml" })
		public PersonVO update(@RequestBody PersonVO person) {	
			PersonVO personVO = service.update(person);
			personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
			return personVO;

		}
		
		@ApiOperation (value = "Find All Alex Person Delete")
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable("id") Long id) {	
			 service.delete(id);
			 return ResponseEntity.ok().build();
		}


}