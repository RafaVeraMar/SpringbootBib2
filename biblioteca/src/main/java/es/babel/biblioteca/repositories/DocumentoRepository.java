package es.babel.biblioteca.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.babel.biblioteca.modelo.Documento;

public interface DocumentoRepository extends CrudRepository<Documento, Integer>{

	List<Documento> findAll();
}
