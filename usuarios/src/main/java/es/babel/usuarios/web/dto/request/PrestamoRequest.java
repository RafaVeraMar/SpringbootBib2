package es.babel.usuarios.web.dto.request;

import java.sql.Date;

import lombok.Data;

@Data
public class PrestamoRequest {
	private Integer documento;
	private Date recogida;
	private Date devolucion;
}
