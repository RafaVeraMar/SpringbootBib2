package es.babel.biblioteca.facades;

import java.util.List;

import es.babel.biblioteca.web.dto.request.DocumentoReq;
import es.babel.biblioteca.web.dto.response.DocumentoResp;

public interface DocumentoFacade {

	/**
	 * 
	 * @return
	 */
	List<DocumentoResp> obtenerDocumentos();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	DocumentoResp obtenerDocumento(Integer id);
	
	/**
	 * 
	 * @param documentoReq
	 * @return
	 */
	DocumentoResp crearDocumento(DocumentoReq documentoReq);
	
	/**
	 * 
	 * @param id
	 * @param documentoReq
	 * @return
	 */
	DocumentoResp editarDocumento(Integer id, DocumentoReq documentoReq);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	DocumentoResp eliminarDocumento(Integer id);
}
