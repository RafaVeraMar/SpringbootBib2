package es.babel.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.babel.biblioteca.mappers.modelo.Escrito;
import es.babel.biblioteca.repositories.EscritoRepository;

@Service
public class EscritoServiceImpl implements EscritoService {
	
	private EscritoRepository repository;
	
	@Autowired
	public EscritoServiceImpl(EscritoRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Escrito> getEscritoByDocumento(Integer idDocumento) {
		return repository.findByDocumento(idDocumento);
	}

	@Override
	public Escrito createEscrito(Integer idDocumento, Integer idAutor) {
		final Escrito escrito = new Escrito();
		escrito.setIdDocumento(idDocumento);
		escrito.setIdAutor(idAutor);
		return repository.save(escrito);
	}
	
	@Override
	public void deleteByIdDocumento(Integer idDocumento) {
		repository.deleteByIdDocumento(idDocumento);
	}

}
