package es.babel.usuarios.facades;

import es.babel.usuarios.mappers.UsuarioMapper;
import es.babel.usuarios.model.Prestamo;
import es.babel.usuarios.model.Usuario;
import es.babel.usuarios.services.BibliotecaService;
import es.babel.usuarios.services.PrestamoService;
import es.babel.usuarios.services.UsuarioService;
import es.babel.usuarios.web.dto.UsuarioDto;
import es.babel.usuarios.web.dto.request.PrestamoRequest;
import es.babel.usuarios.web.dto.response.PrestamoResponse;
import es.babel.usuarios.web.dto.response.PrestamosUsuarioResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioFacadeImpl implements UsuarioFacade{
    private UsuarioService usuarioService;
    private UsuarioMapper usuarioMapper;
    private PrestamoService prestamoService;
    private BibliotecaService bibliotecaService;


    public UsuarioFacadeImpl(UsuarioService usuarioService, UsuarioMapper usuarioMapper, PrestamoService prestamoService, BibliotecaService bibliotecaService) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
        this.prestamoService = prestamoService;
        this.bibliotecaService = bibliotecaService;
    }

    @Override
    public UsuarioDto getUsuario(Integer id) {
        final Usuario usuario = usuarioService.getUsuario(id);
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDto createUsuario(UsuarioDto user) {
        final Usuario usuario = usuarioService.createUsuario(usuarioMapper.toEntity(user));
        return usuarioMapper.toDto(usuario);
    }
// TODO: completar el resto
    @Override
    public UsuarioDto editUsuario(Integer id, UsuarioDto user) {
        final Usuario usuario = usuarioService.editUsuario(id,usuarioMapper.toEntity(user));
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDto deleteUsuario(Integer id) {
        final Usuario usuario = usuarioService.deleteUsuario(id);
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public PrestamosUsuarioResponse getPrestamos(Integer id) {

    final UsuarioDto usuario = usuarioMapper.toDto(usuarioService.getUsuario(id));
    final List<PrestamoResponse> prestamosUsuario = new ArrayList<>();
    final List<Prestamo> prestamos = prestamoService.getPrestamosByUsuarioId(id);
    prestamos.forEach(prestamo -> prestamosUsuario.add(toPrestamoResponse(prestamo)));
        return PrestamosUsuarioResponse.builder()
                .usuario(usuario)
                .prestamos(prestamosUsuario)
                .build();
    }
    @Override
    public PrestamosUsuarioResponse addLendToUser(Integer id, PrestamoRequest prestamoRequest) {
        Prestamo prestamo = new Prestamo();
        prestamo.setUsuario(usuarioService.getUsuario(id));
        prestamo.setDocumento(prestamoRequest.getDocumento());
        prestamo.setRecogida(prestamoRequest.getRecogida());
        prestamo.setDevolucion(prestamoRequest.getDevolucion());
        prestamo = prestamoService.createPrestamo(prestamo);
        return  getPrestamos(id);

        return null;
    }

    @Override
    public PrestamosUsuarioResponse updateLendToUser(Integer idUsuario, Integer idPrestamo, PrestamoRequest prestamoRequest) {
        prestamoService.editPrestamo(idPrestamo, prestamoRequest.getRecogida(), prestamoRequest.getDevolucion());
        return getPrestamos(idUsuario);

        return null;
    }
}
