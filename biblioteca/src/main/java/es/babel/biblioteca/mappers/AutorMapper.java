package es.babel.biblioteca.mappers;

import es.babel.biblioteca.modelo.Autor;
import es.babel.biblioteca.web.dto.request.AutorRequest;
import es.babel.biblioteca.web.dto.response.AutorResponse;

public interface AutorMapper {

	AutorResponse toDtoResponse(Autor autor);
	
	Autor toEntity(AutorRequest autor);
	
}
