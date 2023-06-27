package es.babel.usuarios.facades;

import es.babel.usuarios.mappers.UsuarioMapper;
import es.babel.usuarios.model.Usuario;
import es.babel.usuarios.services.UsuarioService;
import es.babel.usuarios.web.dto.UsuarioDto;
import es.babel.usuarios.web.dto.request.PrestamoRequest;
import es.babel.usuarios.web.dto.response.PrestamosUsuarioResponse;
import org.springframework.stereotype.Component;

@Component
public class UsuarioFacadeImpl implements UsuarioFacade{
    private UsuarioService usuarioService;
    private UsuarioMapper usuarioMapper;

    public UsuarioFacadeImpl(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
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
        return null;
    }

    @Override
    public UsuarioDto deleteUsuario(Integer id) {
        return null;
    }

    @Override
    public PrestamosUsuarioResponse getPrestamos(Integer id) {
        return null;
    }

    @Override
    public PrestamosUsuarioResponse addLendToUser(Integer id, PrestamoRequest prestamoRequest) {
        return null;
    }

    @Override
    public PrestamosUsuarioResponse updateLendToUser(Integer idUsuario, Integer idPrestamo, PrestamoRequest prestamoRequest) {
        return null;
    }
}
