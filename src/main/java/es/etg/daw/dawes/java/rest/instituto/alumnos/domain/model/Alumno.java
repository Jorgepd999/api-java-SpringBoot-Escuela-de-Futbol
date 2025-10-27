package es.etg.daw.dawes.java.rest.instituto.alumnos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Alumno {
    private int id;
    private String nombre;
    private String apellido;
    //private String dni;
    //private String email;
    //private boolean activo;
}
