package es.babel.usuarios.web.dto.response;

import java.util.List;

import es.babel.usuarios.web.dto.UsuarioDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrestamosUsuarioResponse {
	private UsuarioDto usuario;
	private List<PrestamoResponse> prestamos;
}
