package es.babel.usuarios.services;

import es.babel.usuarios.model.Prestamo;
import es.babel.usuarios.repositories.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class PrestamoServiceImpl implements PrestamoService{
    private PrestamoRepository prestamoRepository;
    @Autowired
    public PrestamoServiceImpl(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public Prestamo getPrestamo(Integer id) {
        final Prestamo prestamo = prestamoRepository.findById(id).orElse(new Prestamo());
        return prestamo;
    }

    @Override
    public Prestamo createPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo editPrestamo(Integer id, Date recogida, Date devolucion) {
        final Prestamo p = getPrestamo(id);
        if (recogida != null) {
            p.setRecogida(recogida);
        }
        if (devolucion != null){
            p.setDevolucion(devolucion);
        }
        return prestamoRepository.save(p);
    }

    @Override
    public Prestamo deletePrestamo(Integer id) {
        final Prestamo prestamo = getPrestamo(id);
        prestamoRepository.delete(prestamo);
        return prestamo;
    }

    @Override
    public List<Prestamo> getPrestamosByUsuarioId(Integer idUsuario) {
        return prestamoRepository.findPrestamoByIdUsuario(idUsuario);
    }
}
