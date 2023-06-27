package es.babel.usuarios.services;

import java.sql.Date;
import java.util.List;

import es.babel.usuarios.model.Prestamo;

public interface PrestamoService {

	/**
	 * Obtener un Prestamo por ID
	 * @param id
	 * @return Prestamo
	 */
	Prestamo getPrestamo(Integer id);
	
	/**
	 * Crear un nuevo Prestamo
	 * @param prestamo
	 * @return Prestamo
	 */
	Prestamo createPrestamo(Prestamo prestamo);
	
	/**
	 * Editar un Prestamo
	 * @param id
	 * @param recogida
	 * @param devolucion
	 * @return Prestamo
	 */
	Prestamo editPrestamo(Integer id, Date recogida, Date devolucion);
	
	/**
	 * Eleminar un Prestamo
	 * @param id
	 * @return Prestamo
	 */
	Prestamo deletePrestamo(Integer id);
	
	/**
	 * Obtener listado de Prestamos por ID de usuario
	 * @param idUsuario
	 * @return List<Prestamo>
	 */
	List<Prestamo> getPrestamosByUsuarioId(Integer idUsuario);
}
