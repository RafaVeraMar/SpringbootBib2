package es.babel.usuarios.repositories;

import es.babel.usuarios.model.Prestamo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository  extends CrudRepository<Prestamo, Integer> {

    // consulta básica por método de nombre
   //  List<Prestamo> findPrestamoByUsuario(Usuario usuario);

    // Consulta JPQL
    @Query("SELECT p FROM Prestamo p WHERE p.usuario.id = :idUsuario")
     List<Prestamo> findPrestamoByIdUsuario(Integer idUsuario);

    // Consulta nativa
   // @Query(value = "SELECT * FROM prestamo p WHERE p.usuario_id = :idUsuario", nativeQuery = true)// List<Prestamo> findPrestamoByIdUsuario(Integer idUsuario);

}


