package es.babel.biblioteca.web.dto.request;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentoReq {
	private String titulo;
	private String subtitulo;
	private String idioma;
	private String tipo;
	private String ruta;
	private String descripcion;
	private String palabrasClave;
	private Integer editorial;
	private List<Integer> autores;
}
