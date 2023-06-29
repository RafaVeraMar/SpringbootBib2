package es.babel.usuarios.repositories;

import es.babel.usuarios.model.Prestamo;
import es.babel.usuarios.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig
@DataJpaTest
public class PrestamoRespositoryTest {
    @Autowired
    private PrestamoRepository repository;


    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findPrestamoByIdUsuarioTEst(){
        Usuario user = new Usuario();
        user.setNombre("Usuario");

        Prestamo p = new Prestamo();
        p.setDocumento(1);
        p.setUsuario(user);

        entityManager.persist(user);
        entityManager.persist(p);
        entityManager.flush();

        List<Prestamo> prestamos = repository.findPrestamoByIdUsuario(1);

        assertNotNull(prestamos);
        assertEquals(1, prestamos.size());
        assertEquals(1,prestamos.get(0).getDocumento());

    }
}
