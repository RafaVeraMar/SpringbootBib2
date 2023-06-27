package es.babel.biblioteca.mappers;

import org.springframework.stereotype.Component;

import es.babel.biblioteca.modelo.Editorial;
import es.babel.biblioteca.web.dto.response.EditorialResp;

@Component
public class EditorialMapperImpl implements EditorialMapper {

	@Override
	public EditorialResp toDtoResponse(Editorial editorial) {
		return EditorialResp.builder().id(editorial.getId()).nombre(editorial.getNombre()).build();
	}

}
