package es.babel.usuarios.web.rest;

import es.babel.usuarios.facades.UsuarioFacade;
import es.babel.usuarios.model.Usuario;
import es.babel.usuarios.web.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private UsuarioFacade facade;
    @Autowired
    public UsuarioController(UsuarioFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> obtenerUsuario(@PathVariable Integer id) {
        final UsuarioDto usuario = facade.getUsuario(id);
        return ResponseEntity.ok(Usuario);

    }
}
