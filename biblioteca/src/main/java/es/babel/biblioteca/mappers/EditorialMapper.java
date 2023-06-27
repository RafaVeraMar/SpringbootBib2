package es.babel.biblioteca.mappers;

import es.babel.biblioteca.modelo.Editorial;
import es.babel.biblioteca.web.dto.response.EditorialResp;

public interface EditorialMapper {

	EditorialResp toDtoResponse(Editorial editorial);
}
