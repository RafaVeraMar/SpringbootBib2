package es.babel.biblioteca.facades;

import java.util.List;

import es.babel.biblioteca.web.dto.request.EditorialReq;
import es.babel.biblioteca.web.dto.response.EditorialResp;

public interface EditorialFacade {

	/**
	 * 
	 * @return
	 */
	List<EditorialResp> getEditoriales();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	EditorialResp getEditorial(Integer id);
	
	/**
	 * 
	 * @param editorial
	 * @return
	 */
	EditorialResp createEditorial(EditorialReq editorial);
	
	/**
	 * 
	 * @param id
	 * @param editorial
	 * @return
	 */
	EditorialResp editEditorial(Integer id, EditorialReq editorial);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	EditorialResp deleteEditorial(Integer id);
}
