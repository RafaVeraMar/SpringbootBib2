package es.babel.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.babel.biblioteca.modelo.Autor;
import es.babel.biblioteca.repositories.AutorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AutorServiceImpl implements AutorService {
	
	private AutorRepository autorRepository;

	@Autowired
	public AutorServiceImpl(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public List<Autor> getAutores() {
		final List<Autor> autores = autorRepository.findAll();
		return autores;
	}

	@Override
	public Autor getAutor(Integer id) {
		final Autor autor = autorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Autor with ID: " + id + " NOT FOUND"));
		return autor;
	}

	@Override
	public Autor editAutor(Integer id, String nombre) {
		Autor autor = getAutor(id);
		autor.setNombre(nombre);
		return autorRepository.save(autor);
	}

	@Override
	public Autor createAutor(Autor autor) {
		return autorRepository.save(autor);
	}

	@Override
	public Autor deleteAutor(Integer id) {
		final Autor autor = getAutor(id);
		autorRepository.delete(autor);
		return autor;
	}

	@Override
	public List<Autor> getAutoresByDocumento(Integer idDocumento) {
		return autorRepository.findByDocumento(idDocumento);
	}

}
