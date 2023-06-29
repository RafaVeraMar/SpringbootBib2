package es.babel.biblioteca.services;

import java.util.List;

import es.babel.biblioteca.mappers.modelo.Documento;

public interface DocumentosService {

	/**
	 * 
	 * @return List<Documento>
	 */
	List<Documento> getDocumentos();
	
	/**
	 * 
	 * @param id
	 * @return Documento
	 */
	Documento getDocumento(Integer id);
	
	/**
	 * 
	 * @param documento
	 * @return Documento
	 */
	Documento createDocumento(Documento documento);
	
	/**
	 * 
	 * @param id
	 * @param doc
	 * @return Documento
	 */
	Documento editDocumento(Integer id, Documento doc);
	
	/**
	 * 
	 * @param id
	 * @return Documento
	 */
	Documento deleteDocumento(Integer id);
}
