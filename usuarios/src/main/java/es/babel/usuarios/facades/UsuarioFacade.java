package es.babel.usuarios.facades;

import es.babel.usuarios.web.dto.UsuarioDto;
import es.babel.usuarios.web.dto.request.PrestamoRequest;
import es.babel.usuarios.web.dto.response.PrestamosUsuarioResponse;

public interface UsuarioFacade {

	/**
	 * Obtener un usuario por ID
	 * @param id
	 * @return Usuario
	 */
	UsuarioDto getUsuario(Integer id);
	
	/**
	 * Crear un nuevo usuario
	 * @param user
	 * @return Usuario
	 */
	UsuarioDto createUsuario(UsuarioDto user);
	
	/**
	 * Editar un usuario
	 * @param id
	 * @param user
	 * @return Usuario
	 */
	UsuarioDto editUsuario(Integer id, UsuarioDto user);
	
	/**
	 * Eleminar un usuario
	 * @param id
	 * @return Usuario
	 */
	UsuarioDto deleteUsuario(Integer id);
	
	/**
	 * Obtener listado de prestamos por id de usuario
	 * @param id
	 * @return PrestamosUsuarioResponse
	 */
	PrestamosUsuarioResponse getPrestamos(Integer id);
	
	/**
	 * Añade un prestemao al usuario con ID dado
	 * @param id
	 * @param prestamoRequest
	 * @return PrestamosUsuarioResponse
	 */
	PrestamosUsuarioResponse addLendToUser(Integer id, PrestamoRequest prestamoRequest);
	
	/**
	 * Modifica un prestemao al usuario con ID dado
	 * @param idUsuario
	 * @param idPrestamo
	 * @param prestamoRequest
	 * @return PrestamosUsuarioResponse
	 */
	PrestamosUsuarioResponse updateLendToUser(Integer idUsuario, Integer idPrestamo, PrestamoRequest prestamoRequest);
}
