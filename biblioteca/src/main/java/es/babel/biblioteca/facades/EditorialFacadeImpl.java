package es.babel.biblioteca.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.babel.biblioteca.mappers.EditorialMapper;
import es.babel.biblioteca.mappers.modelo.Editorial;
import es.babel.biblioteca.services.EditorialService;
import es.babel.biblioteca.web.dto.request.EditorialReq;
import es.babel.biblioteca.web.dto.response.EditorialResp;

@Component
public class EditorialFacadeImpl implements EditorialFacade {
	
	private EditorialService service;
	private EditorialMapper mapper;
	
	@Autowired
	public EditorialFacadeImpl(EditorialService service, EditorialMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@Override
	public List<EditorialResp> getEditoriales() {
		final List<Editorial> editoriales = service.getEditoriales();
		return editoriales.stream().map(e -> mapper.toDtoResponse(e)).toList();
	}

	@Override
	public EditorialResp getEditorial(Integer id) {
		final Editorial editorial = service.getEditorial(id);
		return mapper.toDtoResponse(editorial);
	}

	@Override
	public EditorialResp createEditorial(EditorialReq editorial) {
		final Editorial e = service.createEditorial(editorial.getNombre());
		return mapper.toDtoResponse(e);
	}

	@Override
	public EditorialResp editEditorial(Integer id, EditorialReq editorial) {
		final Editorial e = service.setEditorial(id, editorial.getNombre());
		return mapper.toDtoResponse(e);
	}

	@Override
	public EditorialResp deleteEditorial(Integer id) {
		final Editorial editorial = service.deleteEditorial(id);
		return mapper.toDtoResponse(editorial);
	}

}
