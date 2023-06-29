package es.babel.biblioteca.mappers;

import java.util.List;

import es.babel.biblioteca.mappers.modelo.Autor;
import es.babel.biblioteca.mappers.modelo.Documento;
import es.babel.biblioteca.mappers.modelo.Editorial;
import es.babel.biblioteca.web.dto.request.DocumentoReq;
import es.babel.biblioteca.web.dto.response.DocumentoResp;

public interface DocumentoMapper {

	DocumentoResp toDtoResp(Documento doc, List<Autor> autores);
	
	Documento toEntity(DocumentoResp resp);
	
	Documento toEntity(DocumentoReq req, Editorial editorial);
}
