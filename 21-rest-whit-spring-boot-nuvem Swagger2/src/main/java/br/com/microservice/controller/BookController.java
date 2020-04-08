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

import br.com.microservice.data.vo.v1.BookVO;
import br.com.microservice.service.BookServices;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {
	
	//Aqui injeção de dependencia
		@Autowired
		private BookServices service;
		
		@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml" })
		public List<BookVO> findAll() {	
			List<BookVO> books = service.findAll();
			books
				.stream()
				.forEach(p -> p.add(
						linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()
						)
					);
			return books;
			
		}
		
		// para ser reconhecido como Endpoint Rest esse método
		
		// SOMA
		@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml" })
		public BookVO findById(@PathVariable("id") Long id) {	
			BookVO bookVO = service.findById(id);
			bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
			return bookVO;

		}
		
		//chama o service, cria o objeot e devove o jason POST
		@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml" },
				consumes =  {"application/json", "application/xml", "application/x-yaml" })
		public BookVO create(@RequestBody BookVO book) {	
			BookVO bookVO = service.create(book);
			bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
			return bookVO;

		}
		
		
		@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml" },
				consumes =  {"application/json", "application/xml", "application/x-yaml" })
		public BookVO update(@RequestBody BookVO book) {	
			BookVO bookVO = service.update(book);
			bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
			return bookVO;

		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable("id") Long id) {	
			 service.delete(id);
			 return ResponseEntity.ok().build();
		}


}
