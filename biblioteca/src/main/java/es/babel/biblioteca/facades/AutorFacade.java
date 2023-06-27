package es.babel.biblioteca.facades;

import java.util.List;

import es.babel.biblioteca.modelo.Autor;
import es.babel.biblioteca.web.dto.request.AutorRequest;
import es.babel.biblioteca.web.dto.response.AutorResponse;

public interface AutorFacade {

	/**
	 * Obtener todos los autores
	 * @return List<AutorResponse>
	 */
	List<AutorResponse> getAutores();
	
	/**
	 * Obtener autor por id
	 * @param id
	 * @return AutorResponse
	 */
	AutorResponse getAutor(Integer id);
	
	/**
	 * 
	 * @param id
	 * @param autorRequest
	 * @return AutorResponse
	 */
	AutorResponse editAutor(Integer id, AutorRequest autorRequest);
	
	/**
	 * 
	 * @param autorRequest
	 * @return
	 */
	AutorResponse crearAutor(AutorRequest autorRequest);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	AutorResponse eliminarAutor(Integer id);
}
