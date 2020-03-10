package br.com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
