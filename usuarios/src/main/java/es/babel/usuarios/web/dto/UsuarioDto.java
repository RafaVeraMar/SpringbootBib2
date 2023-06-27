package es.babel.usuarios.web.dto;

import lombok.Data;

@Data
public class UsuarioDto {
	private Integer id;
	private String nombre;
	private String apellidos;
	private String correo;
	private Integer telefono;
	private Boolean activo;
}
