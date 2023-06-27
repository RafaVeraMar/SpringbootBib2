package es.babel.biblioteca.web.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentoResp {
	private Integer id;
	private String titulo;
	private String subtitulo;
	private String idioma;
	private String tipo;
	private String ruta;
	private String descripcion;
	private String palabrasClave;
	private String editorial;
	private List<String> autores;
}
