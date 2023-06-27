package es.babel.usuarios.mappers;

import es.babel.usuarios.model.Usuario;
import es.babel.usuarios.web.dto.UsuarioDto;
import org.mapstruct.Mapper;

@Mapper(componentModel= "spring")
public interface UsuarioMapper {
    Usuario toEntity(Usuario dto);
    UsuarioDto toDto(Usuario entity);

}
