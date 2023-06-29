package es.babel.biblioteca.services;

import java.util.List;

import es.babel.biblioteca.mappers.modelo.Escrito;

public interface EscritoService {

	/**
	 * 
	 * @param idDocumento
	 * @return
	 */
	List<Escrito> getEscritoByDocumento(Integer idDocumento);
	
	/**
	 * 
	 * @param idDocumento
	 * @param idAutor
	 * @return
	 */
	Escrito createEscrito(Integer idDocumento, Integer idAutor);

	/**
	 * 
	 * @param idDocumento
	 */
	void deleteByIdDocumento(Integer idDocumento);
}
