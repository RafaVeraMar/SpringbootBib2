package es.babel.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.babel.biblioteca.mappers.modelo.Documento;
import es.babel.biblioteca.repositories.DocumentoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DocumentosServiceImpl implements DocumentosService {
	
	private DocumentoRepository repository;
	
	@Autowired
	public DocumentosServiceImpl(DocumentoRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Documento> getDocumentos() {
		return repository.findAll();
	}

	@Override
	public Documento getDocumento(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Documento with ID: " + id + " NOT FOUND"));
	}

	@Override
	public Documento createDocumento(Documento documento) {
		return repository.save(documento);
	}

	@Override
	public Documento editDocumento(Integer id, Documento doc) {
		Documento documento = getDocumento(id);
		if (doc.getTitulo()!=null) {				
			documento.setTitulo(doc.getTitulo());
		}
		if (doc.getSubtitulo()!=null) {				
			documento.setSubtitulo(doc.getSubtitulo());
		}
		if (doc.getIdioma()!=null) {				
			documento.setIdioma(doc.getIdioma());
		}
		if (doc.getTipo()!=null) {				
			documento.setTipo(doc.getTipo());
		}
		if (doc.getRuta()!=null) {				
			documento.setRuta(doc.getRuta());
		}
		if (doc.getDescripcion()!=null) {				
			documento.setDescripcion(doc.getDescripcion());
		}
		if (doc.getPalabrasClave()!=null) {				
			documento.setPalabrasClave(doc.getPalabrasClave());
		}
		if (doc.getEditorial()!=null) {
			documento.setEditorial(doc.getEditorial());
		}
		return repository.save(documento);
	}

	@Override
	public Documento deleteDocumento(Integer id) {
		final Documento documento = getDocumento(id);
		repository.deleteById(id);
		return documento;
	}

}
