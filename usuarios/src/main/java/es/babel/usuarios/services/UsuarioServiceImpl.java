package es.babel.usuarios.services;

import es.babel.usuarios.model.Usuario;
import es.babel.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

private UsuarioRepository userRepository;
@Autowired
public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
    this.userRepository = usuarioRepository;
    }


    @Override
    public Usuario getUsuario(Integer id) {
    final Usuario usuario = userRepository.findById(id).orElse(new Usuario());
        return usuario;
    }

    @Override
    public Usuario createUsuario(Usuario user) {
        return userRepository.save(user);
    }

    @Override
    public Usuario editUsuario(Integer id, Usuario user) {
    final Usuario usuario = getUsuario(id);
    if(user.getNombre() != null) {
        usuario.setNombre(user.getNombre());
    }
    if (user.getApellidos() != null) {
        usuario.setApellidos((user.getApellidos()));
    }
    if (user.getCorreo() != null) {
        usuario.setCorreo(user.getCorreo());
    }
    if (user.getTelefono() != null) {
        usuario.setTelefono(user.getTelefono());
    }
        return null;
    }

    @Override
    public Usuario deleteUsuario(Integer id) {
    final Usuario usuario = getUsuario(id);
        return null;
    }
}
