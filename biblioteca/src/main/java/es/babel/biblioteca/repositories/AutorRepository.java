package es.babel.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.babel.biblioteca.modelo.Autor;


public interface AutorRepository extends CrudRepository<Autor, Integer>{

	List<Autor> findAll();
	
	@Query("SELECT a FROM Autor a JOIN Escrito e ON a.id=e.idAutor WHERE e.idDocumento=:idDocumento")
	List<Autor> findByDocumento(Integer idDocumento);
}
