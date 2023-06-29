package es.babel.biblioteca.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.babel.biblioteca.mappers.modelo.Autor;
import es.babel.biblioteca.mappers.modelo.Documento;
import es.babel.biblioteca.mappers.modelo.Editorial;
import es.babel.biblioteca.web.dto.request.DocumentoReq;
import es.babel.biblioteca.web.dto.response.DocumentoResp;

@Component
public class DocumentoMapperImpl implements DocumentoMapper {

	@Override
	public DocumentoResp toDtoResp(Documento doc, List<Autor> autores) {
		final List<String> autoresStr = new ArrayList<>();
		autores.forEach(autor -> autoresStr.add(autor.getNombre()));
		return DocumentoResp.builder()
				.id(doc.getId())
				.titulo(doc.getTitulo())
				.subtitulo(doc.getSubtitulo())
				.idioma(doc.getIdioma())
				.tipo(doc.getTipo())
				.ruta(doc.getRuta())
				.descripcion(doc.getDescripcion())
				.palabrasClave(doc.getPalabrasClave())
				.editorial(doc.getEditorial().getNombre())
				.autores(autoresStr)
				.build();
	}

	@Override
	public Documento toEntity(DocumentoResp doc) {
		final Documento documento = new Documento();
		documento.setId(doc.getId());
		documento.setTitulo(doc.getTitulo());
		documento.setSubtitulo(doc.getSubtitulo());
		documento.setIdioma(doc.getIdioma());
		documento.setTipo(doc.getTipo());
		documento.setRuta(doc.getRuta());
		documento.setDescripcion(doc.getDescripcion());
		documento.setPalabrasClave(doc.getPalabrasClave());
		return documento;
	}

	@Override
	public Documento toEntity(DocumentoReq doc, Editorial editorial) {
		final Documento documento = new Documento();
		documento.setTitulo(doc.getTitulo());
		documento.setSubtitulo(doc.getSubtitulo());
		documento.setIdioma(doc.getIdioma());
		documento.setTipo(doc.getTipo());
		documento.setRuta(doc.getRuta());
		documento.setDescripcion(doc.getDescripcion());
		documento.setPalabrasClave(doc.getPalabrasClave());
		documento.setEditorial(editorial);
		return documento;
	}

}
