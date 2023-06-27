package es.babel.biblioteca.mappers;

import org.springframework.stereotype.Component;

import es.babel.biblioteca.modelo.Autor;
import es.babel.biblioteca.web.dto.request.AutorRequest;
import es.babel.biblioteca.web.dto.response.AutorResponse;

@Component
public class AutorMapperImpl implements AutorMapper {

	@Override
	public AutorResponse toDtoResponse(Autor autor) {
		return AutorResponse.builder().id(autor.getId()).nombre(autor.getNombre()).build();
	}

	@Override
	public Autor toEntity(AutorRequest autor) {
		final Autor entity = new Autor();
		entity.setNombre(autor.getNombre());
		return entity;
	}

}
