package es.babel.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import es.babel.biblioteca.modelo.Escrito;

public interface EscritoRepository extends CrudRepository<Escrito, Integer>{

	@Query("SELECT e FROM Escrito e WHERE e.idDocumento=:idDocumento")
	List<Escrito> findByDocumento(Integer idDocumento);
	
//	@Modifying
//	@Query("DELETE FROM Escrito e WHERE e.idDocumento=:idDocumento")
	@Transactional
	void deleteByIdDocumento(Integer idDocumento);
}
