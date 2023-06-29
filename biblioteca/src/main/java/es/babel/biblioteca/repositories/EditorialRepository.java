package es.babel.biblioteca.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.babel.biblioteca.mappers.modelo.Editorial;

public interface EditorialRepository extends CrudRepository<Editorial, Integer>{

	List<Editorial> findAll();
}
