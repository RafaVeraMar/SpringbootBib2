package es.babel.biblioteca.facades;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import es.babel.biblioteca.mappers.DocumentoMapper;
import es.babel.biblioteca.mappers.modelo.Autor;
import es.babel.biblioteca.mappers.modelo.Documento;
import es.babel.biblioteca.mappers.modelo.Editorial;
import es.babel.biblioteca.services.AutorService;
import es.babel.biblioteca.services.DocumentosService;
import es.babel.biblioteca.services.EditorialService;
import es.babel.biblioteca.services.EscritoService;
import es.babel.biblioteca.web.dto.request.DocumentoReq;
import es.babel.biblioteca.web.dto.response.DocumentoResp;

@Component
public class DocumentoFacadeImpl implements DocumentoFacade {
	
	private DocumentosService docService;
	private EscritoService escritoService;
	private AutorService autorService;
	private EditorialService editorialService;

	private DocumentoMapper docMapper;
	
	@Autowired
	public DocumentoFacadeImpl(DocumentosService docService, EscritoService escritoService, AutorService autorService,
			EditorialService editorialService, DocumentoMapper docMapper) {
		super();
		this.docService = docService;
		this.escritoService = escritoService;
		this.autorService = autorService;
		this.editorialService = editorialService;
		this.docMapper = docMapper;
	}

	@Override
	public List<DocumentoResp> obtenerDocumentos() {
		final List<Documento> documentos = docService.getDocumentos();
		return documentos.stream().map(doc -> docMapper.toDtoResp(doc, autorService.getAutoresByDocumento(doc.getId()))).toList();
		/* Mapeo de autores programático
		final List<Autor> autores = autorService.getAutores();
		return documentos.stream().map(doc -> docMapper.toDtoResp(doc, autores.stream()
				.filter(autor -> escritoService.getEscritoByDocumento(doc.getId()).stream()
						.anyMatch(esc -> esc.getId().equals(autor.getId()))).toList())).toList();
		*/
	}

	@Override
	public DocumentoResp obtenerDocumento(Integer id) {
		final Documento documento = docService.getDocumento(id);
		return docMapper.toDtoResp(documento, autorService.getAutoresByDocumento(id));
	}

	@Override
	public DocumentoResp crearDocumento(DocumentoReq documentoReq) {
		final Editorial editorial = editorialService.getEditorial(documentoReq.getEditorial());
		final Documento documento = docService.createDocumento(docMapper.toEntity(documentoReq, editorial));
		
		final List<Autor> autores = new ArrayList<>();
		documentoReq.getAutores().forEach(id -> {
				final Autor autor = autorService.getAutor(id);
				if (autor.getId()!=null) {
					escritoService.createEscrito(documento.getId(), autor.getId());
					autores.add(autor);
				}
			});
		
		return docMapper.toDtoResp(documento, autores);
	}

	@Override
	public DocumentoResp editarDocumento(Integer id, DocumentoReq documentoReq) {
		final Editorial editorial = editorialService.getEditorial(documentoReq.getEditorial());
		final Documento documento = docService.editDocumento(id, docMapper.toEntity(documentoReq, editorial));
		final List<Autor> autores = new ArrayList<>();
		if (documento.getId()!=null) {
			if (!CollectionUtils.isEmpty(documentoReq.getAutores())) {
				escritoService.deleteByIdDocumento(id);
				documentoReq.getAutores().forEach(autorid -> {
					final Autor autor = autorService.getAutor(autorid);
					if (autor.getId()!=null) {
						escritoService.createEscrito(documento.getId(), autor.getId());
						autores.add(autor);
					}
				});
			} else {
				autores.addAll(autorService.getAutoresByDocumento(id));
			}
		}
		return docMapper.toDtoResp(documento, autores);
	}

	@Override
	public DocumentoResp eliminarDocumento(Integer id) {
		final List<Autor> autores = autorService.getAutoresByDocumento(id);
		final Documento doc = docService.deleteDocumento(id);
		return docMapper.toDtoResp(doc, autores);
	}

}
