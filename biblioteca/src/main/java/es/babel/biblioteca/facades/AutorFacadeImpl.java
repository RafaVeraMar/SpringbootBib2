package es.babel.biblioteca.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.babel.biblioteca.mappers.AutorMapper;
import es.babel.biblioteca.mappers.modelo.Autor;
import es.babel.biblioteca.services.AutorService;
import es.babel.biblioteca.web.dto.request.AutorRequest;
import es.babel.biblioteca.web.dto.response.AutorResponse;

@Component
public class AutorFacadeImpl implements AutorFacade {
	
	private AutorService autorService;
	private AutorMapper autorMapper;
	
	@Autowired
	public AutorFacadeImpl(AutorService autorService, AutorMapper autorMapper) {
		this.autorService = autorService;
		this.autorMapper = autorMapper;
	}

	@Override
	public List<AutorResponse> getAutores() {
		final List<Autor> autores = autorService.getAutores();
		return autores.stream().map(autor -> autorMapper.toDtoResponse(autor)).toList();
	}

	@Override
	public AutorResponse getAutor(Integer id) {
		final Autor autor = autorService.getAutor(id);
		return autorMapper.toDtoResponse(autor);
	}

	@Override
	public AutorResponse editAutor(Integer id, AutorRequest autorRequest) {
		final Autor autor = autorService.editAutor(id, autorRequest.getNombre());
		return autorMapper.toDtoResponse(autor);
	}

	@Override
	public AutorResponse crearAutor(AutorRequest autorRequest) {
		final Autor autor = autorService.createAutor(autorMapper.toEntity(autorRequest));
		return autorMapper.toDtoResponse(autor);
	}

	@Override
	public AutorResponse eliminarAutor(Integer id) {
		final Autor autor = autorService.deleteAutor(id);
		return autorMapper.toDtoResponse(autor);
	}

}
