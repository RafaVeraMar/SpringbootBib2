package es.babel.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.babel.biblioteca.modelo.Editorial;
import es.babel.biblioteca.repositories.EditorialRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EditorialServiceImpl implements EditorialService {
	
	private EditorialRepository repository;

	@Autowired
	public EditorialServiceImpl(EditorialRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Editorial> getEditoriales() {
		return repository.findAll();
	}

	@Override
	public Editorial getEditorial(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Editorial with ID: " + id + " NOT FOUND"));
	}

	@Override
	public Editorial createEditorial(String editorial) {
		final Editorial e = new Editorial();
		e.setNombre(editorial);
		return repository.save(e);
	}

	@Override
	public Editorial setEditorial(Integer id, String editorial) {
		Editorial e = getEditorial(id);
		e.setNombre(editorial);
		return repository.save(e);
	}

	@Override
	public Editorial deleteEditorial(Integer id) {
		final Editorial editorial = getEditorial(id);
		repository.deleteById(id);
		return editorial;
	}

}
