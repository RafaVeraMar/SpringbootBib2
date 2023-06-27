package es.babel.usuarios.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Data
@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Integer id;
    private Integer documento;

    private Date recogida;
    private Date devolucion;

    @ManyToOne
    @JoinColumn(name="usuario:id", insertable = true, updatable = true)
    private Usuario usuario;
}
