package es.babel.usuarios.services;

import es.babel.usuarios.model.Usuario;

public interface UsuarioService {

	/**
	 * Obtener un usuario por ID
	 * @param id
	 * @return Usuario
	 */
	Usuario getUsuario(Integer id);
	
	/**
	 * Crear un nuevo usuario
	 * @param user
	 * @return Usuario
	 */
	Usuario createUsuario(Usuario user);
	
	/**
	 * Editar un usuario
	 * @param id
	 * @param user
	 * @return Usuario
	 */
	Usuario editUsuario(Integer id, Usuario user);
	
	/**
	 * Eleminar un usuario
	 * @param id
	 * @return Usuario
	 */
	Usuario deleteUsuario(Integer id);
	
}
