package br.com.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.converter.DozerConverter;
import br.com.microservice.data.model.Book;
import br.com.microservice.data.vo.v1.BookVO;
import br.com.microservice.exception.ResoucerNotFoundException;
import br.com.microservice.repository.BookRepository;


//@Sevice - essa anotação serve para o spring cuida da injeção de dependencia da classe
@Service
public class BookServices {
	
	@Autowired
	BookRepository repository;

	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	

	
	public List<BookVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
		
	}
	
	public BookVO findById(Long id) {
	
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResoucerNotFoundException("No records found for this ID"));		
		return  DozerConverter.parseObject(repository.save(entity), BookVO.class);
		
	}
	
	public BookVO update(BookVO book) {		
		var entity = repository.findById(book.getKey())
				.orElseThrow(() -> new ResoucerNotFoundException("No records found for this ID"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLauchDate(book.getLauchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		//var vo = DozerConverter.parseObject(entity, BookVO.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
		
	public void delete(Long id) {
		
		Book entity = repository.findById(id)
				.orElseThrow(() -> new ResoucerNotFoundException("No records found for this ID"));
		repository.delete(entity);
		
	}

}