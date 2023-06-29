package es.babel.biblioteca.services;

import java.util.List;

import es.babel.biblioteca.mappers.modelo.Editorial;

public interface EditorialService {
	
	/**
	 * 
	 * @return List<Editorial>
	 */
	List<Editorial> getEditoriales();
	
	/**
	 * 
	 * @param id
	 * @return Editorial
	 */
	Editorial getEditorial(Integer id);
	
	/**
	 * 
	 * @param editorial
	 * @return Editorial
	 */
	Editorial createEditorial(String editorial);
	
	/**
	 * 
	 * @param id
	 * @param editorial
	 * @return Editorial
	 */
	Editorial setEditorial(Integer id, String editorial);
	
	/**
	 * 
	 * @param id
	 * @return Editorial
	 */
	Editorial deleteEditorial(Integer id);
	

}
