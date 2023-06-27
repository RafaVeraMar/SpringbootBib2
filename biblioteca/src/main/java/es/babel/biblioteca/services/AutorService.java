package es.babel.biblioteca.services;

import java.util.List;

import es.babel.biblioteca.modelo.Autor;
import es.babel.biblioteca.web.dto.request.AutorRequest;

public interface AutorService {

	/**
	 * Obtener todos los autores
	 * @return List<Autor>
	 */
	List<Autor> getAutores();
	
	/**
	 * Obtener autor por id
	 * @param id
	 * @return Autor
	 */
	Autor getAutor(Integer id);
	
	/**
	 * Añadir un nuevo autor
	 * @param autor
	 * @return Autor
	 */
	Autor createAutor(Autor autor);
	
	/**
	 * Editar un autor
	 * @param id
	 * @param nombre
	 * @return Autor
	 */
	Autor editAutor(Integer id, String nombre);
	
	/**
	 * Eliminar un autor
	 * @param id
	 * @return Autor
	 */
	Autor deleteAutor(Integer id);
	
	/**
	 * Obtener los autores de un documento determinado
	 * @param idDocumento
	 * @return List<Autor>
	 */
	List<Autor> getAutoresByDocumento(Integer idDocumento);
	
}
