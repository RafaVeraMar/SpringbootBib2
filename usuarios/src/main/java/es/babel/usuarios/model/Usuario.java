package es.babel.usuarios.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String ruta;
    private Integer telefono;
    private Boolean activo;
	
}
